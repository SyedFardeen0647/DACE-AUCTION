package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.DTO.BannerDTO;
import com.dace.project.Auction.Bidding.Project.Model.HighlightBanner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HighlightBannerService {

    public HighlightBanner saveHighlightBanner(BannerDTO bannerDTO , MultipartFile multipartFile);

    List<HighlightBanner> getBanner();

    public String deleteHighLightBanner(Long id);
}
