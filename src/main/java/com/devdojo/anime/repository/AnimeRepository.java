package com.devdojo.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devdojo.anime.domain.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
  
