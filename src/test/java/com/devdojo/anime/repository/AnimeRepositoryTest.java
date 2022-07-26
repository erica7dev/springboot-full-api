package com.devdojo.anime.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.devdojo.anime.domain.Anime;

@DataJpaTest
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {
  @Autowired
  private AnimeRepository animeRepository;

  @Test
  @DisplayName("Save creates anime when Successful")
  void save_PersistAnime_WhenSuccessful(){
      Anime animeToBeSaved = createAnime();
      Anime animeSaved = this.animeRepository.save(animeToBeSaved);
      Assertions.assertThat(animeSaved).isNotNull();
      Assertions.assertThat(animeSaved.getId()).isNotNull();
      Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());

  }

  private Anime createAnime(){
    return Anime.builder()
            .name("Boku no Hero!")
            .build();
}
  
}
