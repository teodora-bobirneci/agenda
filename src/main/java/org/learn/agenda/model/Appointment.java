package org.learn.agenda.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "DAY_ID")
    private Day day;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private LocalTime localTime;

    public Appointment withDay(Day day) {
        this.day = day;
        return this;
    }

    public Appointment withName(String name) {
        this.name = name;
        return this;
    }

    public Appointment withDescription(String description) {
        this.description = description;
        return this;
    }

    public Appointment withTime(LocalTime localTime) {
        this.localTime = localTime;
        return this;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", localTime=" + localTime +
                '}';
    }
}
