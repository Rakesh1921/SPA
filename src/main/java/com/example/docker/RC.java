package com.example.docker;

import java.net.http.HttpClient;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class RC {
	
	public int a = 123;
	ArrayList<Person> plist = new ArrayList<>();
	/*public void append() {
		Person p1 = new Person();
		p1.setName("Kohli");
		p1.setAge(35);
		plist.add(p1);
		Person p2 = new Person();
		p2.setName("Dhoni");
		p2.setAge(45);
		plist.add(p2);
	}*/
	
	@GetMapping("/get1")
	public ArrayList<Person> hello1() {
		// append();
		return plist;
	}
	
	@GetMapping("/get2")
	public ResponseEntity<?> hello12(@RequestParam int index) {
		// append();
		if(index >= plist.size())
			return new ResponseEntity<>("Index is large", HttpStatus.OK);
		return new ResponseEntity<>(plist.get(index), HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public String hello2(@RequestParam int index, @RequestBody Person p) {
		plist.get(index).name = p.name;
		plist.get(index).age = p.age; 
		return "Updated";
	}
	
	@PostMapping("/post")
	public String hello3(@RequestBody Person p) {
		plist.add(p);
		return "Added";
	}
	
	@DeleteMapping("/delete")
	public String hello4(@RequestParam int index) {
		plist.remove(index);
		return "elements deleted";
	}

}
