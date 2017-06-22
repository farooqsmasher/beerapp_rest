package com.webteam_rest.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="alcohol_percent")
	private String alcoholPercent;
	
	@Column(name="brewery_location")
	private String breweryLocation;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getAlcoholPercent() {
		return alcoholPercent;
	}

	public void setAlcoholPercent(String alcoholPercent) {
		this.alcoholPercent = alcoholPercent;
	}

	public String getBreweryLocation() {
		return breweryLocation;
	}

	public void setBreweryLocation(String breweryLocation) {
		this.breweryLocation = breweryLocation;
	}

	
		
}