/**
 * 
 */
package com.kcbrewron.meals.repository;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcbrewron.meals.domain.Direction;

/**
 * @author Ron
 *
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DirectionRepositoryTest {

    @Autowired
    DirectionRepository directionRepo;

    Set<Direction> directions = new HashSet<>();

    @Before
    public void setup() {
        Direction dir = new Direction();
        Direction dir2 = new Direction();
        Direction dir3 = new Direction();

        dir.setDirection_txt("Preheat oven to 350 degrees");
        dir.setSequence(1);
        dir2.setDirection_txt("Marinate chicken for a minimum of 30 minutes and a maximum of two hours");
        dir2.setSequence(2);
        dir3.setDirection_txt("Bake chicken in 9x13 pan for 20 minutes or until done");
        dir3.setSequence(3);

        directions.add(dir);
        directions.add(dir2);
        directions.add(dir3);
    }

    @Test
    public void saveSingleDirection() {
        Direction dir = new Direction();

        dir.setDirection_txt("Preheat oven to 350 degress.");
        dir.setSequence(1);

        directionRepo.save(dir);
    }

    @Test
    public void saveMultipleDirection() {

        directionRepo.save(directions);
    }
}
