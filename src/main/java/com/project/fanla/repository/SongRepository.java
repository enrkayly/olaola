package com.project.fanla.repository;

import com.project.fanla.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    // Custom query methods can be added here if needed
}
