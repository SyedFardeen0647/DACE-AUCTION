package com.dace.project.Auction.Bidding.Project.Service;

import com.dace.project.Auction.Bidding.Project.Model.HighlightBanner;

public interface HighlightBannerService {

    public HighlightBanner saveHighlightBanner(HighlightBanner highlightBanner);

    public String deleteHighLightBanner(Long id);
}
