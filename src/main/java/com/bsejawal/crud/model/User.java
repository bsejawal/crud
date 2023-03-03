package com.bsejawal.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "users", // table name is users, to avoid conflict, as h2 database has keyword 'user' already
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"})
        }
)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username is mandatory")
    private String username;

    @NotNull(message = "Password is mandatory")
    private String password;

//    const USER_REGEX = /^[a-zA-Z][a-zA-Z0-9-_]{3,23}$/;
//const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;

//roles by default ROLE_USER will be assigned
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = null;

//
//    public void setRole_s(String roles){
//        if(roles != null) {
//            StringBuffer sb = new StringBuffer(roles);
//            if (roles.startsWith("["))
//                sb.deleteCharAt(0);
//            if (roles.endsWith("]"))
//                sb.deleteCharAt(sb.length() - 1);
//            roles = sb.toString().trim();
//
//
//            if (roles.contains(",")) {
//                roles = roles.replaceAll("\\s", "");
//                this.roles = Arrays.stream(roles.split(","))
//                        .map(Role::new)
//                        .collect(Collectors.toSet());
//            } else if (roles.contains(" ")) {
//                roles = roles.trim();
//                this.roles = Arrays.stream(roles.split(" "))
//                        .map(Role::new)
//                        .collect(Collectors.toSet());
//            } else {
//                this.roles = new HashSet<>(Arrays.asList(new Role(roles)));
//            }
//        }else{
//            this.roles = new HashSet<>(Arrays.asList(new Role("ROLE_USER")));
//        }
//    }

}
