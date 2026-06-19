package com.store.videogames.modules.sale_detail.services.Implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.videogames.modules.game.entity.Game;
import com.store.videogames.modules.game.repository.GameRepository;
import com.store.videogames.modules.sale.entity.Sale;
import com.store.videogames.modules.sale.repository.SaleRepository;
import com.store.videogames.modules.sale_detail.dto.SaleDetailDTO;
import com.store.videogames.modules.sale_detail.mapper.SaleDetailMapper;
import com.store.videogames.modules.sale_detail.repository.SaleDetailRepository;
import com.store.videogames.modules.sale_detail.services.Interface.ISaleDetail;

@Service
public class SaleDetailImplement implements ISaleDetail {

    @Autowired private SaleDetailRepository data;
    @Autowired private SaleRepository saleRepository;
    @Autowired private GameRepository gameRepository;
    @Autowired private SaleDetailMapper mapper;

    private Sale findSale(String id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale no encontrada: " + id));
    }

    private Game findGame(String id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game no encontrado: " + id));
    }

    @Override
    public String Create(SaleDetailDTO dto) {
        try {
            data.save(mapper.toEntity(dto, findSale(dto.getId_sale()), findGame(dto.getId_game())));
            return "SaleDetail creado correctamente";
        } catch (Exception e) {
            return "Error al crear sale_detail: " + e.getMessage();
        }
    }

    @Override
    public List<SaleDetailDTO> GetAll() {
        return data.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public SaleDetailDTO GetById(String id) {
        return data.findById(id).map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("SaleDetail no encontrado: " + id));
    }

    @Override
    public String Update(String id, SaleDetailDTO dto) {
        var sd = data.findById(id)
                .orElseThrow(() -> new RuntimeException("SaleDetail no encontrado: " + id));
        sd.setQuantity(dto.getQuantity());
        sd.setUnit_price(dto.getUnit_price());
        sd.setDiscount_applied(dto.getDiscount_applied());
        sd.setId_sale(findSale(dto.getId_sale()));
        sd.setId_game(findGame(dto.getId_game()));
        data.save(sd);
        return "SaleDetail actualizado correctamente";
    }

    @Override
    public boolean Delete(String id) {
        if (!data.existsById(id)) return false;
        data.deleteById(id);
        return true;
    }
}