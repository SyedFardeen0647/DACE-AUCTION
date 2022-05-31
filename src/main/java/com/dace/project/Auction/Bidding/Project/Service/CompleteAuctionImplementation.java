package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.CompleteAuction;
import com.dace.project.Auction.Bidding.Project.Repository.CompleteAuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompleteAuctionImplementation implements CompleteAuctionService{

    @Autowired
    private CompleteAuctionRepository auctionRepository;

    @Override
    public CompleteAuction saveCompleteAuction(CompleteAuction completeAuction) {
        return auctionRepository.save(completeAuction);
    }

    @Override
    public List<CompleteAuction> completeAuctionList() {
        return auctionRepository.findAll();
    }
}
