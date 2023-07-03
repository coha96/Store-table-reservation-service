package com.zerobase.storetable.repository;

import com.zerobase.storetable.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

    /**
     * 이름으로 첫 번째 파트너를 찾습니다.
     *
     * @param name 파트너 이름
     * @return 파트너 엔티티
     */
    Partner findFirstByName(String name);
}
