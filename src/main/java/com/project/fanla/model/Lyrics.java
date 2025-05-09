package com.project.fanla.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lyrics")

public class Lyrics {

    public Lyrics() {
    }

    public Lyrics(Long id, String content, Song song, String timings) {
        this.id = id;
        this.content = content;
        this.song = song;
        this.timings = timings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "TEXT")
    private String content; // Full lyrics content
    
    @OneToOne
    @JoinColumn(name = "song_id")
    @JsonBackReference
    private Song song;
    
    // Timestamps for synchronization with specific parts of the song
    @Column(columnDefinition = "TEXT")
    private String timings; // JSON format: [{"time": 0, "text": "lyrics line"}, ...]
}
