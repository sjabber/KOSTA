package com.day.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.day.dto.Product;
import com.day.exception.FindException;

public class ProductDAOFile implements ProductDAO {
	private String fileName = "products.txt"; 
	@Override
	public List<Product> selectAll() throws FindException {
		/*
		 * 1. ??Ό ?μ€μ©?½κΈ?(FileInputStream? κ°?κ³΅ν Scanner?¬?©)
		 * 2. ?μ€λ΄?©? ":"κ΅¬λΆ?λ‘? 5κ°? λ¬Έμ?΄λ‘? ?λ₯΄κΈ°(split)
		 * 3. ??λ²νΈ, ??λͺμ? λ¬΄κ?/ ??κ°?κ²©μ? intλ‘? λ³??/ ? μ‘°μΌ?? Dateλ‘? λ³?? / ??Έ?€λͺμ? λ¬΄κ?
		 * 4. ??? λ³΄λ?? Productκ°μ²΄λ‘? ??±
		 * 5. List? Productκ°μ²΄λ₯? μΆκ? 
		 */
		List<Product> list = new ArrayList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(fileName));
			while(true) { 				
				String line = sc.nextLine(); //S0001:κ°€λ­??Έ?Έ::200101:4κ°μΉ΄λ©λΌλ₯? ?΄?₯? κ°€λ­??Έ?Έ?~~~~				
				String[] data = line.split(":", 5);
				String prod_no = data[0];				
				String prod_name = data[1];
				
				int prod_price = -1;
				try {
					prod_price = Integer.parseInt(data[2]);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}			
				Date prod_mf_dt = new Date();
				try {
					prod_mf_dt = new SimpleDateFormat("yyMMdd").parse(data[3]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String prod_detail = data[4];
				Product p = new Product(prod_no, prod_name, prod_price, prod_mf_dt, prod_detail);
				list.add(p);
			}			
		} catch (FileNotFoundException e) {			e.printStackTrace();			throw new FindException("??Ό? μ°Ύμ ? ??΅??€");
		} catch(NoSuchElementException | IllegalStateException e) {
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
		return list;
	}

	@Override
	public List<Product> selectAll(int currentPage) throws FindException {
		return null;
	}

	@Override
	public Product selectByNo(String prod_no) throws FindException {
		return null;
	}

	@Override
	public List<Product> selectByName(String word) throws FindException {
		return null;
	}
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAOFile();
		try {
			List<Product> all = dao.selectAll();
			System.out.println(all);
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
}
