package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Song;
import java.util.List;

public interface SongRepository  extends JpaRepository<Song, Integer>{
  public Song findByName(String name);
}
