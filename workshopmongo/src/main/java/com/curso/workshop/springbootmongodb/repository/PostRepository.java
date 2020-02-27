package com.curso.workshop.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.curso.workshop.springbootmongodb.domain.Post;
import com.curso.workshop.springbootmongodb.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
}
