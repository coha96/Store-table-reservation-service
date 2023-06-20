package com.zerobase.storetable.service;

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

    public Partner registerPartner(String name, String email,String password) {
        Partner partner = new Partner(name, email, password);
        return partnerRepository.save(partner);
    }

    public Partner getPartnerById(Long id) {
        Optional<Partner> partnerOptional = partnerRepository.findById(id);
        return partnerOptional.orElse(null);
    }
}
