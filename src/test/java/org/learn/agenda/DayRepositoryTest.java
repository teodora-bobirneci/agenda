package org.learn.agenda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.agenda.model.Day;
import org.learn.agenda.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author Teodora Bobirneci
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class DayRepositoryTest {
    @Autowired
    private DayRepository dayRepository;

    @Test
    public void test(){
        Day day = new Day(1L, new ArrayList<>(), new ArrayList<>(), LocalDate.of(2017, 1, 1));
        dayRepository.save(day);

        assertNotNull( dayRepository.findByDate( LocalDate.of(2017, 1, 1)));
        assertNull( dayRepository.findByDate( LocalDate.of(2017, 1, 2)));
    }
}
