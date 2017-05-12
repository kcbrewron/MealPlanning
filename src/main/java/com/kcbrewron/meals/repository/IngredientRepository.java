/**
 * 
 */
package com.kcbrewron.meals.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.kcbrewron.meals.domain.Ingredient;

/**
 * @author Ron
 *
 */
public interface IngredientRepository extends CrudRepository<Ingredient,UUID> {
	
	public List<Ingredient>findAll();
	public Ingredient findOneByName(String name);
	public Ingredient findOneById(UUID id);

}
