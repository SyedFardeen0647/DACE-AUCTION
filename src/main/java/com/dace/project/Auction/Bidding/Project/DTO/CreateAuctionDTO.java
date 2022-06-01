package com.dace.project.Auction.Bidding.Project.DTO;

import org.springframework.web.multipart.MultipartFile;

public class CreateAuctionDTO {


    private String title;

    private double startingPrice;

    private String endingDate;

    private Long category;

    private String description;

    private MultipartFile[] images;

    public CreateAuctionDTO(String title, double startingPrice, String endingDate, Long category, String description, MultipartFile[] images) {
        this.title = title;
        this.startingPrice = startingPrice;
        this.endingDate = endingDate;
        this.category = category;
        this.description = description;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile[] getImages() {
        return images;
    }

    public void setImages(MultipartFile[] images) {
        this.images = images;
    }
}
