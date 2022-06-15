package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.Auction_Bids;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Bidding_Service {

    public String postBid(Double bidAmount,Long id);

    public Auction_Bids getSingleBid(Long id);

    public List<Auction_Bids> bidLists();

    public String findByAuctionOrderByBidPriceDesc(Long id);

    void deleteBid(Long id);
}
