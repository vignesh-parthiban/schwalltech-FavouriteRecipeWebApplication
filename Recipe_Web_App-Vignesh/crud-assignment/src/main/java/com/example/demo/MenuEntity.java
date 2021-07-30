package com.example.demo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
//Database table name = "menu"
@Table(name = "menu")
public class MenuEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Date_and_time_of_creation")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Timestamp Dateandtimeofcreation;

	@Column(name = "Food_Type")
	private String FoodType;

	@Column(name = "Suitable_for")
	private Long Suitablefor;

	@Column(name = "Ingredients")
	private String ingredients;

	@Column(name = "Cooking_Instructions")
	private String CookingInstructions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDateandtimeofcreation() {
		return Dateandtimeofcreation;
	}

	public void setDateandtimeofcreation(Timestamp dateandtimeofcreation) {
		Dateandtimeofcreation = dateandtimeofcreation;
	}

	public String getFoodType() {
		return FoodType;
	}

	public void setFoodType(String foodType) {
		FoodType = foodType;
	}

	public Long getSuitablefor() {
		return Suitablefor;
	}

	public void setSuitablefor(Long suitablefor) {
		Suitablefor = suitablefor;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCookingInstructions() {
		return CookingInstructions;
	}

	public void setCookingInstructions(String cookingInstructions) {
		CookingInstructions = cookingInstructions;
	}

	@Override
	public String toString() {
		return "MenuEntity [id=" + id + ", FoodType=" + FoodType + ", Suitablefor=" + Suitablefor + ", ingredients="
				+ ingredients + ", CookingInstructions=" + CookingInstructions + "]";
	}

}