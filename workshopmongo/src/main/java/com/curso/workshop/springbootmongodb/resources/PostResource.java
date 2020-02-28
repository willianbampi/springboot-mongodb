package com.curso.workshop.springbootmongodb.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.workshop.springbootmongodb.domain.Post;
import com.curso.workshop.springbootmongodb.resources.util.URL;
import com.curso.workshop.springbootmongodb.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	//@GetMapping or @RequestMapping(method = RequestMethod.GET)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	//@GetMapping or @RequestMapping(method = RequestMethod.GET)
	@RequestMapping(value = "/findbytitle", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="title", defaultValue = "") String title){
		title = URL.decodeParam(title);
		List<Post> list = service.findByTitle(title);
		return ResponseEntity.ok().body(list);
	}
	
	//@GetMapping or @RequestMapping(method = RequestMethod.GET)
	@RequestMapping(value = "/searchbytitle", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> searchByTitle(@RequestParam(value="title", defaultValue = "") String title){
		title = URL.decodeParam(title);
		List<Post> list = service.searchByTitle(title);
		return ResponseEntity.ok().body(list);
	}
	
	//@GetMapping or @RequestMapping(method = RequestMethod.GET)
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(@RequestParam(value="text", defaultValue = "") String text, @RequestParam(value="minDate", defaultValue = "") String minDate, @RequestParam(value="maxDate", defaultValue = "") String maxDate){
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}

}
