package com.kcbrewron.meals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcbrewron.meals.domain.Ingredient;
import com.kcbrewron.meals.domain.Meal;
import com.kcbrewron.meals.domain.MeasurementType;
import com.kcbrewron.meals.domain.Tag;
import com.kcbrewron.meals.repository.DirectionRepository;
import com.kcbrewron.meals.repository.IngredientRepository;
import com.kcbrewron.meals.repository.MealRepository;
import com.kcbrewron.meals.repository.TagRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestingSaves {

    @Autowired
    IngredientRepository ingRepo;
    @Autowired
    MealRepository mealRepo;
    @Autowired
    TagRepository tagRepo;
    @Autowired
    DirectionRepository directionRepo;

    @Test
    public void test() {
        Meal meal1 = new Meal();
        meal1.setName("Fajitas");
        meal1.setDescription("This is a test meal");

        Ingredient ing1 = new Ingredient();
        ing1.setName("Chicken Breast");
        ing1.setMeasurementType(MeasurementType.LBS);
        ing1.setQuantity(1.5);
        ing1.setAddedTs(new Date());
        Ingredient savedIngredient = ingRepo.save(ing1);

        System.out.println("Saved ingredient id [" + savedIngredient.getId() + "]");

        Set<Ingredient> ingredients = new HashSet<Ingredient>();
        ingredients.add(savedIngredient);
        meal1.setIngredients(ingredients);

        Tag tag = new Tag();
        tag.setTagName("Mexican");
        tag.setTagCnt(1);
        tagRepo.save(tag);
        Set<Tag> tags = new HashSet<Tag>();
        tags.add(tag);

        meal1.setTags(tags);
        Meal savedMeal = mealRepo.save(meal1);
        System.out.println("Saved meal id [" + savedMeal.getId() + "]");
        Meal newMeal = mealRepo.findOneById(savedMeal.getId());
        System.out.println(newMeal.toString());

    }

}
