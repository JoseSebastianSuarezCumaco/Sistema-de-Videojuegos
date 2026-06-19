package com.store.videogames.modules.sale_coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.videogames.modules.sale_coupon.entity.SaleCoupon;
import com.store.videogames.modules.sale_coupon.entity.SaleCouponId;

public interface SaleCouponRepository extends JpaRepository<SaleCoupon, SaleCouponId> {}