/**
 * 
 */
package com.kcbrewron.meals.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Ron
 *
 */
@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID",unique=true, nullable=false)
	private UUID id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	
}
