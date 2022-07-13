package com.hunterxa.AnalytiX.privilege;

import javax.persistence.*;

@Entity
@Table(name = "privileges")
public class Privilege {

    @Id
    @SequenceGenerator(
            name = "privilege_sequence",
            sequenceName = "privilege_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "privilege_sequence"
    )
    private Long id;
}
