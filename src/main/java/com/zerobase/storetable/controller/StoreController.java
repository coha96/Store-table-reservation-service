package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.StoreRegistrationRequest;
import com.zerobase.storetable.entity.Partner;
import com.zerobase.storetable.entity.Store;
import com.zerobase.storetable.service.PartnerService;
import com.zerobase.storetable.service.StoreService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/stores")
public class StoreController {
    private final StoreService storeService;
    private final PartnerService partnerService;

    public StoreController(StoreService storeService, PartnerService partnerService) {
        this.storeService = storeService;
        this.partnerService = partnerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Store> registerStore(@RequestParam("partnerId") @NotNull Long partnerId, @Valid @RequestBody StoreRegistrationRequest request) {
        if (partnerId == null || partnerId == 0) {
            return ResponseEntity.notFound().build();
        }
        Partner partner = partnerService.getPartnerById(partnerId);
        if (partner == null) {
            return ResponseEntity.notFound().build();
        }
        Store store = storeService.registerStore(request, partner);
        return ResponseEntity.ok(store);
    }
}