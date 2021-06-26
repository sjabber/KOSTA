package dao;

import dto.Customer;
import exception.AddException;
import exception.FindException;
import exception.ModifyException;

public interface CustomerDAO {
    /**
     * 고객은 가입한다.
     * @throws AddException 계정을 추가하는 과정에서 실패한 경우 에러가 발생한다.
    */
    public void insert(Customer c) throws AddException;


    /**
     * 고객은 로그인한다. 자기 정보를 조회한다.
     * @return Customer
     * @throws AddException 계정을 추가하는 과정에서 실패한 경우 에러가 발생한다.
     */
    public Customer selectById(String id) throws FindException;

    /**
     * 고객은 정보를 수정한다. 탈퇴한다.
     * @throws AddException 계정을 추가하는 과정에서 실패한 경우 에러가 발생한다.
     */
    public void update(Customer c) throws ModifyException;
}
