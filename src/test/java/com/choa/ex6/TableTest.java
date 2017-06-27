package com.choa.ex6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.table.TableADTO;
import com.choa.table.TableService;

public class TableTest extends MyAbstractTestUnit{

	@Autowired
	private TableService tableService;
	
	
	@Test
	public void test() throws Exception{
		TableADTO tableADTO = new TableADTO();
		tableADTO.setNum(3);
		tableADTO.setTitle("t3");
		tableADTO.setWriter("t3");
		System.out.println(tableADTO.getNum());
		int result = tableService.insertTable(tableADTO, tableADTO.getNum());
		assertNotEquals(0, result);
	}

}
