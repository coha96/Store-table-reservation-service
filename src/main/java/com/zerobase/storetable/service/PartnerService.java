package com.zerobase.storetable.service;

import com.zerobase.storetable.dto.PartnerRegistrationRequest;
import com.zerobase.storetable.entity.Partner;
import com.zerobase.storetable.repository.PartnerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }


    /**
     * 파트너를 등록합니다.
     *
     * @param request 파트너 등록 요청 객체
     * @return 등록된 파트너 엔티티
     */
    public Partner registerPartner(PartnerRegistrationRequest request) {
        Partner partner = new Partner(request.getName(), request.getEmail(),
                request.getPassword());
        return partnerRepository.save(partner);
    }

    /**
     * ID로 파트너를 조회합니다.
     *
     * @param id 파트너 ID
     * @return 조회된 파트너 엔티티
     */
    public Partner getPartnerById(Long id) {
        Optional<Partner> partnerOptional = partnerRepository.findById(id);
        return partnerOptional.orElse(null);
    }

    /**
     * 이름으로 파트너를 조회합니다.
     *
     * @param name 파트너 이름
     * @return 조회된 파트너 엔티티
     */
    public Partner getPartnerByName(String name) {
        return partnerRepository.findFirstByName(name);
    }
}