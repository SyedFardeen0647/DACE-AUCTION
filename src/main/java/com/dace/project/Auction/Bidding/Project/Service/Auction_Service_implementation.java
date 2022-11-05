package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.DTO.CreateAuctionDTO;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.Category;
import com.dace.project.Auction.Bidding.Project.Model.User;
import com.dace.project.Auction.Bidding.Project.Repository.AuctionRepository;
import com.dace.project.Auction.Bidding.Project.Repository.CategoryRepository;
import com.dace.project.Auction.Bidding.Project.Repository.UserRepository;
import com.dace.project.Auction.Bidding.Project.Utlities.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.DateUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
@Service
public class Auction_Service_implementation implements Auction_Service {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Auction_Product createAuctionProduct(CreateAuctionDTO product, MultipartFile multipartFile) {


        Auction_Product auctionProduct = new Auction_Product();
        Category category = categoryRepository.findById(product.getCategory()).get();
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());



        auctionProduct.setAuctionBy(user);
        auctionProduct.setAuctionTitle(product.getTitle());
        auctionProduct.setAuctionStartingPrice(product.getStartingPrice());
        auctionProduct.setAuctionPostedDate(LocalDateTime.now());
        auctionProduct.setAuctionEndingDate(DateUtil.getDate(product.getEndingDate()));
        auctionProduct.setAuctionCategoryId(product.getCategory());
        auctionProduct.setAuctionCategory(category);
        auctionProduct.setAuctionDescription(product.getDescription());
        auctionProduct.setActive(1);
        try {
            auctionProduct.setImages(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return auctionRepository.save(auctionProduct);
    }

    @Override
    public Auction_Product updateAuctionProduct(Auction_Product product, Long id) {

        Auction_Product auctionProduct = auctionRepository.findById(id).get();
        auctionProduct.setAuctionBy(product.getAuctionBy());
        auctionProduct.setAuctionTitle(product.getAuctionTitle());
        auctionProduct.setAuctionStartingPrice(product.getAuctionStartingPrice());
        auctionProduct.setAuctionPostedDate(product.getAuctionPostedDate());
        auctionProduct.setAuctionEndingDate(product.getAuctionEndingDate());
        auctionProduct.setAuctionCategory(product.getAuctionCategory());
        auctionProduct.setAuctionDescription(product.getAuctionDescription());
        auctionProduct.setActive(product.getActive());
        auctionProduct.setImages(product.getImages());


        return auctionRepository.save(auctionProduct);
    }

    @Override
    public Auction_Product getSingleAuctionProduct(Long id) {
        Auction_Product auctionProduct = auctionRepository.findById(id).get();
        return auctionProduct;
    }

    @Override
    public List<Auction_Product> getAllAuctionProduct() {
        List<Auction_Product> productList = auctionRepository.findAll();
        return productList;
    }

    @Override
    public void deleteAuctionProduct(Long id) {
        auctionRepository.deleteById(id);
    }

    @Override
    public List<Auction_Product> getAllAuctionProductByCategory(Long id) {
        return null;
    }

    @Override
    public List<Auction_Product> findAuctionByActive(int active) {

        List<Auction_Product> activeAuction = auctionRepository.findByActive(active);

        return activeAuction;
    }

    @Override
    public List<Auction_Product> findByCategory(Long id) {
        return auctionRepository.findByAuctionCategoryId(id);
    }

    @Override
    public Long allAuctionCount() {
        return auctionRepository.count();
    }

    @Override
    public void updateProduct(CreateAuctionDTO product, MultipartFile multipartFile, Long id) {

        Auction_Product auctionProduct = auctionRepository.findById(id).get();

        Category category = categoryRepository.findById(product.getCategory()).get();
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());



        auctionProduct.setAuctionBy(user);
        auctionProduct.setAuctionTitle(product.getTitle());
        auctionProduct.setAuctionStartingPrice(product.getStartingPrice());
        auctionProduct.setAuctionPostedDate(LocalDateTime.now());
        auctionProduct.setAuctionEndingDate(DateUtil.getDate(product.getEndingDate()));
        auctionProduct.setAuctionCategoryId(product.getCategory());
        auctionProduct.setAuctionCategory(category);
        auctionProduct.setAuctionDescription(product.getDescription());
        auctionProduct.setActive(1);
        try {
            auctionProduct.setImages(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


         auctionRepository.save(auctionProduct);

    }


}
