package com.example.comp3095.assignment1.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

//    @Query("SELECT user FROM User user WHERE user.id =:id")
//    User findById(@Param("id") Integer id);
//
//    @Query("SELECT user FROM User user WHERE user.email =:id AND user.password =:pass")
//    String findAccount(@Param("email") String email, @Param("pass") String password);
    User findUserByEmailAndPassword(String email, String password);

    User findByEmail(String email);



//    @Query("SELECT user FROM User user WHERE user.id =:id")
    User findUserById(Integer id);


//    @Query("SELECT recipe FROM Recipe recipe, User user WHERE user.recipes =:userId")


}
