package com.example.comp3095.assignment1.model;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    @JoinColumn(name = "id")
    private Set<Recipe> recipes = new HashSet<Recipe>();


    public Integer getId() {
        return id;
    }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User() {
//        this.email = "";
//        this.password = "";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Recipe> getRecipesList() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private List<Integer> recipes = new ArrayList<Integer>();


    public void addRecipe(Recipe recipe) {
        if (recipe != null){
            recipes.add(recipe);
        }
//        recipe.setUser(this);
    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
//    private Set<Recipe> meals;
//

}
