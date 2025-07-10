

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongsService;

@Controller
public class SongsController {
	@Autowired
	SongsService ss;
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Song sng)
	{
		String name=sng.getName();
		boolean status=ss.songExists(name);
		if(status==false)
		{
			ss.addSongs(sng);
			return "songsuccess";
		}
		else
		{
		 return "songfail"; 
		}
		
	}
	@GetMapping("/map-viewsong")
	public String viewSongs(Model model)
	{
		List<Song> songlist=ss.fetchAllSongs();
		model.addAttribute("songlist", songlist);
		System.out.println(songlist);
		return "displaysongs";
	}
	@GetMapping("/map-viewsongs")
	public String viewCustomerSongs(Model model)
	{
		boolean primeCustomerStatus=true;
		if(primeCustomerStatus==true)
		{
			List<Song> songlist=ss.fetchAllSongs();
			model.addAttribute("songlist", songlist);
			System.out.println(songlist);
			return "displaysongs";
		}
		else
		{
			return "makepayment";
		}
	}
	 

}
