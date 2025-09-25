package com.faik.Entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

@Entity // Veri tabanı ile ilişkili olduğunu anlatır
@Table(name =  " Customer" , schema = "\"Student\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // oto artırır
	private long id;
	
	@Column(name = "name")
	private String name;
	
	// ilişkiyi kontrol eden taraf burası
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
}
