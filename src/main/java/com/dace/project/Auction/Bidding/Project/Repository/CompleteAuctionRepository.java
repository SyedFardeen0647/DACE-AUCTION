package com.dace.project.Auction.Bidding.Project.Repository;

import com.dace.project.Auction.Bidding.Project.Model.CompleteAuction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteAuctionRepository extends JpaRepository<CompleteAuction,Long> {

    @Query(value = "SELECT SUM(c.productCommission) FROM CompleteAuction c")
    double sumOfTotalCommission();

}
