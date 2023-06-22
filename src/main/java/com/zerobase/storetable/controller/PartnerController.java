package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.PartnerRegistrationRequest;
import com.zerobase.storetable.dto.StoreRegistrationRequest;
import com.zerobase.storetable.entity.Partner;
import com.zerobase.storetable.entity.Store;
import com.zerobase.storetable.service.PartnerService;
import com.zerobase.storetable.service.StoreService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partners")
public class PartnerController {
    private final PartnerService partnerService;
    private final StoreService storeService;
    //private final BCryptPasswordEncoder passwordEncoder;

    public PartnerController(PartnerService partnerService, StoreService storeService) {
        //BCryptPasswordEncoder passwordEncoder
        this.partnerService = partnerService;
        this.storeService = storeService;
        //this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartner(@PathVariable Long id) {
        Partner partner = partnerService.getPartnerById(id);
        if (partner != null) {
            return ResponseEntity.ok(partner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Partner> registerPartner(@Validated @RequestBody PartnerRegistrationRequest request) {
        //String encryptedPassword = passwordEncoder.encode(request.getPassword());
        //request.setPassword(encryptedPassword);

        Partner partner = partnerService.registerPartner(request);
        return ResponseEntity.ok(partner);
    }

    @PostMapping("/{partnerId}/stores/register")
    public ResponseEntity<Store> registerStore(@PathVariable @NotNull Long partnerId, @Valid @RequestBody StoreRegistrationRequest request) {
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