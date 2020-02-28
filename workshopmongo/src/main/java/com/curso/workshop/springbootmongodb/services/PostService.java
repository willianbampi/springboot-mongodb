package com.curso.workshop.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.workshop.springbootmongodb.domain.Post;
import com.curso.workshop.springbootmongodb.repository.PostRepository;
import com.curso.workshop.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String title){
		return repo.findByTitleContainingIgnoreCase(title);
	}
	
	public List<Post> searchByTitle(String title){
		return repo.searchByTitle(title);
	}
	
}
