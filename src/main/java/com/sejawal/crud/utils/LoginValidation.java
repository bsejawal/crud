package com.sejawal.crud.utils;

import com.sejawal.crud.vo.LoginRequest;

public class LoginValidation {

    public static boolean isUserNameAndPasswordValid(LoginRequest loginRequest){

        if(loginRequest.getUsername().length() > 12 || loginRequest.getPassword().length() > 12)
            return false;
        return true;

    }
}
