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

    public Store registerStore(StoreRegistrationRequest request, Partner partner) {
        Store store = new Store(request.getName(), request.getLocation(),
                request.getDescription(), partner);
        return storeRepository.save(store);
    }

    public Store getStoreById(String id) {
        Optional<Store> optionalStore = storeRepository.findById(id);
        return optionalStore.orElse(null);
    }

}