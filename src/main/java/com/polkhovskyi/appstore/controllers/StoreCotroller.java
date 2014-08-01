package com.polkhovskyi.appstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by apolkhovskiy on 01.08.2014.
 */
@Controller
public class StoreCotroller {
    @RequestMapping("/store")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "store";
    }
}
