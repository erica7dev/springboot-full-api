package com.devdojo.anime.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import com.devdojo.anime.domain.Anime;
import com.devdojo.anime.mapper.AnimeMapper;
import com.devdojo.anime.repository.AnimeRepository;
import com.devdojo.anime.requests.AnimePostRequestBody;
import com.devdojo.anime.requests.AnimePutRequestBody;

@Service
@RequiredArgsConstructor
public class AnimeService {
  
  private final AnimeRepository animeRepository;

  public List<Anime> listAll() {
    return animeRepository.findAll();
  }

  public Anime findByIdOrThrowBadRequestException(long id) {
    return animeRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
  }

  public Anime save(AnimePostRequestBody animePostRequestBody){
    return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
  }

  public void delete(long id) {
    animeRepository.delete(findByIdOrThrowBadRequestException(id));
  }

  public void replace(AnimePutRequestBody animePutRequestBody){
    Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
    Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
    anime.setId(savedAnime.getId());
    animeRepository.save(anime);
  }
}
