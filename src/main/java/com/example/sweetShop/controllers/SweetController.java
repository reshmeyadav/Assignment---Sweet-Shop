package com.example.sweetShop.controllers;

import com.example.sweetShop.dto.PurchaseRequest;
import com.example.sweetShop.dto.SweetDto;
import com.example.sweetShop.services.SweetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetService service;

    public SweetController(SweetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SweetDto> create(@Valid @RequestBody SweetDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<SweetDto>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<SweetDto>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return ResponseEntity.ok(service.search(name, category, minPrice, maxPrice));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SweetDto> update(@PathVariable Long id, @Valid @RequestBody SweetDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/purchase")
    public ResponseEntity<SweetDto> purchase(@PathVariable Long id, @Valid @RequestBody PurchaseRequest req) {
        return ResponseEntity.ok(service.purchase(id, req.getQuantity()));
    }

    @PostMapping("/{id}/restock")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SweetDto> restock(@PathVariable Long id, @Valid @RequestBody PurchaseRequest req) {
        return ResponseEntity.ok(service.restock(id, req.getQuantity()));
    }
}

