package com.spring.codebuild.controlles;

import com.spring.codebuild.Helpers.JWT;
import com.spring.codebuild.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userUpService;

    @Autowired
    public UserController(UserService userUpService) {
        this.userUpService = userUpService;
    }

    public ResponseEntity showUser(HttpServletRequest request){


        return ResponseEntity.ok(user);
    }
}
