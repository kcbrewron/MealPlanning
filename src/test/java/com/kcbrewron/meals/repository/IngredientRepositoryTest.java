package com.kcbrewron.meals.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcbrewron.meals.domain.Ingredient;
import com.kcbrewron.meals.domain.MeasurementType;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IngredientRepositoryTest {

    @Autowired
    IngredientRepository repo;

    @Test
    public void testSave() {
        Ingredient ing1 = new Ingredient();
        ing1.setMeasurementType(MeasurementType.CUPS);
        ing1.setQuantity(1);
        ing1.setName("milk");
        repo.save(ing1);
    }

}
