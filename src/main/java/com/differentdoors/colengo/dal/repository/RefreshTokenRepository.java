package com.differentdoors.colengo.dal.repository;

import com.differentdoors.colengo.dal.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByName(String name);
}
