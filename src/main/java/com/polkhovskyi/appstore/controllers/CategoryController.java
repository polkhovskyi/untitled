package com.polkhovskyi.appstore.controllers;

import com.polkhovskyi.appstore.dao.CategoryService;
import com.polkhovskyi.appstore.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String category(Model model) {
        model.addAttribute("name", categoryService.getCategories());
        return "index";
    }

    @RequestMapping("/{id}")
    public String categoryById(
            @PathVariable String id,
            Model model) {
        for (Category category : categoryService.getCategories()) {
            if (category.id.equals(id)) {
                model.addAttribute("selected", id);
                return "selected";
            }
        }

        return "error";
    }


}
