package com.emiz.cinema.services.impl;

import com.emiz.cinema.models.Banner;
import com.emiz.cinema.repos.BannerRepo;
import com.emiz.cinema.services.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class BannerServiceImpl implements BannerService {

    private BannerRepo bannerRepo;

    public BannerServiceImpl(BannerRepo bannerRepo) {
        this.bannerRepo = bannerRepo;
    }

    @Override
    public List<Banner> getAllBanners() {
        return bannerRepo.findAll();
    }

    @Override
    public Banner storeBanner(Banner banner,MultipartFile imageFile) throws IOException {
        String folder = "src/main/resources/static/assets/banners/";
        String filename = UUID.randomUUID().toString();
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + filename+".jpg");
        Files.write(path,bytes);
        banner.setBanner_image(filename+".jpg");
        return bannerRepo.save(banner);
    }

    @Override
    public void deleteBanner(Long id) {
        Banner banner = bannerRepo.findById(id).get();
        String imageName = banner.getBanner_image();
        File fileToDelete = new File("src/main/resources/static/assets/banners/"+imageName);
        fileToDelete.delete();
        bannerRepo.deleteById(id);
    }
}
