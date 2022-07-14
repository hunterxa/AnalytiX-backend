package com.hunterxa.AnalytiX.event;

import com.hunterxa.AnalytiX.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@ToString(exclude = "id")
public class Event {

    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )
    private Long id;
    private String name;
    private LocalDate date;
    private Integer attendance;
    @ManyToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "fk_creator_id",
            referencedColumnName = "id"
    )
    private User creator;

    public Event(Long id, String name, LocalDate date, Integer attendance, User creator) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.attendance = attendance;
        this.creator = creator;
    }

    public Event(String name, LocalDate date, Integer attendance, User creator) {
        this.name = name;
        this.date = date;
        this.attendance = attendance;
        this.creator = creator;
    }

}
