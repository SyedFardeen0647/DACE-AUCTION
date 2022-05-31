package com.dace.project.Auction.Bidding.Project.Repository;

import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction_Product,Long> {

    public List<Auction_Product> findByActive(int active);

    public List<Auction_Product> findByAuctionCategoryId(Long id);

}
