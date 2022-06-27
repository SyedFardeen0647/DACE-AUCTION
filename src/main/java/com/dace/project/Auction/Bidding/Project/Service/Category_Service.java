package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.Category;

import java.util.List;

public interface Category_Service {

    public Category createCategory(Category category);

    public Category getSingleCategory(Long id);

    public List<Category> getAllCategory();

    public Category updateCategory(Category category , Long id);

    public void deleteCategory(Long id);

    public Long categoryCount();
}
