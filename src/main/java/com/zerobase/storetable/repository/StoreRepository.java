package com.zerobase.storetable.repository;

import com.zerobase.storetable.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, String> {
    boolean existsByName(String storename);
    Optional<Store> findById(String name);

    // findByPartner 메소드는 특정 파트너 ID에 해당하는 매장들을 조회하기 위해 사용.
//    List<Store> findByPartnerId(Long partnerId);
}

