package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "form")
public class Form {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 255, nullable = false)
	@NotEmpty(message = "名前の入力は必須です")
	private String name;
	
	@Column(nullable = false)
	@NotNull(message = "年齢の入力は必須です")
	@Positive(message = "年齢は数値で入力してください")
//	@Min(value = 0, message = "年齢は数値で入力してください")
	private String age;
	
	@Column
	private String prefecture;
	
	@Column
	private String address1;
	
	@Column
	private String address2;
	
	@Column
	private String comment;
	
	@Column
	private Date updatedAt;

	@Column(updatable = false)
	private Date createdAt;

	@PrePersist
	public void onPrePersist() {
		setUpdatedAt(new Date());
		setCreatedAt(new Date());
	}

	@PreUpdate
	public void onPreUpdate() {
		setUpdatedAt(new Date());
	}
}