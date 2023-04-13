package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Form;
import com.example.demo.repository.FormRepository;

@Repository
public class FormDao {
	@Autowired
	FormRepository repository;
	
	public void save(Form form) {
		this.repository.save(form);
	}
}