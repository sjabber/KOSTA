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
		 * 1. ?ŒŒ?¼ ?•œì¤„ì”©?½ê¸?(FileInputStream?„ ê°?ê³µí•œ Scanner?‚¬?š©)
		 * 2. ?•œì¤„ë‚´?š©?„ ":"êµ¬ë¶„?ë¡? 5ê°? ë¬¸ì?—´ë¡? ?ë¥´ê¸°(split)
		 * 3. ?ƒ?’ˆë²ˆí˜¸, ?ƒ?’ˆëª…ì? ë¬´ê?/ ?ƒ?’ˆê°?ê²©ì? intë¡? ë³??™˜/ ? œì¡°ì¼??Š” Dateë¡? ë³??™˜ / ?ƒ?„¸?„¤ëª…ì? ë¬´ê?
		 * 4. ?ƒ?’ˆ? •ë³´ë?? Productê°ì²´ë¡? ?ƒ?„±
		 * 5. List?— Productê°ì²´ë¥? ì¶”ê? 
		 */
		List<Product> list = new ArrayList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(fileName));
			while(true) { 				
				String line = sc.nextLine(); //S0001:ê°¤ëŸ­?‹œ?…¸?Š¸::200101:4ê°œì¹´ë©”ë¼ë¥? ?‚´?¥?•œ ê°¤ëŸ­?‹œ?…¸?Š¸?Š”~~~~				
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
		} catch (FileNotFoundException e) {			e.printStackTrace();			throw new FindException("?ŒŒ?¼?„ ì°¾ì„ ?ˆ˜ ?—†?Šµ?‹ˆ?‹¤");
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
