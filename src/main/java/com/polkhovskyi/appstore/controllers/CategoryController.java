package com.polkhovskyi.appstore.controllers;

import com.polkhovskyi.appstore.dto.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apolkhovskiy on 01.08.2014.
 */
@Controller
public class CategoryController {

    List<Category> myList = new ArrayList<Category>();
    public CategoryController()
    {
        Category temp = new Category();
        temp.title = "Category 1";
        temp.id = "1";
        myList.add(temp);

        temp = new Category();
        temp.title = "Category 2";
        temp.id = "2";
        myList.add(temp);

        temp = new Category();
        temp.title = "Category 3";
        temp.id = "3";
        myList.add(temp);
    }

    @RequestMapping("/category")
    public String category(Model model) {
        model.addAttribute("name", myList);
        return "category";
    }

    @RequestMapping("/category/{id}")
    public String categoryById(
            @PathVariable String id,
            Model model) {
        for (Category category : myList) {
            if (category.id.equals(id)) {
                model.addAttribute("selected", id);
                return "selected";

            }
        }

        return "error";
    }


}
