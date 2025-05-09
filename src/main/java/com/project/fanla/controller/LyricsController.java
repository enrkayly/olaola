package com.project.fanla.controller;

import com.project.fanla.model.Lyrics;
import com.project.fanla.model.Song;
import com.project.fanla.service.LyricsService;
import com.project.fanla.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lyrics")
public class LyricsController {

    private final LyricsService lyricsService;
    private final SongService songService;

    @Autowired
    public LyricsController(LyricsService lyricsService, SongService songService) {
        this.lyricsService = lyricsService;
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<List<Lyrics>> getAllLyrics() {
        List<Lyrics> lyrics = lyricsService.getAllLyrics();
        return new ResponseEntity<>(lyrics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lyrics> getLyricsById(@PathVariable Long id) {
        Optional<Lyrics> lyrics = lyricsService.getLyricsById(id);
        return lyrics.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Lyrics> createLyrics(@RequestBody Lyrics lyrics) {
        // Get the full song data from the database
        if (lyrics.getSong() != null && lyrics.getSong().getId() != null) {
            Optional<com.project.fanla.model.Song> songOpt = songService.getSongById(lyrics.getSong().getId());
            if (songOpt.isPresent()) {
                lyrics.setSong(songOpt.get());
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        
        Lyrics savedLyrics = lyricsService.saveLyrics(lyrics);
        return new ResponseEntity<>(savedLyrics, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lyrics> updateLyrics(@PathVariable Long id, @RequestBody Lyrics lyrics) {
        Optional<Lyrics> existingLyrics = lyricsService.getLyricsById(id);
        if (existingLyrics.isPresent()) {
            lyrics.setId(id);
            Lyrics updatedLyrics = lyricsService.saveLyrics(lyrics);
            return new ResponseEntity<>(updatedLyrics, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLyrics(@PathVariable Long id) {
        Optional<Lyrics> existingLyrics = lyricsService.getLyricsById(id);
        if (existingLyrics.isPresent()) {
            lyricsService.deleteLyrics(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
