package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.Category;
import com.dace.project.Auction.Bidding.Project.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Category_Service_Implementation implements Category_Service{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(String categoryName) {

        Category category1 = new Category();
        category1.setCategoryName(categoryName);
        category1.setActive(1);

        return categoryRepository.save(category1);
    }

    @Override
    public Category getSingleCategory(Long id) {
        Category category = categoryRepository.findById(id).get();
        return category;
    }

    @Override
    public List<Category> getAllCategory() {

        List<Category> categoryList = categoryRepository.findAll();

        return categoryList;
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Category category1 = categoryRepository.findById(id).get();
        category1.setCategoryName(category.getCategoryName());
        category1.setActive(category.getActive());
        return categoryRepository.save(category1);
    }

    @Override
    public void deleteCategory(Long id) {

        categoryRepository.deleteById(id);

    }

    @Override
    public Long categoryCount() {
        return categoryRepository.count();
    }

    @Override
    public List<Category> allActiveCategory() {
        List<Category> activeCategories = categoryRepository.findByActive(1);
        return activeCategories;
    }


}
