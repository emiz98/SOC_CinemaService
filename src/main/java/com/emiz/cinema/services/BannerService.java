package com.emiz.cinema.services;

import com.emiz.cinema.models.Banner;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BannerService {
    List<Banner> getAllBanners();
    Banner storeBanner(Banner banner,MultipartFile imageFile) throws IOException;
    void deleteBanner(Long id);
}
