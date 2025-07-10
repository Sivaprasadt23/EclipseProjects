package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Playlist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@ManyToMany
	List<Song> playlst;
	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Playlist(int id, String name, List<Song> playlst) {
		super();
		this.id = id;
		this.name = name;
		this.playlst = playlst;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Song> getPlaylst() {
		return playlst;
	}
	public void setPlaylst(List<Song> playlst) {
		this.playlst = playlst;
	}
	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", playlst=" + playlst + "]";
	}
	
	
}
