package com.spring.codebuild.Validators;

import com.spring.codebuild.models.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class UserValidator {

    public String checkLoginEmail(String email, User dataBaseUser) {
        boolean isEmpty = email.isEmpty();
        int emailLenght = email.length();
        Pattern pattern = Pattern.compile(".+\\.(com|ru)");
        Matcher matcher = pattern.matcher(email);
        boolean emailPattern = matcher.matches();

        if (isEmpty == true) {
            return "Email should not be empty";
        } else if (emailLenght > 42) {
            return "Email must be less than 42";
        } else if (emailPattern == false) {
            return "Incorrect email format";
        } else if (dataBaseUser == null) {
            return "This email does not exist";
        }

        return "";
    }

    public String checkSignEmail(String email, User dataBaseUser) {
        boolean isEmpty = email.isEmpty();
        int emailLenght = email.length();
        Pattern pattern = Pattern.compile(".+\\.(com|ru)");
        Matcher matcher = pattern.matcher(email);
        boolean emailPattern = matcher.matches();

        if (isEmpty == true) {
            return "Email should not be empty";
        } else if (emailLenght > 42) {
            return "Email must be less than 42";
        } else if (emailPattern == false) {
            return "Incorrect email format";
        } else if (dataBaseUser != null) {
            return "This email already exists";
        }

        return "";
    }

    public String checkCandidateEmail(String email, User candidate){
        if(candidate == null){
            return "Время на потверждение регистрации истекло";
        }

        return "";
    }

    public String checkPassword(String password, User candidate) {
        boolean isEmpty = password.isEmpty();

        if (isEmpty == true) {
            return "Password should not be empty";
        } else if (!password.equals(candidate.getPassword())) {
            return "Password invalid";
        }

        return "";
    }

    public String checkName(String name) {
        boolean isEmpty = name.isEmpty();
        int nameLength = name.length();
        Pattern pattern = Pattern.compile("[A-z]*[А-я]*[-]*");
        Matcher matcher = pattern.matcher(name);
        boolean namePattern = matcher.matches();

        if (isEmpty == true) {
            return "Name should not be empty";
        } else if (nameLength > 20) {
            return "Name must be less than 20";
        } else if (namePattern == false) {
            return "The name must contain only Cyrillic, Latin letters and a hyphen";
        }

        return "";
    }
}
