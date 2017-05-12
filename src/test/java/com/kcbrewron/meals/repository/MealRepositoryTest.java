package com.kcbrewron.meals.repository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcbrewron.meals.domain.Direction;
import com.kcbrewron.meals.domain.Ingredient;
import com.kcbrewron.meals.domain.Meal;
import com.kcbrewron.meals.domain.MeasurementType;
import com.kcbrewron.meals.domain.Tag;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MealRepositoryTest {

    Logger logger = LoggerFactory.getLogger(MealRepositoryTest.class);

    @Autowired
    IngredientRepository ingRepo;
    @Autowired
    MealRepository mealRepo;
    @Autowired
    TagRepository tagRepo;
    @Autowired
    DirectionRepository directionRepo;

    Set<Direction> directions = new HashSet<>();
    Set<Tag> tags = new HashSet<>();
    Set<Ingredient> ingredients = new HashSet<>();

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

        // directionRepo.save(directions);

        Tag tag1 = new Tag();
        tag1.setTagCnt(1);
        tag1.setTagName("Kid Friendly");

        Tag tag2 = new Tag();
        tag2.setTagCnt(1);
        tag2.setTagName("Mexican");

        tags.add(tag1);
        tags.add(tag2);

        Ingredient ing1 = new Ingredient();
        ing1.setName("Chicken Breast");
        ing1.setMeasurementType(MeasurementType.LBS);
        ing1.setQuantity(1.0);
        ing1.setAddedTs(new Date());

        Ingredient ing2 = new Ingredient();
        ing2.setName("Fajita Seasoning");
        ing2.setMeasurementType(MeasurementType.CUPS);
        ing2.setQuantity(.25);
        ing2.setAddedTs(new Date());

        ingredients.add(ing1);
        ingredients.add(ing2);
    }

    @Test
    public void testTestSaveS() {

        Meal meal = new Meal();
        meal.setDescription("Delicious mexican fajitas");
        meal.setName("Ron's delicious fajitas");
        meal.setPrepTime(20);
        meal.setCookTime(15);
        meal.setTags(tags);
        meal.setIngredients(ingredients);
        meal.setDirections(directions);
        Meal savedMeal = mealRepo.save(meal);

        logger.info(savedMeal.toString());

    }

}
