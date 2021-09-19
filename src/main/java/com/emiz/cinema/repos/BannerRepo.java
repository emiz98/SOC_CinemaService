package com.emiz.cinema.repos;

import com.emiz.cinema.models.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepo extends JpaRepository<Banner,Long> {
}
