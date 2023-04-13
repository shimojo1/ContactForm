package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FormDao;
import com.example.demo.entity.Form;

@Service
public class FormService {
	@Autowired
	private FormDao dao;

	public void save(Form form) {
		dao.save(form);
	}
}
