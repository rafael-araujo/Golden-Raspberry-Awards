package com.example.demo.repository;

import com.example.demo.entity.MovieAwardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieAwardRepository extends JpaRepository<MovieAwardEntity, Long> {

    List<MovieAwardEntity> findByWinnerTrueOrderByYearAsc();
}
