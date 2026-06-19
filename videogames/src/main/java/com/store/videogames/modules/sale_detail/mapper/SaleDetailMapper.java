package com.store.videogames.modules.sale_detail.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.store.videogames.modules.game.entity.Game;
import com.store.videogames.modules.sale.entity.Sale;
import com.store.videogames.modules.sale_detail.dto.SaleDetailDTO;
import com.store.videogames.modules.sale_detail.entity.SaleDetail;

@Component
public class SaleDetailMapper {

    public SaleDetailDTO toDTO(SaleDetail sd) {
        SaleDetailDTO dto = new SaleDetailDTO();
        dto.setId_detail(sd.getId_detail());
        dto.setQuantity(sd.getQuantity());
        dto.setUnit_price(sd.getUnit_price());
        dto.setDiscount_applied(sd.getDiscount_applied());
        if (sd.getId_sale() != null) dto.setId_sale(sd.getId_sale().getId_sale());
        if (sd.getId_game() != null) dto.setId_game(sd.getId_game().getId_game());
        return dto;
    }

    public SaleDetail toEntity(SaleDetailDTO dto, Sale sale, Game game) {
        SaleDetail sd = new SaleDetail();
        sd.setQuantity(dto.getQuantity());
        sd.setUnit_price(dto.getUnit_price());
        sd.setDiscount_applied(
            dto.getDiscount_applied() != null ? dto.getDiscount_applied() : BigDecimal.ZERO
        );
        sd.setId_sale(sale);
        sd.setId_game(game);
        return sd;
    }
}