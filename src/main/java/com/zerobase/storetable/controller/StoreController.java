package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.StoreRegistrationRequest;
import com.zerobase.storetable.entity.Partner;
import com.zerobase.storetable.entity.Store;
import com.zerobase.storetable.service.PartnerService;
import com.zerobase.storetable.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;
    private final PartnerService partnerService;

    public StoreController(StoreService storeService, PartnerService partnerService) {
        this.storeService = storeService;
        this.partnerService = partnerService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Store> getStoreByName(@PathVariable String name) {
        Store store = storeService.getStoreByName(name);
        if (store != null) {
            store.setPartner(null); // 파트너 정보를 null 로 설정하여 응답에서 제외
            return ResponseEntity.ok(store);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerStore(@Valid @RequestBody StoreRegistrationRequest request) {
        Long partnerId = request.getPartnerId();
        if (partnerId == null || partnerId == 0) {
            return ResponseEntity.notFound().build();
        }
        Partner partner = partnerService.getPartnerById(partnerId);
        if (partner == null) {
            return ResponseEntity.notFound().build();
        }
        storeService.registerStore(request, partner);

        return ResponseEntity.ok("매장 등록이 완료되었습니다.");
    }

}