package com.project.Freezer.Prabhjot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.Freezer.Prabhjot.exception.FoodNotFoundException;
import com.project.Freezer.Prabhjot.model.Food;
import com.project.Freezer.Prabhjot.repository.FoodRepo;

//findById and save are built in functions from the JPA Repo class that FoodRepo inherits

@RestController
@RequestMapping
public class FoodController {
	
	@Autowired
	private FoodRepo foodRepo;
	
	//@GetMapping("/addFood")
	//public ModelAndView index() {
	//    return new ModelAndView("foodForm.html");
	//}
	
	@GetMapping("/food/{id}") //Method to provide an ID & get the detail of the food
	public Food getFoodById(@PathVariable(value="id") long id) throws FoodNotFoundException {
		return this.foodRepo.findById(id).orElseThrow(() -> new FoodNotFoundException("There is no food for the specified ID."));
	}

	@PostMapping("/food") //Method to add some food to the freezer, giving name, type & quantity (returns an ID)
	public Food createFood(@RequestBody Food food) {
		return this.foodRepo.save(food);
	}
	
	@PutMapping("/food/{id}") //Method to update the food item
	public Food updateFoodItem(@PathVariable(value="id") long id, @RequestBody Food foodDetails) throws FoodNotFoundException {
		Food food = this.foodRepo.findById(id).orElseThrow(() -> new FoodNotFoundException("There is no food for the specified ID."));
		food.setName(foodDetails.getName());
		food.setQuantity(foodDetails.getQuantity());
		food.setType(foodDetails.getType());
		return this.foodRepo.save(food);
	}
	
	@GetMapping("/food/search/{name}")//Method to search for food by name
	public List<Food> searchFood(@PathVariable(value="name" ) String name) {
		return this.foodRepo.findByFoodName(name); // to search using the URL need to put %20 for every space
		
	}
	
}
