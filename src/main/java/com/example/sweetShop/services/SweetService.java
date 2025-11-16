package com.example.sweetShop.services;

import com.example.sweetShop.dto.SweetDto;
import com.example.sweetShop.entities.Sweet;
import com.example.sweetShop.repositories.SweetRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SweetService {

    private final SweetRepository sweetRepository;

    public SweetService(SweetRepository sweetRepository) {
        this.sweetRepository = sweetRepository;
    }

    public SweetDto create(SweetDto dto) {
        if (sweetRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Sweet with this name already exists");
        }
        Sweet s = Sweet.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
        s = sweetRepository.save(s);
        dto.setId(s.getId());
        return dto;
    }

    public List<SweetDto> listAll() {
        return sweetRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<SweetDto> search(String name, String category, Double minPrice, Double maxPrice) {
        return sweetRepository.search(name, category, minPrice, maxPrice).stream().map(this::toDto).collect(Collectors.toList());
    }

    public SweetDto update(Long id, SweetDto dto) {
        Sweet s = sweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Sweet not found"));
        s.setName(dto.getName());
        s.setCategory(dto.getCategory());
        s.setPrice(dto.getPrice());
        s.setQuantity(dto.getQuantity());
        sweetRepository.save(s);
        return toDto(s);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id) {
        sweetRepository.deleteById(id);
    }

    public synchronized SweetDto purchase(Long id, int qty) {
        Sweet s = sweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Sweet not found"));
        if (s.getQuantity() < qty) {
            throw new RuntimeException("Not enough quantity in stock");
        }
        s.setQuantity(s.getQuantity() - qty);
        sweetRepository.save(s);
        return toDto(s);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public synchronized SweetDto restock(Long id, int qty) {
        Sweet s = sweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Sweet not found"));
        s.setQuantity(s.getQuantity() + qty);
        sweetRepository.save(s);
        return toDto(s);
    }

    private SweetDto toDto(Sweet s) {
        SweetDto d = new SweetDto();
        d.setId(s.getId());
        d.setName(s.getName());
        d.setCategory(s.getCategory());
        d.setPrice(s.getPrice());
        d.setQuantity(s.getQuantity());
        return d;
    }
}

