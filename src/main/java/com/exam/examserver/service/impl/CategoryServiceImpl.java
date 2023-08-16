package com.exam.examserver.service.impl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.exam.Category;
import com.exam.examserver.repository.CategoryRepository;
import com.exam.examserver.service.CategoryService;

import antlr.collections.List;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository  categoryrepository;
	
	
	@Override
	public Category addCategory(Category category) {
		
		// TODO Auto-generated method stub
		//save method will directoly save the category
		return this.categoryrepository.save(category);
		
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		/*save works for both insert and update if we pass
		 *  
		*/
		return this.categoryrepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.categoryrepository.findAll());
	}

	@Override
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		return this.categoryrepository.findById(id).get();
	  
	}

	@Override
	public String deleteCategory(int id) {
		// TODO Auto-generated method stub
		this.categoryrepository.deleteById(id);
		return "Category deleted";
		
	}

}
