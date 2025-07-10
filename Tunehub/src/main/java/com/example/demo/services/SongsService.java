package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Song;

public interface SongsService {
	public String addSongs(Song sng);
	public boolean songExists(String name);
	public List<Song> fetchAllSongs();
	public void updateSongs(Song song);
}
