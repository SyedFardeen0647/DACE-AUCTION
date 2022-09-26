package com.dace.project.Auction.Bidding.Project.Repository;

import com.dace.project.Auction.Bidding.Project.Model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends JpaRepository<Commission,Long> {


}
