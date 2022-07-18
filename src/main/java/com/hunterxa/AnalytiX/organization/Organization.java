package com.hunterxa.AnalytiX.organization;

import com.hunterxa.AnalytiX.privilegeduser.PrivilegedUser;
import com.hunterxa.AnalytiX.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_name_constraint",
                        columnNames = "name"
                )
        },
        name = "organizations"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id")
@Builder
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
    @Transient
    private User creator;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "organization_member_mapping",
            joinColumns = @JoinColumn(
                    name = "fk_organization_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "fk_user_id",
                    referencedColumnName = "id"
            )
    )
    private List<User> members;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable()
//    private List<PrivilegedUser> privilegedMembers;

    public void addMember(User user) {
        members.add(user);
    }

    public void printMembersDev() {
        for (User m : members) System.out.println(m.toStringDev());
    }

}
