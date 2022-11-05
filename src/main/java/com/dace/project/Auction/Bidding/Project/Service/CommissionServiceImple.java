package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.Commission;
import com.dace.project.Auction.Bidding.Project.Repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionServiceImple implements CommissionService{
    @Autowired
    private CommissionRepository commissionRepository;


    @Override
    public Commission saveCommissionInfo(double percentage) {

        Commission commission = new Commission();
        commission.setIntrestPercntage(percentage);
        commission.setAuctionTime(30);

        clearAll();

        return commissionRepository.save(commission);
    }

    @Override
    public void clearAll() {

        commissionRepository.deleteAll();
    }

    @Override
    public long dataExists() {
        return commissionRepository.count();
    }

    @Override
    public double findTopPercentage() {

        List<Commission> allCommission = commissionRepository.findAll();
        return allCommission.get(0).getIntrestPercntage();
    }



    @Override
    public List<Commission> findFirstElement() {
        return null;
    }


}
