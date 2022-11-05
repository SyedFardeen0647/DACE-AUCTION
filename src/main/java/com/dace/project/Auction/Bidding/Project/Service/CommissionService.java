package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.Commission;

import java.util.List;

public interface CommissionService {

    Commission saveCommissionInfo(double percentage);
    void clearAll();

    long dataExists();

    double findTopPercentage();



    List<Commission> findFirstElement();




}
