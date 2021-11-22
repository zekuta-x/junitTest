package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Test;

class JudgeUtilsTest {
	
	private JudgeUtils target;

	// ********************************
	// isRegisterdAge()
	// ********************************
	
	
	
	
	// ********************************
	// isBillingAge()
	// ********************************
	// ケースNo1
	// ケース内容：18歳で課金可能
	// 引数：18
	// 合格条件：true
	@Test
	public void testIsBillingAge_18歳で課金可能() throws Exception {
		// 引数
		int age = 18;

		// 実行
		boolean actual = target.isBillingAge(age);
		
		// 結果
		assertTrue(actual);
	}
	
	// ケースNo2
	// ケース内容：19歳で課金可能
	// 引数：19
	// 合格条件：true
	@Test
	public void testIsBillingAge_19歳で課金可能() throws Exception {
		// 引数
		int age = 19;

		// 実行
		boolean actual = target.isBillingAge(age);
		
		// 結果
		assertTrue(actual);
	}
	
	// ケースNo3
	// ケース内容：17歳で課金不可能
	// 引数：17
	// 合格条件：false
	@Test
	public void testIsBillingAge_17歳で課金不可能() throws Exception {
		// 引数
		int age = 17;

		// 実行
		boolean actual = target.isBillingAge(age);
		
		// 結果
		assertFalse(actual);
	}


}
