package com.sejawal.crud.vo;

import com.sejawal.crud.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
public class UserList {
    private List<User> userList = new ArrayList<>();
}
