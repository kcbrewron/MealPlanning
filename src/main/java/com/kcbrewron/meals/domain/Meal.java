/**
 * 
 */
package com.kcbrewron.meals.domain;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Ron
 *
 */
@Entity
@Table(name = "MEAL")
public class Meal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private int prepTime;
    @NotNull
    private int cookTime;
    private int totalTime;
    @NotNull
    private String description;
    private Set<Ingredient> ingredients;
    private Set<Tag> tags;
    private Set<Direction> directions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MEAL_INGREDIENT", joinColumns = @JoinColumn(name = "MEAL_ID"), inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MEAL_TAG", joinColumns = @JoinColumn(name = "MEAL_ID"), inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEAL_ID", unique = true, nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MEAL_DIRECTION", joinColumns = @JoinColumn(name = "MEAL_ID"), inverseJoinColumns = @JoinColumn(name = "DIRECTION_ID"))
    public Set<Direction> getDirections() {
        return directions;
    }

    public void setDirections(Set<Direction> directions) {
        this.directions = directions;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int setCookTime(int cookTime) {
        return cookTime;
    }

    public int getTotalTime() {
        this.totalTime = this.cookTime + this.prepTime;
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "Meal [id=" + id + ", name=" + name + ", prepTime=" + prepTime + ", cookTime=" + cookTime
                + ", totalTime=" + totalTime + ", description=" + description + ", ingredients=" + ingredients
                + ", tags=" + tags + "]";
    }

}
