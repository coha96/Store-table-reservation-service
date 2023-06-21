package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.PartnerRegistrationRequest;
import com.zerobase.storetable.dto.StoreRegistrationRequest;
import com.zerobase.storetable.entity.Partner;
import com.zerobase.storetable.entity.Store;
import com.zerobase.storetable.service.PartnerService;
import com.zerobase.storetable.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partners")
public class PartnerController {
    private final PartnerService partnerService;
    private final StoreService storeService;

    public PartnerController(PartnerService partnerService, StoreService storeService) {
        this.partnerService = partnerService;
        this.storeService = storeService;
    }

    // Partner 조회 API 엔드포인트
    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartner(@PathVariable Long id) {
        Partner partner = partnerService.getPartnerById(id);
        if (partner != null) {
            return ResponseEntity.ok(partner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Partner 등록 API 엔드포인트
    @PostMapping("/register")
    public ResponseEntity<Partner> registerPartner(@Validated @RequestBody PartnerRegistrationRequest request) {
        Partner partner = partnerService.registerPartner(request);
        return ResponseEntity.ok(partner);
    }

    // 매장 등록 API 엔드포인트
    @PostMapping("/stores/register")
    public ResponseEntity<Store> registerStore(@Validated @RequestBody StoreRegistrationRequest request) {
        Store store = storeService.registerStore(request);
        return ResponseEntity.ok(store);
    }
}