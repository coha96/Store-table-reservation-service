package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.PartnerRegistrationRequest;
import com.zerobase.storetable.entity.Partner;
import com.zerobase.storetable.service.PartnerService;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/register")
    public ResponseEntity<String> registerPartner(@Validated @RequestBody PartnerRegistrationRequest request) {
        Partner existingPartner = partnerService.getPartnerByName(request.getName());
        if (existingPartner != null) {
            return ResponseEntity.badRequest().body("이미 사용 중인 이름입니다.");
        }

        Partner partner = partnerService.registerPartner(request);
        if (partner != null) {
            return ResponseEntity.ok("파트너 회원 가입이 완료되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파트너 회원 가입에 실패하였습니다.");
        }
    }

    // partner id 검색(개발자 확인용)
    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartner(@PathVariable Long id) {
        Partner partner = partnerService.getPartnerById(id);
        if (partner != null) {
            return ResponseEntity.ok(partner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}