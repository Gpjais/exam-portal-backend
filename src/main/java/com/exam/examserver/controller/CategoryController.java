package com.exam.examserver.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.entity.exam.Category;
import com.exam.examserver.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
   
	   @Autowired
	   private CategoryService categoryservice;
	   
	   @PostMapping("/")
	   public Category addCategory(@RequestBody Category category)
	   {
		   System.out.println(category);
		   return this.categoryservice.addCategory(category);
	   }
	   
	   @GetMapping("/{id}")
	   public Category getCategory(@PathVariable("id") int id  )
	   {
		  return categoryservice.getCategory(id);
	   }
	   
	   @GetMapping("/get-categories")
	   public Set<Category> getCategories()
	   {
		   return this.categoryservice.getCategories();
	   }
	   
	   //toUpdate 
	   @PutMapping("/update")
	   public Category updateCategory(@RequestBody Category category )
	   {
		   return this.categoryservice.updateCategory(category);
	   }
	   
	   @DeleteMapping("delete/{id}")
	   public void deleteCategory(@PathVariable("id") int id)
	   {
		   categoryservice.deleteCategory(id);
	   }
	   
	   
} 
