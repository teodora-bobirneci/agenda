package org.learn.agenda.service.impl;

import org.learn.agenda.model.Appointment;
import org.learn.agenda.model.Day;
import org.learn.agenda.model.Task;
import org.learn.agenda.repository.DayRepository;
import org.learn.agenda.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author Teodora Bobirneci
 */
@Service
public class DefaultDayService implements DayService {

    private final DayRepository dayRepository;

    @Autowired
    public DefaultDayService(DayRepository dayRepository) {this.dayRepository = dayRepository;}

    @Override
    public Day findByDate(LocalDate date) {
        Day day = dayRepository.findByDate(date);
        if (day == null) {
            day = new Day(date);
        }
        return day;
    }

    public Day addTask(Day day, Task task) {
        checkArgument(task != null);
        checkArgument(task.getDay() != null);

        day.addTask(task);

        return dayRepository.save(day);
    }

    @Override
    public Day addAppointment(Day day, Appointment appointment) {
        checkArgument(appointment != null);
        checkArgument(appointment.getDay() != null);

        day.addAppointment(appointment);

        return dayRepository.save(day);
    }
}
