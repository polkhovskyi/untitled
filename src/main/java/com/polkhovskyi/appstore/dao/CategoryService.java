package com.polkhovskyi.appstore.dao;

import com.polkhovskyi.appstore.dto.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apolkhovskiy on 01.08.2014.
 */
@Service
public class CategoryService {

   private List<Category> categories = new ArrayList<Category>();

   public CategoryService()
   {
       Category temp = new Category();
       temp.title = "Category 1";
       temp.id = "1";
       categories.add(temp);

       temp = new Category();
       temp.title = "Category 2";
       temp.id = "2";
       categories.add(temp);

       temp = new Category();
       temp.title = "Category 3";
       temp.id = "3";
       categories.add(temp);
   }

    public List<Category> getCategories()
    {
        return categories;
    }

}
