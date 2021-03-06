package org.learn.agenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

/**
 * @author Teodora Bobirneci
 */
@Getter
@Entity
public class Task {

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

    public Task withDay(Day day) {
        this.day = day;
        return this;
    }

    public Task withName(String name) {
        this.name = name;
        return this;
    }

    public Task withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
