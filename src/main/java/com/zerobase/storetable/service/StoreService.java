package com.zerobase.storetable.service;

import com.zerobase.storetable.dto.StoreRegistrationRequest;
import com.zerobase.storetable.entity.Partner;
import com.zerobase.storetable.entity.Store;
import com.zerobase.storetable.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    /**
     * 지정된 상점 이름으로 상점을 조회합니다.
     *
     * @param name 상점 이름
     * @return 상점 엔티티 객체 (존재하지 않을 경우 null 반환)
     */
    public Store getStoreByName(String name) {
        Optional<Store> storeOptional = storeRepository.findById(name);
        return storeOptional.orElse(null);
    }

    /**
     * 상점을 등록합니다.
     *
     * @param request 등록할 상점의 정보를 담고 있는 요청 객체
     * @param partner 등록하는 상점의 파트너 정보
     * @return 등록된 상점 엔티티 객체
     */
    public Store registerStore(StoreRegistrationRequest request, Partner partner) {
        Store store = new Store(request.getName(), request.getLocation(),
                request.getDescription(), partner);
        return storeRepository.save(store);
    }

    /**
     * 지정된 상점 이름이 이미 등록되었는지 확인합니다.
     *
     * @param storename 상점 이름
     * @return 상점 등록 여부
     */
    public boolean isStoreRegistered(String storename) {
        return storeRepository.existsByName(storename);
    }
}