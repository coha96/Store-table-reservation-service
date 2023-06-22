package com.zerobase.storetable.repository;

import com.zerobase.storetable.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
