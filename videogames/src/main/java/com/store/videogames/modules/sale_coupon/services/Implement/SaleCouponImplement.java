package com.store.videogames.modules.sale_coupon.services.Implement;

import com.store.videogames.modules.coupon.entity.Coupon;
import com.store.videogames.modules.coupon.repository.CouponRepository;
import com.store.videogames.modules.sale.entity.Sale;
import com.store.videogames.modules.sale.repository.SaleRepository;
import com.store.videogames.modules.sale_coupon.dto.SaleCouponDTO;
import com.store.videogames.modules.sale_coupon.entity.SaleCouponId;
import com.store.videogames.modules.sale_coupon.mapper.SaleCouponMapper;
import com.store.videogames.modules.sale_coupon.repository.SaleCouponRepository;
import com.store.videogames.modules.sale_coupon.services.Interface.ISaleCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleCouponImplement implements ISaleCoupon {

    @Autowired private SaleCouponRepository data;
    @Autowired private SaleRepository saleRepository;
    @Autowired private CouponRepository couponRepository;
    @Autowired private SaleCouponMapper mapper;

    private Sale findSale(String id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale no encontrada: " + id));
    }

    private Coupon findCoupon(String id) {
        return couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon no encontrado: " + id));
    }

    @Override
    public String Create(SaleCouponDTO dto) {
        try {
            data.save(mapper.toEntity(dto, findSale(dto.getId_sale()), findCoupon(dto.getId_coupon())));
            return "SaleCoupon creado correctamente";
        } catch (Exception e) {
            return "Error al crear sale_coupon: " + e.getMessage();
        }
    }

    @Override
    public List<SaleCouponDTO> GetAll() {
        return data.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public boolean Delete(String idSale, String idCoupon) {
        SaleCouponId id = new SaleCouponId(idSale, idCoupon);
        if (!data.existsById(id)) return false;
        data.deleteById(id);
        return true;
    }
}