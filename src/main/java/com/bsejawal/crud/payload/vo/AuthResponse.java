package com.bsejawal.crud.payload.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String jwt;
    private List<String> roles = new ArrayList<>();

    public void setRoles(String s){
        StringBuffer sb= new StringBuffer(s);
        if(s.startsWith("["))
            sb.deleteCharAt(0);
        if(s.endsWith("]"))
            sb.deleteCharAt(sb.length() - 1);
        s= sb.toString().trim();
        if(s.contains(",")) {
            String[] array = s.split(",");
            roles = Arrays.asList(array);
        }else{
            roles.add(s);
        }
    }
}
