package com.project.fanla.repository;

import com.project.fanla.model.Lyrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LyricsRepository extends JpaRepository<Lyrics, Long> {
    // Custom query methods can be added here if needed
}
