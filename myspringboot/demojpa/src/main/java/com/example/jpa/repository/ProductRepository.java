package com.example.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.jpa.entity.Product;

//DAO의 역할을 수행한다.
public interface ProductRepository extends CrudRepository<Product, String> {

}
