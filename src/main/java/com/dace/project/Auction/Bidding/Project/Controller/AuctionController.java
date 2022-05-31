package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.Category;
import com.dace.project.Auction.Bidding.Project.Service.Auction_Service_implementation;
import com.dace.project.Auction.Bidding.Project.Service.Category_Service_Implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class AuctionController {

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private Category_Service_Implementation categoryServiceImplementation;


    //***************************************AUCTION API********************************************************

    @PostMapping(value = "/createAuction")
    public Auction_Product createAuctionProduct(@RequestBody Auction_Product product){

        Auction_Product auctionProduct = auctionServiceImplementation.createAuctionProduct(product);

        return auctionProduct;

    }

    @GetMapping("/auction")
    public List<Auction_Product> getAllAuctionProducts(){

        List<Auction_Product> productList = auctionServiceImplementation.getAllAuctionProduct();

        return productList;

    }
//    @GetMapping("/auction/{id}")
//    public Auction_Product getSingleAuctionProduct(@PathVariable("id") Long id){
//
//        Auction_Product product = auctionServiceImplementation.getSingleAuctionProduct(id);
//
//        return product;
//    }

    @DeleteMapping("/auction/{id}")
    public String deleteAuctionProduct(@PathVariable("id") Long id){

        auctionServiceImplementation.deleteAuctionProduct(id);

        return "Auction Deleted Successfully";

    }

    @PutMapping("/auction/{id}")
    public Auction_Product updateAuctionProduct(@RequestBody Auction_Product product,@PathVariable("id") Long id){

        Auction_Product auctionProduct = auctionServiceImplementation.updateAuctionProduct(product,id);

        return auctionProduct;
    }


    @GetMapping("/category/{id}")
    public List<Auction_Product> findByCategory(@PathVariable("id") Long id){

        Category category = categoryServiceImplementation.getSingleCategory(id);

        List<Auction_Product> auctionProductList = auctionServiceImplementation.findByCategory(id);

        return auctionProductList;

    }


    //***************************************CATEGORY API********************************************************


    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category){

        Category category1 = categoryServiceImplementation.createCategory(category);

        return category1;

    }

//    @GetMapping("/category/{id}")
//    public Category getSingleCategory(@PathVariable("id") Long id){
//        Category category = categoryServiceImplementation.getSingleCategory(id);
//
//        return category;
//    }
//

    @GetMapping("/category")
    public List<Category> getAllCategory(){
        List<Category> categoryList = categoryServiceImplementation.getAllCategory();

        return categoryList;
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@RequestBody Category category ,@PathVariable("id") Long id){

        Category category1 = categoryServiceImplementation.updateCategory(category,id);

        return category1;
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryServiceImplementation.deleteCategory(id);

        return "Category Successfully Deleted";
    }

    @PostMapping("/upload")
    public String testApi(@RequestParam("file") MultipartFile file){
        String imageFileName = StringUtils.cleanPath(file.getOriginalFilename());
        return imageFileName;
    }


}
