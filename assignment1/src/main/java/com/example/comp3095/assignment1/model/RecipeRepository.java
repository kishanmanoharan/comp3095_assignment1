package com.example.comp3095.assignment1.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

//    @Query("SELECT recipe FROM Recipe recipe WHERE recipe.id =:id")
//    Recipe findRecipeById(Integer id);

//    List<Recipe> findByRecipe(Recipe recipe);


    @Query("SELECT recipe FROM Recipe recipe WHERE user_id =:userId")
    List<Recipe> getRecipesByUser(Integer userId);
}
