package com.hunterxa.AnalytiX.organization;

import com.hunterxa.AnalytiX.privilegeduser.PrivilegedUser;
import com.hunterxa.AnalytiX.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organizations")
@Data
@NoArgsConstructor
@ToString(exclude = "id")
public class Organization {

    @Id
    @SequenceGenerator(
            name = "organization_sequence",
            sequenceName = "organization_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "organization_sequence"
    )
    private Long id;
    private String name;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "organization_member_mapping",
//            joinColumns = @JoinColumn(
//                    name = "fk_organization_id",
//                    referencedColumnName = "id"
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "fk_user_id",
//                    referencedColumnName = "id"
//            )
//    )
//    private List<User> members;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable()
//    private List<PrivilegedUser> privilegedUsers;

}
