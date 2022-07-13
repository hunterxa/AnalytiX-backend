package com.hunterxa.AnalytiX.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "unique_user_email_constraint",
                columnNames = "email"
        )
    },
    name = "users"
)
@Data
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    private String email;
    private String username;
    private String name;

    public User(String email, String username, String name) {
        this.email = email;
        this.username = username;
        this.name = name;
    }

    public User(Long id, String email, String username, String name) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.name = name;
    }

}
