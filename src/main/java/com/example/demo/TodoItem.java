package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TodoItem {

    public TodoItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    private Long id;
    private String category;
    private String name;
    private String date;
    public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	private boolean complete;

    public TodoItem(String category, String name,String date) {
        this.category = category;
        this.name = name;
        this.date=date;
        this.complete = false;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        return;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        return;
    }

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        return;
    }

    public boolean isComplete() {
        return complete;
    }
    
    public void setComplete(boolean complete) {
        this.complete = complete;
        return;
    }
}