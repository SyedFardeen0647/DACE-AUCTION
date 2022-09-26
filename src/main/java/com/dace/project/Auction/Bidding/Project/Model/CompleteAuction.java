package com.dace.project.Auction.Bidding.Project.Model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CompleteAuction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long completeId;

    @ManyToOne
    private User auctionWonBy;

    @ManyToOne
    private Auction_Product auctionProduct;

    private LocalDateTime auctionCompleted;

    private Double winningBidPrice;

    private Double productCommission;

    private Integer active;

    public CompleteAuction(Long completeId, User auctionWonBy, Auction_Product auctionProduct, LocalDateTime auctionCompleted, Double winningBidPrice, Double productCommission, Integer active) {
        this.completeId = completeId;
        this.auctionWonBy = auctionWonBy;
        this.auctionProduct = auctionProduct;
        this.auctionCompleted = auctionCompleted;
        this.winningBidPrice = winningBidPrice;
        this.productCommission = productCommission;
        this.active = active;
    }

    public CompleteAuction() {
    }

    public Long getCompleteId() {
        return completeId;
    }

    public void setCompleteId(Long completeId) {
        this.completeId = completeId;
    }

    public User getAuctionWonBy() {
        return auctionWonBy;
    }

    public void setAuctionWonBy(User auctionWonBy) {
        this.auctionWonBy = auctionWonBy;
    }

    public Auction_Product getAuctionProduct() {
        return auctionProduct;
    }

    public void setAuctionProduct(Auction_Product auctionProduct) {
        this.auctionProduct = auctionProduct;
    }

    public LocalDateTime getAuctionCompleted() {
        return auctionCompleted;
    }

    public void setAuctionCompleted(LocalDateTime auctionCompleted) {
        this.auctionCompleted = auctionCompleted;
    }

    public Double getWinningBidPrice() {
        return winningBidPrice;
    }

    public void setWinningBidPrice(Double winningBidPrice) {
        this.winningBidPrice = winningBidPrice;
    }

    public Double getProductCommission() {
        return productCommission;
    }

    public void setProductCommission(Double productCommission) {
        this.productCommission = productCommission;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CompleteAuctionController{" +
                "completeId=" + completeId +
                ", auctionWonBy=" + auctionWonBy +
                ", auctionProduct=" + auctionProduct +
                ", auctionCompleted=" + auctionCompleted +
                ", winningBidPrice=" + winningBidPrice +
                ", active=" + active +
                '}';
    }
}
