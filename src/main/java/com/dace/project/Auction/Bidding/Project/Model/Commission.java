package com.dace.project.Auction.Bidding.Project.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double intrestPercntage;
    private int auctionTime;

    public Commission() {
    }

    public Commission(int id, double intrestPercntage, int auctionTime) {
        this.id = id;
        this.intrestPercntage = intrestPercntage;
        this.auctionTime = auctionTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getIntrestPercntage() {
        return intrestPercntage;
    }

    public void setIntrestPercntage(double intrestPercntage) {
        this.intrestPercntage = intrestPercntage;
    }

    public int getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(int auctionTime) {
        this.auctionTime = auctionTime;
    }

    @Override
    public String toString() {
        return "Commission{" +
                "id=" + id +
                ", intrestPercntage=" + intrestPercntage +
                ", auctionTime=" + auctionTime +
                '}';
    }
}
