/**
 * 
 */
package com.kcbrewron.meals.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Ron
 *
 */
@Entity(name = "Ingredient")
public class Ingredient implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private UUID id;
    @NotNull
    @Length(max = 100)
    private String name;
    @NotNull
    private double quantity;
    @NotNull
    private MeasurementType measurementType;
    private Date addedTs;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INGREDIENT_ID", unique = true, nullable = false)
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public Date getAddedTs() {
        return addedTs;
    }

    public void setAddedTs(Date addedTs) {
        this.addedTs = addedTs;
    }

    public Ingredient(UUID id, String name, double quantity, MeasurementType measurementType, Date addedTs) {
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.measurementType = measurementType;
        this.addedTs = addedTs;
    }

    public Ingredient() {
        super();
    }

    @Override
    public String toString() {
        return "Ingredient [id=" + id + ", name=" + name + ", quantity=" + quantity + ", measurementType="
                + measurementType + ", addedTs=" + addedTs + "]";
    }

}
