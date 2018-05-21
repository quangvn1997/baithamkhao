package com.example.controller;

import com.example.entities.Dish;
import com.example.model.DishModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Optional;

@Controller
public class DishController {
    @Autowired
    private DishModel dishModel;

    @RequestMapping(path = "/dish/create", method = RequestMethod.GET)
    public String createProduct(@ModelAttribute Dish dish) {
        return "dish-form";
    }

    @RequestMapping(path = "/dish/create", method = RequestMethod.POST)
    public String saveProduct(@Valid Dish dish, BindingResult result) {
        if (result.hasErrors()) {
            return "dish-form";
        }
        dishModel.save(dish);
        return "redirect:/dish/list";
    }

    @RequestMapping(path = "/dish/list", method = RequestMethod.GET)
    public String getListProduct(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) {
        model.addAttribute("pagination", dishModel.findByStatusNot(0,PageRequest.of(page - 1, limit)));
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        model.addAttribute("datetime", Calendar.getInstance().getTime());
        return "list";
    }

    @RequestMapping(path = "/dish/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable int id, Model model) {
        Optional<Dish> optionalProduct = dishModel.findById(id);
        if (optionalProduct.isPresent()) {
            model.addAttribute("dish", optionalProduct.get());
            return "dish-form";
        } else {
            return "not-found";
        }
    }

    @RequestMapping(path = "/product/delete/{id}", method = RequestMethod.POST)
    public String deleteProduct(@PathVariable int id) {
        Optional<Dish> optionalProduct = dishModel.findById(id);
        if (optionalProduct.isPresent()) {
            optionalProduct.get().setStatus(0);
            dishModel.save(optionalProduct.get());
            return "redirect:/dish/list";
        } else {
            return "not-found";
        }
    }
}
