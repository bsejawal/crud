package com.bsejawal.crud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
//import java.util.Arrays;
//import java.util.Set;
//import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"})
        }
)
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
//    )
//    private Set<Role> roles;
//
//    private void setRoles(String roles){
//    this.roles = Arrays.stream(roles.split(","))
//            .map(Role::new)
//                .collect(Collectors.toSet());
//    }

}
