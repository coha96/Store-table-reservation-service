package com.zerobase.storetable.repository;

import com.zerobase.storetable.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, String> {

    /**
     * 지정된 상점 이름이 존재하는지 확인합니다.
     *
     * @param storename 상점 이름
     * @return 상점 이름의 존재 여부
     */
    boolean existsByName(String storename);

    /**
     * 지정된 상점 name 으로 상점을 조회합니다.
     */

    Optional<Store> findById(String name);
}