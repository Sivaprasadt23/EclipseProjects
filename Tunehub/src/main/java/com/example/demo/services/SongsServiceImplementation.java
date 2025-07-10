package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public  class SongsServiceImplementation implements SongsService{
	@Autowired
	SongRepository srepo;
	@Override
	public String addSongs(Song sng) {
		srepo.save(sng);
		return "Song is added";
	}
	@Override
	public boolean songExists(String name) {
		Song song=srepo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songlist=srepo.findAll();
		return songlist;
	}
	@Override
	public void updateSongs(Song song) {
		srepo.save(song);
	}
	

	

}
