package com.udemy.webservices.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.webservices.entities.User;
import com.udemy.webservices.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User object = userService.findById(id);
		return ResponseEntity.ok().body(object);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User object) {	
		object = userService.insert(object);
		URI uri = ServletUriComponentsBuilder
				 .fromCurrentRequest().path("/{id}")
				 .buildAndExpand(object.getId())
				 .toUri();
		return ResponseEntity.created(uri).body(object);
	}
	
	@DeleteMapping(value = "/{id}")
	public  ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
