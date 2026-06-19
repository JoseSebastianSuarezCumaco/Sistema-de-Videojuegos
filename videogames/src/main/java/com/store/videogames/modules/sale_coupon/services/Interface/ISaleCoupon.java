package com.store.videogames.modules.sale_coupon.services.Interface;

import java.util.List;

import com.store.videogames.modules.sale_coupon.dto.SaleCouponDTO;

public interface ISaleCoupon {
    String Create(SaleCouponDTO dto);
    List<SaleCouponDTO> GetAll();
    boolean Delete(String idSale, String idCoupon);
}