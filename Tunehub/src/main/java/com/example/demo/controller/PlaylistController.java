package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongsService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService ps;
	@Autowired
	SongsService sser;
	
	@GetMapping("/map-createplaylist")
	public String createPlaylist(Model model)
	{
		//Fetching the songs using song service
		List<Song> songlist=sser.fetchAllSongs();
		//Adding the songs in the model
		model.addAttribute("songlist", songlist);
		//sending createplaylist
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute Playlist playlist)
	{
		ps.addPlayList(playlist);
		   List<Song> songsList=playlist.getPlaylst();
		   for (Song song : songsList) {
			song.getPlaylst().add(playlist);
			sser.updateSongs(song);
		}
		return "playlistsuccess";
	}
	@GetMapping("/viewPlayList")
	public String viewPlayList(Model model)
	{
		List<Playlist> viewList=ps.fetchPlayList();
		model.addAttribute("viewList", viewList);
		///System.out.println(viewList);
		return "viewPlayList";
	}

}
