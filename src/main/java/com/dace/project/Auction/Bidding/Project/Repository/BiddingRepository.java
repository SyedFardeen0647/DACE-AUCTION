package com.dace.project.Auction.Bidding.Project.Repository;

import com.dace.project.Auction.Bidding.Project.Model.Auction_Bids;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.LineNumberInputStream;
import java.util.List;

@Repository
public interface BiddingRepository extends JpaRepository<Auction_Bids,Long> {

    public List<Auction_Bids> findByAuctionOrderByBidPriceDesc(Auction_Product product);
}
