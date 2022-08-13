package com.spring.codebuild.controlles;

import com.spring.codebuild.Service.SignUpService;
import com.spring.codebuild.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class SignUpController {

    private final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping("/sign")
    public ResponseEntity sign(@RequestBody User user) {
        String message = signUpService.sign(user);

        return ResponseEntity.ok(message);
    }

    @PostMapping("confirm-sign")
    public ResponseEntity confirmSign(@RequestBody User user) {
        String message = signUpService.confirm(user);

        return ResponseEntity.ok(message);
    }

}
