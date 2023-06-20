package com.zerobase.storetable.repository;

import com.zerobase.storetable.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
