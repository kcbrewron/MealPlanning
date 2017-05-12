/**
 * 
 */
package com.kcbrewron.meals.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.kcbrewron.meals.domain.Meal;

/**
 * @author Ron
 *
 */
public interface MealRepository extends CrudRepository<Meal,UUID>{
	
	public Meal findOneByName(String name);
	public List<Meal> findAll();
	public Meal findOneById(UUID id);

}
