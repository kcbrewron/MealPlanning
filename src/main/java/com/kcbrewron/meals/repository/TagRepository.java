/**
 * 
 */
package com.kcbrewron.meals.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.kcbrewron.meals.domain.Tag;

/**
 * @author Ron
 *
 */
public interface TagRepository extends CrudRepository<Tag, UUID> {

    Iterable<Tag> findManyByTagNameIsStartingWith(String name);

}
