package com.project.fanla.service;

import com.project.fanla.model.Lyrics;
import com.project.fanla.repository.LyricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LyricsService {

    private final LyricsRepository lyricsRepository;

    @Autowired
    public LyricsService(LyricsRepository lyricsRepository) {
        this.lyricsRepository = lyricsRepository;
    }

    public List<Lyrics> getAllLyrics() {
        return lyricsRepository.findAll();
    }

    public Optional<Lyrics> getLyricsById(Long id) {
        return lyricsRepository.findById(id);
    }

    public Lyrics saveLyrics(Lyrics lyrics) {
        return lyricsRepository.save(lyrics);
    }

    public void deleteLyrics(Long id) {
        lyricsRepository.deleteById(id);
    }
}
