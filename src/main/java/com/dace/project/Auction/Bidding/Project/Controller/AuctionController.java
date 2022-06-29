package com.dace.project.Auction.Bidding.Project.Controller;

import com.dace.project.Auction.Bidding.Project.DTO.CreateAuctionDTO;
import com.dace.project.Auction.Bidding.Project.Model.Auction_Product;
import com.dace.project.Auction.Bidding.Project.Model.Category;
import com.dace.project.Auction.Bidding.Project.Service.Auction_Service_implementation;
import com.dace.project.Auction.Bidding.Project.Service.Category_Service_Implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class AuctionController {

    @Autowired
    private Auction_Service_implementation auctionServiceImplementation;

    @Autowired
    private Category_Service_Implementation categoryServiceImplementation;


    //***************************************AUCTION API********************************************************








    @GetMapping("/auction")
    public List<Auction_Product> getAllAuctionProducts(){

        List<Auction_Product> productList = auctionServiceImplementation.getAllAuctionProduct();

        return productList;

    }

    @GetMapping("/auction/{id}")
    public String getSingleAuctionProduct(@PathVariable("id") Long id, Model model){

        Auction_Product product = auctionServiceImplementation.getSingleAuctionProduct(id);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm:ss");
        String formatDateTime = product.getAuctionEndingDate().format(formatter);

        model.addAttribute("auction",product);
        model.addAttribute("endDate",formatDateTime);


        return "single";
    }

    @GetMapping("/auction/delete/{id}")
    @ResponseBody
    public String deleteAuctionProduct(@PathVariable("id") Long id){

        auctionServiceImplementation.deleteAuctionProduct(id);

        return "Product Deleted Successfully";

    }

    @PutMapping("/auction/{id}")
    public Auction_Product updateAuctionProduct(@RequestBody Auction_Product product,@PathVariable("id") Long id){

        Auction_Product auctionProduct = auctionServiceImplementation.updateAuctionProduct(product,id);

        return auctionProduct;
    }

    @GetMapping("/admin/auction/count")
    public Long auctionCount(){
        return auctionServiceImplementation.allAuctionCount();
    }





    //***************************************CATEGORY API********************************************************


    @PostMapping("/createCategory")
    @ResponseBody
    public String createCategory(String categoryName){

        Category category1 = categoryServiceImplementation.createCategory(categoryName);

        return "New Category Created ";

    }

    @GetMapping("/category/{id}")
    public List<Auction_Product> findByCategory(@PathVariable("id") Long id){

        Category category = categoryServiceImplementation.getSingleCategory(id);

        List<Auction_Product> auctionProductList = auctionServiceImplementation.findByCategory(id);

        return auctionProductList;

    }

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

    @GetMapping("/category/delete/{id}")
    @ResponseBody
    public String deleteCategory(@PathVariable("id") Long id){
        categoryServiceImplementation.deleteCategory(id);

        return "Category Deleted successfully";
    }

    @PostMapping("/upload")
    public String testApi(@RequestParam("file") MultipartFile file){
        String imageFileName = StringUtils.cleanPath(file.getOriginalFilename());
        return imageFileName;
    }

    @GetMapping("/admin/category/count")
    public Long categoryCount(){
        return categoryServiceImplementation.categoryCount();
    }


}
