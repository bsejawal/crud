package com.sejawal.crud;

public enum UsernameType {
    EMAIL(1), PHONE(2),OTHER(3);
    int type;
    UsernameType(int type){
        this.type = type;
    }
}
