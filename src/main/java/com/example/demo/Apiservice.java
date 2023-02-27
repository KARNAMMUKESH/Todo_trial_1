package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;





@Service
public class Apiservice {
	
	@Autowired
	TodoRepo repo;
	
	public Optional<TodoItem> getdetails(int id)
	{
		return repo.findById(id);
	}
	public String updated(TodoItem stu)
	{
		repo.save(stu);
		return "updated";
	}
	public String delete(int id)
	{
		repo.deleteById(id);
		return "Deleted";
	}
	public List<TodoItem> sort(String field)
	{
		return repo.findAll(Sort.by(Sort.Direction.DESC, field));
	}
	public List<TodoItem> setpages(@PathVariable int offset,@PathVariable int pages)
	{
		Page<TodoItem> page = repo.findAll(PageRequest.of(offset,pages));
		return page.getContent();
	}
	public Page<TodoItem> pagesort(@PathVariable int offset,@PathVariable int pages,String field)
	{
		Pageable paging = PageRequest.of(pages, offset,Sort.by(field));
		return repo.findAll(paging);
	}

}
