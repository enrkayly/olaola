package com.project.fanla.controller;

import com.project.fanla.model.Song;
import com.project.fanla.model.dto.SongPlaybackMessage;
import com.project.fanla.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class SongPlaybackController {

    private final SongService songService;

    @Autowired
    public SongPlaybackController(SongService songService) {
        this.songService = songService;
    }

    /**
     * Handles playback updates from the admin and broadcasts to all connected fans
     */
    @MessageMapping("/playback/update")
    @SendTo("/topic/playback")
    public SongPlaybackMessage updatePlayback(SongPlaybackMessage message) {
        // Simply relay the message to all subscribers
        return message;
    }

    /**
     * Handles playback start from the admin and broadcasts to all connected fans
     */
    @MessageMapping("/playback/start")
    @SendTo("/topic/playback")
    public SongPlaybackMessage startPlayback(SongPlaybackMessage message) {
        Optional<Song> song = songService.getSongById(message.getSongId());
        if (song.isPresent()) {
            Song foundSong = song.get();
            message.setUrl(foundSong.getUrl());
            message.setSongTitle(foundSong.getTitle());
            message.setArtist(foundSong.getArtist());
            message.setPlaying(true);
            message.setCurrentSecond(0);
            
            // Include lyrics data if available
            if (foundSong.getLyrics() != null && foundSong.getLyrics().getTimings() != null) {
                message.setLyricsTimings(foundSong.getLyrics().getTimings());
            }
        }
        return message;
    }

    /**
     * Handles playback stop from the admin and broadcasts to all connected fans
     */
    @MessageMapping("/playback/stop")
    @SendTo("/topic/playback")
    public SongPlaybackMessage stopPlayback(SongPlaybackMessage message) {
        message.setPlaying(false);
        return message;
    }
}
