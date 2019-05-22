package com.exception.controller;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class TestOverrideController extends ExceptionController{

	@Override
//	public void test1() throws IOException{ //OK
	public void test1() throws EOFException, FileAlreadyExistsException{ //OK
		//개수 상관 없이 throws 가능. 단, 범위 벗어 나지 않는 exception 클래스로
	}

//	public void test1() throws Exception{ //불가능
}
