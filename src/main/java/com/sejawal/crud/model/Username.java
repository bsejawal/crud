package com.sejawal.crud.model;

import com.sejawal.crud.UsernameType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "username_id_seq", sequenceName = "username_id_seq", allocationSize = 1)
public class Username {

    @Id
    @ManyToOne
    @JoinColumn(name="username", nullable=false)
    private String username;

    @Column(nullable = false)
    private UsernameType usernameType;


    @CreationTimestamp
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

}
