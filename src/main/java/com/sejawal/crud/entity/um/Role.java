package com.sejawal.crud.entity.um;

import com.sejawal.crud.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(
        name = "roles",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1)
public class Role extends BaseEntity {

    @Id
    @GeneratedValue
    private int id;
    private String name;
//    fetch = FetchType.EAGER, cascade = CascadeType.ALL
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();
}
