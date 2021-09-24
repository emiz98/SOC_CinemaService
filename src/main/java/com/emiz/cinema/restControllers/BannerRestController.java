package com.emiz.cinema.restControllers;

import com.emiz.cinema.models.Banner;
import com.emiz.cinema.services.BannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BannerRestController {

    private BannerService bannerService;

    public BannerRestController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/banners")
    public List<Banner> getAllBanners(){
        return bannerService.getAllBanners();
    }
}
