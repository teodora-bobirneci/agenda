package org.learn.agenda.model;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.FetchType.EAGER;
import static org.hibernate.annotations.FetchMode.SUBSELECT;

/**
 * @author Teodora Bobirneci
 */
@AllArgsConstructor
@Entity
public class Day {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany(fetch = EAGER, mappedBy = "day", cascade = ALL)
    @Fetch(value = SUBSELECT)
    private List<Appointment> appointments;
    @OneToMany(fetch = EAGER, mappedBy = "day", cascade = ALL)
    @Fetch(value = SUBSELECT)
    private List<Task> tasks;
    @Column
    private LocalDate date;
    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "USER_ID")
    private Account account;

    public Day() {
        tasks = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public Day(LocalDate date) {
        this();
        this.date = date;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", appointments=" + appointments +
                ", tasks=" + tasks +
                ", date=" + date +
                '}';
    }
}
