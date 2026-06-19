package com.store.videogames.modules.sale_coupon.entity;

import com.store.videogames.modules.coupon.entity.Coupon;
import com.store.videogames.modules.sale.entity.Sale;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "sale_coupon")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SaleCoupon {

    @EmbeddedId
    private SaleCouponId id;

    @ManyToOne
    @MapsId("id_sale")
    @JoinColumn(name = "id_sale", nullable = false)
    private Sale sale;

    @ManyToOne
    @MapsId("id_coupon")
    @JoinColumn(name = "id_coupon", nullable = false)
    private Coupon coupon;
}