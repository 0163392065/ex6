package com.choa.memo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex6.MyAbstractTestUnit;

public class MemoTest extends MyAbstractTestUnit{

	@Autowired
	private MemoDAO memoDAO;
	@Autowired
	private MemoService memoService;
	
	
	@Test
	public void test() throws Exception{
		MemoDTO memoDTO = memoDAO.boardView(100);
		System.out.println(memoDTO.getNum());
		assertNotNull(memoDTO);
	}

}
