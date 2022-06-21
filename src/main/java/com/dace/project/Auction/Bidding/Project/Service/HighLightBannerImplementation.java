package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.HighlightBanner;
import com.dace.project.Auction.Bidding.Project.Repository.AuctionRepository;
import com.dace.project.Auction.Bidding.Project.Repository.HighlightBannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HighLightBannerImplementation implements HighlightBannerService{

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private HighlightBannerRepository highlightBannerRepository;


    @Override
    public HighlightBanner saveHighlightBanner(HighlightBanner highlightBanner) {

        HighlightBanner banner = new HighlightBanner();
        Auction_Product auctionProduct = auctionRepository.findById(highlightBanner.getAuctionProduct().getAuctionId()).get();

        banner.setBannerDescription(highlightBanner.getBannerDescription());
        banner.setImages(highlightBanner.getImages());
        banner.setAuctionProduct(auctionProduct);



        return highlightBannerRepository.save(banner);
    }

    @Override
    public String deleteHighLightBanner(Long id) {
        return null;
    }
}
