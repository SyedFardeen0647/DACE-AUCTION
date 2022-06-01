package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.DTO.CreateAuctionDTO;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Auction_Service {

    public Auction_Product createAuctionProduct(CreateAuctionDTO product, MultipartFile file);

    public Auction_Product updateAuctionProduct(Auction_Product product,Long id);

    public Auction_Product getSingleAuctionProduct(Long id);

    public List<Auction_Product> getAllAuctionProduct();

    public void deleteAuctionProduct(Long id);

    public List<Auction_Product> getAllAuctionProductByCategory(Long id);

    public List<Auction_Product> findAuctionByActive(int active);

    List<Auction_Product> findByCategory(Long id);
}
