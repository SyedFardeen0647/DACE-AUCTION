package com.dace.project.Auction.Bidding.Project.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Auction_Bids {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bidId;

    @ManyToOne
    @JoinColumn(name="Auction_Id", nullable=false)
    private Auction_Product auction;

    @ManyToOne
    @JoinColumn(name="Customer_Id", nullable=false)
    private User customer;

    private Double bidPrice;

    private LocalDateTime bidOn;


    public Auction_Bids(Long bidId, Auction_Product auction, User customer, Double bidPrice, LocalDateTime bidOn) {
        this.bidId = bidId;
        this.auction = auction;
        this.customer = customer;
        this.bidPrice = bidPrice;
        this.bidOn = bidOn;
    }

    public Auction_Bids() {
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Auction_Product getAuction() {
        return auction;
    }

    public void setAuction(Auction_Product auction) {
        this.auction = auction;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public LocalDateTime getBidOn() {
        return bidOn;
    }

    public void setBidOn(LocalDateTime bidOn) {
        this.bidOn = bidOn;
    }

    @Override
    public String toString() {
        return "Auction_Bids{" +
                "bidId=" + bidId +
                ", auction=" + auction +
                ", customer=" + customer +
                ", bidPrice=" + bidPrice +
                ", bidOn=" + bidOn +
                '}';
    }
}
