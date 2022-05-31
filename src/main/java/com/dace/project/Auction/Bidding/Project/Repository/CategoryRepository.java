package com.dace.project.Auction.Bidding.Project.Repository;

import com.dace.project.Auction.Bidding.Project.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
