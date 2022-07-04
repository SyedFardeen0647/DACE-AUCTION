package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.DTO.BannerDTO;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.HighlightBanner;
import com.dace.project.Auction.Bidding.Project.Repository.AuctionRepository;
import com.dace.project.Auction.Bidding.Project.Repository.HighlightBannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class HighLightBannerImplementation implements HighlightBannerService{

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private HighlightBannerRepository highlightBannerRepository;


    @Override
    public HighlightBanner saveHighlightBanner(BannerDTO bannerDTO , MultipartFile multipartFile) {

        HighlightBanner banner = new HighlightBanner();
        Auction_Product auctionProduct = auctionRepository.findById(bannerDTO.getAuctionId()).get();
        banner.setBannerDescription(bannerDTO.getDescription());
        try {
            banner.setImages(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        banner.setAuctionProduct(auctionProduct);



        return highlightBannerRepository.save(banner);
    }

    @Override
    public List<HighlightBanner> getBanner() {
        return highlightBannerRepository.findAll();
    }


    @Override
    public void deleteHighLightBanner() {
        highlightBannerRepository.deleteAll();
    }

    @Override
    public Long bannerCount() {
        return highlightBannerRepository.count();
    }
}
