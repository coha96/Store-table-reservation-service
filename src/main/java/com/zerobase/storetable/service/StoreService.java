package com.zerobase.storetable.service;

import com.zerobase.storetable.dto.StoreRegistrationRequest;
import com.zerobase.storetable.entity.Partner;
import com.zerobase.storetable.entity.Store;
import com.zerobase.storetable.repository.StoreRepository;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store registerStore(StoreRegistrationRequest request) {
        Store store = new Store(request.getName(), request.getLocation(), request.getDescription());
        return storeRepository.save(store);
    }

}
