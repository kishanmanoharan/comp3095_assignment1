package com.example.comp3095.assignment1.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    private final RecipeRepository recipeRepository;

    public UserController(UserRepository userRepository, RecipeRepository recipeRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/signin";
//    }

    @GetMapping("/signup")
    public String initCreationForm(Model model) {
        String email = "";
        String pass = "";
//        model.addAttribute("email", email);
//        model.addAttribute("pass", pass);
        model.addAttribute(new User());
        return "account/signup";
    }

    @PostMapping("/signup")
    public String processCreationForm(User user, BindingResult result) {
        if (result.hasErrors()) {
            return "account/signup";
        }
        else {
//            User user = new User(model.getAttribute("email").toString(), model.getAttribute("pass").toString());

            this.userRepository.save(user);
            return "redirect:/signin";
        }
    }

    @GetMapping("/allusers")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("recipes", recipeRepository.findAll());
        return "account/details";
    }

//    @Cacheable(value = "user", key = "#id")
    @GetMapping("/signin")
    public String userSignin(Model model) {
        model.addAttribute(new User());
        return "account/signin";
    }

    @PostMapping("/signin")
//    @Cacheable(key = "user_email", value = "#{cache ? user.getId()}")
    public String processSignin(User user, BindingResult result) {
        if (result.hasErrors()) {
            return "account/signin";
        }
        else {
//            User user = new User(model.getAttribute("email").toString(), model.getAttribute("pass").toString());
            User dbUser = userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
            if (dbUser != null) {
                boolean cache = true;
                return "redirect:/home/" + dbUser.getId();
            }
            return "redirect:/signin";
        }
    }

    @GetMapping("/home/{userId}")
    public ModelAndView getHome(@PathVariable("userId") int userId, Model model) {
        ModelAndView mav = new ModelAndView("account/home");
        User user = this.userRepository.findUserById(userId);
        mav.addObject(user);
        List<Recipe> recipes = this.recipeRepository.getRecipesByUser(userId);
        mav.addObject(recipes);
        return mav;
    }

    @GetMapping("/home/{userId}/newrecipe")
    public String newRecipe(@PathVariable("userId") int userId, Model model) {
//        ModelAndView mav = new ModelAndView("recipes/new");
        User user = this.userRepository.findUserById(userId);
//        Recipe recipe = new Recipe();
//        user.addRecipe(recipe);
//        mav.addObject(user);
//        mav.addObject(recipe);

        model.addAttribute(new Recipe());
        model.addAttribute(user);
        return "recipes/new";
    }


    @PostMapping("/newrecipe")
    public String processNewRecipe(Recipe recipe, BindingResult result, User user) {

        User user_db = this.userRepository.findUserById(1);
//        User user_db = this.userRepository.findUserById(user.getId());
        recipe.setUser(user);
        user.addRecipe(recipe);
        if (result.hasErrors()) {
//            System.out.println(result.toString());
            return "redirect:/home/" + user.getId() + "/newrecipe";
        }
        else {
//            Recipe dbUser = userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
//            recipe.setUser(this.userRepository.findUserById(userId));
//            this.userRepository.
//
//            user.addRecipe(recipe);
//            if (this.userRepository.existsById(user.getId())) {
//                this.userRepository.deleteById(user.getId());
//            }
//            User userDb = this.userRepository.findUserById(user.getId());

            this.recipeRepository.save(recipe);
            return "redirect:/home/" + user.getId();
        }
    }

//    @GetMapping("/user/{userId}")
//    public ModelAndView showUser(@PathVariable("userId") int userId) {
//        ModelAndView mav = new ModelAndView("account/details");
//        User user = this.userRepository.findById(userId);
//        mav.addObject(user);
//        return mav;
//    }

}
