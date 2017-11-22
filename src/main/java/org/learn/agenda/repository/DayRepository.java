package org.learn.agenda.repository;

import org.learn.agenda.model.Day;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

/**
 * @author Teodora Bobirneci
 */
public interface DayRepository extends CrudRepository<Day, Long> {

    Day findByDate(LocalDate date);

}
