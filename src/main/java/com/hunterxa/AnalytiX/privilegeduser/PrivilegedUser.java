package com.hunterxa.AnalytiX.privilegeduser;

import com.hunterxa.AnalytiX.user.User;
import com.hunterxa.AnalytiX.privilege.Privilege;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "privileged_users")
public class PrivilegedUser {

    @Id
    @SequenceGenerator(
            name = "privileged_user_sequence",
            sequenceName = "privileged_user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "privileged_user_sequence"
    )
    private Long id;
    private User user;
    private List<Privilege> privileges;
}
