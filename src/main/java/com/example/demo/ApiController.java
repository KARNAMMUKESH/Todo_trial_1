package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class ApiController {
	
	@Autowired
	TodoRepo repo;
	@Autowired
	Apiservice s2;
	@GetMapping("/get")
	List<TodoItem> getlist()
	{
		return repo.findAll();
	}
	@PostMapping("/post")
	public TodoItem create(@RequestBody TodoItem d)
	{
		return repo.save(d);
	}
	@GetMapping("/get/{id}")
	public Optional<TodoItem> getbyid(@PathVariable int id){
		return s2.getdetails(id);
	}
	@PutMapping("/update")
	public String puti(@RequestBody TodoItem stu)
	{
		return s2.updated(stu);
	}
	@DeleteMapping("/Delete/{id}")
	public String del(@PathVariable int id)
	{
		return s2.delete(id);
	}
	@GetMapping("/sort/{field}")
	public List<TodoItem> asc(@PathVariable String field)
	{
		return s2.sort(field);
	}
	@GetMapping("/details/{offset}/{pages}")
	public List<TodoItem> pagination(@PathVariable int offset,@PathVariable int pages)
	{
		return s2.setpages(offset, pages);
	}
	@GetMapping("/geti/{offset}/{pages}/{field}")
	public List<TodoItem> paginationsorting(@PathVariable int offset,@PathVariable int pages,@PathVariable String field)
	{
		Page<TodoItem> pi=s2.pagesort(offset, pages,field);
		return pi.getContent();
	}
}
