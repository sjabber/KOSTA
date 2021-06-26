package service;

import dao.CustomerDAO;
import dao.ProductDAO;
import dto.Customer;
import exception.AddException;
import exception.FindException;
import exception.ModifyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CustomerService {
    private CustomerDAO dao;
    private static CustomerService service = new CustomerService();

    private CustomerService() {
        //dao = new ProductDAOFile();
        //dao = new ProductDAOOracle();
        //dao = new ProductDAOMySQL();
        Properties env = new Properties();
        try {
            env.load(new FileInputStream("classes.prop"));
            String className = env.getProperty("customerDAO");
            Class c = Class.forName(className); // JVM에 로드
            dao = (CustomerDAO) c.newInstance(); // 자동으로 객체생성
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signup(Customer c) throws AddException {
        dao.insert(c);
    }

    public void login(String id, String pwd) throws FindException {
        Customer c = dao.selectById(id);
        if (!c.getPwd().equals(pwd)) {
            throw new FindException("로그인 실패");
        }
    }

    public Customer detail(String id) throws FindException {
        return dao.selectById(id);
    }

    public void modify(Customer c) throws ModifyException {
        if (c.getEnabled() == 0) {
            throw new ModifyException("탈퇴작업을 할 수 없습니다.");
        } dao.update(c);
    }

    public void leave(Customer c) throws ModifyException {
        c.setEnabled(0);
        dao.update(c);
    }
}
