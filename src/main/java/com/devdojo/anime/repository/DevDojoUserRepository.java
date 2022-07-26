package com.devdojo.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devdojo.anime.domain.DevDojoUser;

public interface DevDojoUserRepository extends JpaRepository<DevDojoUser, Long>{
  DevDojoUser findByUsername(String username);
}
