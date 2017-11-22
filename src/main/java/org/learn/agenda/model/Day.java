package org.learn.agenda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * @author Teodora Bobirneci
 */
@AllArgsConstructor
@Getter
@Entity
public class Day {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany(fetch = EAGER,mappedBy="day",cascade = ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Appointment> appointments;
    @OneToMany(fetch = EAGER,mappedBy="day",cascade = ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Task> tasks;
    @Column
    private LocalDate date;

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

    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
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
