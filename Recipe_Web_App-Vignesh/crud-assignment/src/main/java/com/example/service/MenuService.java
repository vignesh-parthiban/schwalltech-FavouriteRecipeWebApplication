package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.RecordNotFoundException;
import com.example.demo.MenuEntity;
import com.example.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository repository;

	//End point to get all dish available from restaurant menu
	public List<MenuEntity> getAllDish() {
		List<MenuEntity> DishList = repository.findAll();

		if (DishList.size() > 0) {
			return DishList;
		} else {
			return new ArrayList<MenuEntity>();
		}
	}

	//To get a particular dish using ID from restaurant menu
	public MenuEntity getDishById(Long id) throws RecordNotFoundException {
		Optional<MenuEntity> dish = repository.findById(id);

		if (dish.isPresent()) {
			return dish.get();
		} else {
			throw new RecordNotFoundException("No dishes found for given id");
		}
	}

	//To create new dish or to update a existing dish
	public MenuEntity createOrUpdateDish(MenuEntity entity) throws RecordNotFoundException {
		Optional<MenuEntity> dish = repository.findById(entity.getId());

		if (dish.isPresent()) {
			MenuEntity newEntity = dish.get();

			newEntity.setDateandtimeofcreation(entity.getDateandtimeofcreation());
			newEntity.setFoodType(entity.getFoodType());
			newEntity.setSuitablefor(entity.getSuitablefor());
			newEntity.setIngredients(entity.getIngredients());
			newEntity.setCookingInstructions(entity.getCookingInstructions());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	//To delete a dish from menu using ID
	public void deleteDishById(Long id) throws RecordNotFoundException {
		Optional<MenuEntity> dish = repository.findById(id);

		if (dish.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Dishes record exist for given id");
		}
	}
}