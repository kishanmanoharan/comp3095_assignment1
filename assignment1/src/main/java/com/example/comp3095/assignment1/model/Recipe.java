package com.example.comp3095.assignment1.model;
import com.sun.istack.NotNull;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "directions")
    private String directions;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Recipe() {
//        this.name = "";
//        this.date = null;
//        this.ingredients = "";
//        this.directions = "";
    }

    public Integer getId() {
        return this.id;
    }
    public String getName() { return this.name; }
    public Date getDate() {
        return this.date;
    }
    public String getIngredients() {
        return this.ingredients;
    }
    public String getDirections() {
        return this.directions;
    }

    public Recipe(String name, Date date, String ingredients, String directions){
        this.name = name;
        this.date = date;
        this.ingredients = ingredients;
        this.directions = directions;
    }


    public User getUser() {
        return this.user;
    }

    protected void setUser(User user) {
        this.user = user;
    }
//    public Integer getUserId() {
//        return this.userId;
//    }
//
//    protected void setUser(User user) {
//        this.userId = user.getId();
//    }
//    protected void setUser(Integer userId) {
//        this.userId = userId;
//    }
}
