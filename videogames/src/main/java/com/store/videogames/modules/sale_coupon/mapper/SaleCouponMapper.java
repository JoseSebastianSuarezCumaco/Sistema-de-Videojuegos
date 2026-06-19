package com.store.videogames.modules.sale_coupon.mapper;

import com.store.videogames.modules.coupon.entity.Coupon;
import com.store.videogames.modules.sale.entity.Sale;
import com.store.videogames.modules.sale_coupon.dto.SaleCouponDTO;
import com.store.videogames.modules.sale_coupon.entity.SaleCoupon;
import com.store.videogames.modules.sale_coupon.entity.SaleCouponId;
import org.springframework.stereotype.Component;

@Component
public class SaleCouponMapper {

    public SaleCouponDTO toDTO(SaleCoupon sc) {
        SaleCouponDTO dto = new SaleCouponDTO();
        dto.setId_sale(sc.getId().getId_sale());
        dto.setId_coupon(sc.getId().getId_coupon());
        return dto;
    }

    public SaleCoupon toEntity(SaleCouponDTO dto, Sale sale, Coupon coupon) {
        SaleCouponId id = new SaleCouponId(dto.getId_sale(), dto.getId_coupon());
        return new SaleCoupon(id, sale, coupon);
    }
}