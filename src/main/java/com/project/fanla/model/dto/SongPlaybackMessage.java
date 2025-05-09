package com.project.fanla.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SongPlaybackMessage {
    private Long songId;
    private String songTitle;
    private String artist;
    private String url;
    private Integer currentSecond;
    private String currentLyrics;
    @JsonProperty("isPlaying")
    private boolean isPlaying;
    private String lyricsTimings; // JSON string with timing information

    public SongPlaybackMessage() {
    }

    public SongPlaybackMessage(Long songId, String songTitle, String artist, String url, Integer currentSecond, String currentLyrics, boolean isPlaying) {
        this.songId = songId;
        this.songTitle = songTitle;
        this.artist = artist;
        this.url = url;
        this.currentSecond = currentSecond;
        this.currentLyrics = currentLyrics;
        this.isPlaying = isPlaying;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCurrentSecond() {
        return currentSecond;
    }

    public void setCurrentSecond(Integer currentSecond) {
        this.currentSecond = currentSecond;
    }

    public String getCurrentLyrics() {
        return currentLyrics;
    }

    public void setCurrentLyrics(String currentLyrics) {
        this.currentLyrics = currentLyrics;
    }

    @JsonProperty("isPlaying")
    public boolean isPlaying() {
        return isPlaying;
    }

    @JsonProperty("isPlaying")
    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
    
    public String getLyricsTimings() {
        return lyricsTimings;
    }

    public void setLyricsTimings(String lyricsTimings) {
        this.lyricsTimings = lyricsTimings;
    }
}
