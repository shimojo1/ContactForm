package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Form;

public interface FormRepository extends JpaRepository<Form, Integer> {
}