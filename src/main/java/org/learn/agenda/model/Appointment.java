package org.learn.agenda.model;


import lombok.Getter;

import javax.persistence.*;
import java.time.LocalTime;

import static javax.persistence.CascadeType.ALL;

/**
 * @author Teodora Bobirneci
 */
@Getter
@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "DAY_ID")
    private Day day;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private LocalTime localTime;
}
