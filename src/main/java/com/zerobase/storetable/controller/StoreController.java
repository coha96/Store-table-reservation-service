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

    /**
     * 지정된 상점 이름으로 상점을 조회합니다.
     *
     * @param name 상점 이름
     * @return 상점 엔티티 객체 (존재하지 않을 경우 404 응답)
     */
    @GetMapping("/{name}")
    public ResponseEntity<Store> getStoreByName(@PathVariable String name) {
        Store store = storeService.getStoreByName(name);
        if (store != null) {
            store.setPartner(null);
            return ResponseEntity.ok(store);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 상점을 등록합니다.
     *
     * @param request 등록할 상점의 정보를 담고 있는 요청 객체
     * @return 성공적으로 등록되었을 경우 200 응답, 그렇지 않은 경우 404 응답
     */
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