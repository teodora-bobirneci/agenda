package org.learn.agenda.model;

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
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "DAY_ID")
    private Day day;
    @Column
    private String name;
    @Column
    private String description;

}
