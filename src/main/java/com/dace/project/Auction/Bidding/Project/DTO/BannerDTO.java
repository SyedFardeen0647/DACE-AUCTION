package com.dace.project.Auction.Bidding.Project.DTO;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class BannerDTO {

    private  String description;

    private Long auctionId;

    private MultipartFile[] image;


    public BannerDTO() {
    }

    public BannerDTO(String description, Long auctionId, MultipartFile[] image) {
        this.description = description;
        this.auctionId = auctionId;
        this.image = image;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public MultipartFile[] getImage() {
        return image;
    }

    public void setImage(MultipartFile[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "BannerDTO{" +
                "description='" + description + '\'' +
                ", auctionId=" + auctionId +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
