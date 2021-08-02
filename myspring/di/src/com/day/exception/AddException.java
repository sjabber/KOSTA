package com.day.exception;

public class AddException extends Exception {

	public AddException(String message) {
		super(message); // 부모의 생성자 호출한다.
	}
}
