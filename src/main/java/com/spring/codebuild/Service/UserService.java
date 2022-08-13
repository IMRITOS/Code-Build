package com.spring.codebuild.Service;

import com.spring.codebuild.DAO.UserDAO;
import com.spring.codebuild.Helpers.JWT;
import com.spring.codebuild.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String getUser(HttpServletRequest request){
        JWT jwt = new JWT();
        String token = request.getHeader("Authourization");
        Map<String, Object> claims = jwt.getAllClaimsFromToken(token);
        String version = claims.get("Version").toString();
        String email = claims.get("Email").toString();
        User dataBaseUser = userDAO.checkUser(email);

        boolean correctVersion = jwt.validateVersion(version,dataBaseUser);
        if(correctVersion==false){
            return "Устаревший токен";
        }

        return dataBaseUser.toString();
    }
}
