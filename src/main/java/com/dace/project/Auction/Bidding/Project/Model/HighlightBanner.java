package com.dace.project.Auction.Bidding.Project.Model;

import javax.persistence.*;

@Entity
public class HighlightBanner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bannerId;

    private String bannerDescription;

    private String images;

    @ManyToOne
    private Auction_Product auctionProduct;

    public HighlightBanner() {
    }

    public HighlightBanner(Long bannerId, String bannerDescription, String images, Auction_Product auctionProduct) {
        this.bannerId = bannerId;
        this.bannerDescription = bannerDescription;
        this.images = images;
        this.auctionProduct = auctionProduct;
    }

    public Long getBannerId() {
        return bannerId;
    }

    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerDescription() {
        return bannerDescription;
    }

    public void setBannerDescription(String bannerDescription) {
        this.bannerDescription = bannerDescription;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Auction_Product getAuctionProduct() {
        return auctionProduct;
    }

    public void setAuctionProduct(Auction_Product auctionProduct) {
        this.auctionProduct = auctionProduct;
    }

    @Override
    public String toString() {
        return "HighlightBanner{" +
                "bannerId=" + bannerId +
                ", bannerDescription='" + bannerDescription + '\'' +
                ", images='" + images + '\'' +
                ", auctionProduct=" + auctionProduct +
                '}';
    }
}
