package com.sparta.reviewservice.repository;

import com.sparta.reviewservice.entity.Product;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //비관적 락
    //트랜잭션끼리의 충돌이 발생한다고 가정하고 우선 락을 검
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Product p where p.id =:productId")
    Optional<Product> findByIdForUpdate(@Param("productId") Long productId);}
