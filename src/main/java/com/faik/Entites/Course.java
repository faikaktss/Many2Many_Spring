package com.faik.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "course")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id
	private Long id;
	
	private String name;
	
}
