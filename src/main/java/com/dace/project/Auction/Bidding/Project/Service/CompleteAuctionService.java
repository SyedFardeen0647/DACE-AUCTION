package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.CompleteAuction;

import java.util.List;

public interface CompleteAuctionService {

    public CompleteAuction saveCompleteAuction(CompleteAuction completeAuction);

    public List<CompleteAuction> completeAuctionList();

    public List<CompleteAuction>  adminAllCompleteAuction();

    public Long completeAuctionCount();

    public void completeAuctionDelete(Long id);

    double sumOfTotalCommission();

}
