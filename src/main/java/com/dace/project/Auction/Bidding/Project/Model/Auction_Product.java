package com.dace.project.Auction.Bidding.Project.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Auction_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;
    @ManyToOne
    @JoinColumn(name="Posted_By", nullable=false)
    private User auctionBy;

    private String auctionTitle;

    private double auctionStartingPrice;

    private String auctionPostedDate;

    private String auctionEndingDate;

    private Long auctionCategoryId;

    @ManyToOne
    @JoinColumn(name="Category_Id", nullable=false)
    private Category auctionCategory;

    private String auctionDescription;

    private int active;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String images;


    public Auction_Product() {
    }

    public Auction_Product(Long auctionId, User auctionBy, String auctionTitle, double auctionStartingPrice, String auctionPostedDate, String auctionEndingDate, Long auctionCategoryId, Category auctionCategory, String auctionDescription, int active, String images) {
        this.auctionId = auctionId;
        this.auctionBy = auctionBy;
        this.auctionTitle = auctionTitle;
        this.auctionStartingPrice = auctionStartingPrice;
        this.auctionPostedDate = auctionPostedDate;
        this.auctionEndingDate = auctionEndingDate;
        this.auctionCategoryId = auctionCategoryId;
        this.auctionCategory = auctionCategory;
        this.auctionDescription = auctionDescription;
        this.active = active;
        this.images = images;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public User getAuctionBy() {
        return auctionBy;
    }

    public void setAuctionBy(User auctionBy) {
        this.auctionBy = auctionBy;
    }

    public String getAuctionTitle() {
        return auctionTitle;
    }

    public void setAuctionTitle(String auctionTitle) {
        this.auctionTitle = auctionTitle;
    }

    public double getAuctionStartingPrice() {
        return auctionStartingPrice;
    }

    public void setAuctionStartingPrice(double auctionStartingPrice) {
        this.auctionStartingPrice = auctionStartingPrice;
    }

    public String getAuctionPostedDate() {
        return auctionPostedDate;
    }

    public void setAuctionPostedDate(String auctionPostedDate) {
        this.auctionPostedDate = auctionPostedDate;
    }

    public String getAuctionEndingDate() {
        return auctionEndingDate;
    }

    public void setAuctionEndingDate(String auctionEndingDate) {
        this.auctionEndingDate = auctionEndingDate;
    }

    public Long getAuctionCategoryId() {
        return auctionCategoryId;
    }

    public void setAuctionCategoryId(Long auctionCategoryId) {
        this.auctionCategoryId = auctionCategoryId;
    }

    public Category getAuctionCategory() {
        return auctionCategory;
    }

    public void setAuctionCategory(Category auctionCategory) {
        this.auctionCategory = auctionCategory;
    }

    public String getAuctionDescription() {
        return auctionDescription;
    }

    public void setAuctionDescription(String auctionDescription) {
        this.auctionDescription = auctionDescription;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Auction_Product{" +
                "auctionId=" + auctionId +
                ", auctionBy='" + auctionBy + '\'' +
                ", auctionTitle='" + auctionTitle + '\'' +
                ", auctionStartingPrice=" + auctionStartingPrice +
                ", auctionPostedDate=" + auctionPostedDate +
                ", auctionEndingDate=" + auctionEndingDate +
                ", auctionCategory='" + auctionCategory + '\'' +
                ", auctionDescription='" + auctionDescription + '\'' +
                ", active=" + active +
                ", images='" + images + '\'' +
                '}';
    }
}
