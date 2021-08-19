package com.day.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.day.dao.ProductDAO;
import com.day.dto.Product;
import com.day.exception.FindException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	@Qualifier("productDAO")
	private ProductDAO dao;
	public ProductService() {
		
	}
	public void init() {
		System.out.println("ProductService 객체가 준비됨. ");
	}
	//@Autowired(required = false) // 주입하고싶으면 주입, 주입하기 싫으면 안하는 이런 코드보다는 required = true인 디폴트가 더 좋은 코드다.
	@Autowired
	public ProductService(ProductDAO dao) {
		this.dao = dao;
		System.out.println("ProductService()의 생성자 호출됨.");
	}
	public void setDao(ProductDAO dao) {
		this.dao = dao;
		System.out.println("setDao() 호출됨.");
	}
	public ProductDAO getDao() {
		return dao;
	}
	
	public List<Product> findAll() throws FindException{
		return dao.selectAll();
		//List<Product> list = dao.selectAll();
		//list를 암호화
		//암호화된 리스트반환
	}
	public List<Product> findAll(int currentPage) throws FindException{
		return dao.selectAll(currentPage);
	}
	public Product findByNo(String prod_no) throws FindException{
		//상품번호를 복호화
		//dao.selectByNo(복호화된 값);
		return dao.selectByNo(prod_no);
	}
	public List<Product> findByName(String word) throws FindException{
		return dao.selectByName(word);
	}
}
