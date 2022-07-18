package com.project.Freezer.Prabhjot.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.Freezer.Prabhjot.model.Food;

import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food, Long> {
	
	@Query("SELECT f FROM Food f WHERE f.name = :food_name") // this is a JPQL query. 
	//food_name is bound using the param annotation
	public List<Food> findByFoodName(@Param("food_name") String name);

}
