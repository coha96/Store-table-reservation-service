package com.zerobase.storetable.repository;

import com.zerobase.storetable.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, String> {
    boolean existsByName(String storename);

    Optional<Store> findById(String name);
}