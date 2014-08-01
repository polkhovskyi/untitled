package com.polkhovskyi.appstore.controllers;

import com.polkhovskyi.appstore.dto.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apolkhovskiy on 01.08.2014.
 */
@Controller
public class CategoryController {
    @RequestMapping("/category")
    public String category(Model model) {
        List<Category> myList = new ArrayList<Category>();
        Category temp = new Category();
        temp.title = "Category 1";
        myList.add(temp);

        temp = new Category();
        temp.title = "Category 2";
        myList.add(temp);

        temp = new Category();

        myList.add(temp);
        model.addAttribute("name", myList);
        return "category";
    }
}
