package org.learn.agenda.service;

import org.learn.agenda.model.Appointment;
import org.learn.agenda.model.Day;
import org.learn.agenda.model.Task;

import java.time.LocalDate;

/**
 * @author Teodora Bobirneci
 */
public interface DayService {

    Day findByDate(LocalDate date);

    Day addTask(Day day, Task task);

    Day addAppointment(Day day, Appointment appointment);
}
