package org.learn.agenda.controller;

import org.learn.agenda.model.Appointment;
import org.learn.agenda.model.Day;
import org.learn.agenda.model.Task;
import org.learn.agenda.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Teodora Bobirneci
 */
@RestController
@RequestMapping("/agenda")
public class DayController {

    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService) {this.dayService = dayService;}

    @RequestMapping(value = "/day/{date}", method = GET)
    public Day getDay(@PathVariable(name = "date") @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
        return dayService.findByDate(date);
    }

    @RequestMapping(value = "/day/{date}/addTask", method = POST)
    public Day addTask(@PathVariable(name = "date") @DateTimeFormat(iso = ISO.DATE) LocalDate date,
                       @RequestParam String name,
                       @RequestParam(required = false) String description) {
        Day day = dayService.findByDate(date);
        dayService.addTask(day, new Task().withDay(day).withName(name).withDescription(description));
        return day;
    }

    @RequestMapping(value = "/day/{date}/addAppointment", method = POST)
    public Day addAppointment(@PathVariable(name = "date") @DateTimeFormat(iso = ISO.DATE) LocalDate date,
                              @RequestParam(name = "time") @DateTimeFormat(iso = ISO.TIME) LocalTime time,
                              @RequestParam String name,
                              @RequestParam(required = false) String description) {
        Day day = dayService.findByDate(date);
        dayService.addAppointment(day, new Appointment().withDay(day).withTime(time).withName(name).withDescription(description));
        return day;
    }


}
