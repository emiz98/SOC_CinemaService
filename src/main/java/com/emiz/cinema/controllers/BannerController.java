package com.emiz.cinema.controllers;

import com.emiz.cinema.models.Banner;
import com.emiz.cinema.services.BannerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class BannerController {

    private BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/banners")
    public String getBanners(Model model){
        model.addAttribute("banners", bannerService.getAllBanners());
        return "views/banners/banners";
    }

    @GetMapping("/banners/new")
    public String createBanner(Model model){
        Banner banner = new Banner();
        model.addAttribute("banner",banner);
        return "views/banners/create";
    }

    @PostMapping("/banners")
    public String storeBanner(@ModelAttribute("banner") Banner banner, @RequestParam("imageFile")MultipartFile imageFile){
        try {
            bannerService.storeBanner(banner,imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/banners";
    }

    @GetMapping("/banners/{id}")
    public String deleteBanner(@PathVariable Long id){
        bannerService.deleteBanner(id);
        return "redirect:/banners";
    }
}
