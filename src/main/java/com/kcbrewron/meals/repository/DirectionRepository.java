/**
 * 
 */
package com.kcbrewron.meals.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kcbrewron.meals.domain.Direction;

/**
 * @author Ron
 *
 */
@Repository
public interface DirectionRepository extends CrudRepository<Direction, UUID> {

    @Override
    Iterable<Direction> findAll();
}
