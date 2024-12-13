package com.sparta.reviewservice.repository;

import com.sparta.reviewservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 첫 페이지 조회 (cursor가 없을 때)
    List<Review> findAllByProductIdOrderByIdDesc(Long productId, Pageable pageable);

    // 커서 기반 페이징 (cursor가 있을 때)
    List<Review> findByProductIdAndIdLessThanOrderByIdDesc(Long productId, Long cursorId, Pageable pageable);

    boolean existsByProductIdAndUserId(Long productId, Long userId);
}