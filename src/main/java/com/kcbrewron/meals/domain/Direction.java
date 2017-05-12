/**
 * 
 */
package com.kcbrewron.meals.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Ron
 *
 */
@Entity
@Table(name = "DIRECTION")
public class Direction implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8997974430444499216L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DIRECTION_ID")
    private UUID id;
    @NotNull
    private int sequence;
    @NotNull
    private String direction_txt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getDirection_txt() {
        return direction_txt;
    }

    public void setDirection_txt(String instructuion_txt) {
        this.direction_txt = instructuion_txt;
    }

    @Override
    public String toString() {
        return "Instruction [id=" + id + ", sequence=" + sequence + ", instructuion_txt=" + direction_txt + "]";
    }

}
