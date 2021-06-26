package dao;

import dto.Product;
import exception.FindException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ProductDAOFile implements ProductDAO {
	private String fileName = "products.txt";	//S0001:갤럭시노트:1000:200101
												//S0002:갤럭시탭:1500:210430
												//I001:아이폰:1000:201210
			
	@Override
	public List<Product> selectAll() throws FindException {
		/*
		 * 1. 파일 한줄씩읽기(FileInputStream을 가공한 Scanner 사용)
		 * 2. 한줄내용으 ":" 구분자로 5개 문자열로 가르기(split)
		 * 3. 상품번호, 상품명은 무관 / 상품가격은 int로 변환 / 제조일자는 Date로 변환 / 상세설명은 무관
		 * 4. 상품정보를 Product 객체로 생성
		 * 5. List에 Product 객체를 추가
		 */
		List<Product> list = new ArrayList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(fileName));
			while(true) { 
				String line = sc.nextLine(); //S0001:갤럭시노트::200101:4개카메라를 내장한 갤럭시노트는~~~~
				
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
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new FindException("파일을 찾을 수 없습니다");
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