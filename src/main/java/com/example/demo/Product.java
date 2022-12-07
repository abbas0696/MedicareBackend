package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String productname;
	private int quantity;
	private int price;
	
	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private Set<Product> products;
	

}
