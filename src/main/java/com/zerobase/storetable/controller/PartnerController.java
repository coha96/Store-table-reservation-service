package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.PartnerRegistrationRequest;
import com.zerobase.storetable.entity.Partner;
import com.zerobase.storetable.service.PartnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partners")
public class PartnerController {
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
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
        Partner partner = partnerService.registerPartner(request);
        return ResponseEntity.ok(partner);
    }
}