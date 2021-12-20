package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class JudgeUtilsTest {
	
	private JudgeUtils target = new JudgeUtils();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// ********************************
	// isBillingAge()
	// ********************************
	
	// ケースNo1
	// ケース内容：現在の月が4～12月で比較年月日より前(2017/04/01)
	// 引数：2000/03/31
	// 合格条件：true
	@Test
	public void testisBillingAge_現在の月が4_12月で比較年月日より前_プレイ可能() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.MARCH);
		birthcal.set(Calendar.DAY_OF_MONTH, 31);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isBillingAge(birthDay);

		//結果
		assertTrue(actual);
		mockTime.tearDown();
	}
	
	// ケースNo2
	// ケース内容：現在の月が4～12月で比較年月日とイコール(2017/04/01)
	// 引数：2000/04/01
	// 合格条件：true
	@Test
	public void testisBillingAge_現在の月が4_12月で比較年月日より前_イコール() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.MARCH);
		birthcal.set(Calendar.DAY_OF_MONTH, 31);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isBillingAge(birthDay);

		//結果
		assertTrue(actual);
		mockTime.tearDown();
	}

	// ケースNo3
	// ケース内容：現在の月が4～12月で比較年月日よりあと(2017/04/01)
	// 引数：2000/04/02
	// 合格条件：false
	@Test
	public void testisBillingAge_現在の月が4_12月で比較年月日よりあと_プレイ不可() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.APRIL);
		birthcal.set(Calendar.DAY_OF_MONTH, 2);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isBillingAge(birthDay);

		//結果
		assertFalse(actual);
		mockTime.tearDown(); 
	}
	
	// ケースNo4
	// ケース内容：現在の月が1～3月で比較年月日よりまえ(2018/03/31)
	// 引数：2000/03/31
	// 合格条件：true
	@Test
	public void testisBillingAge_現在の月が1_3月で比較年月日よりまえ_プレイ可能() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.MARCH);
		birthcal.set(Calendar.DAY_OF_MONTH, 31);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isBillingAge(birthDay);

		//結果
		assertTrue(actual);
		mockTime.tearDown();
	}
	
	// ケースNo5
	// ケース内容：現在の月が1～3月で比較年月日とイコール(2018/03/31)
	// 引数：2000/04/01
	// 合格条件：true
	@Test
	public void testisBillingAge_現在の月が1_3月で比較年月日とイコール_プレイ可能() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.APRIL);
		birthcal.set(Calendar.DAY_OF_MONTH, 1);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isBillingAge(birthDay);

		//結果
		assertTrue(actual);
		mockTime.tearDown();
	}

	// ケースNo6
	// ケース内容：現在の月が1～3月で比較年月日とよりあと(2017/03/31)
	// 引数：2000/03/31
	// 合格条件：false
	@Test
	public void testisBillingAge_現在の月が1_3月で比較年月日とよりあと_プレイ不可() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.MARCH);
		birthcal.set(Calendar.DAY_OF_MONTH, 31);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isBillingAge(birthDay);

		//結果
		assertFalse(actual);
		mockTime.tearDown();
	}
	
	// ********************************
	// isRegisterdAge()
	// ********************************
	
	// ケースNo1
	// ケース内容：現在の月が4～12月で比較年月日より前(2017/04/01)
	// 引数：2000/03/31
	// 合格条件：true
	@Test
	public void testIsRegisterdAge_現在の月が4_12月で比較年月日より前_プレイ可能() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.MARCH);
		birthcal.set(Calendar.DAY_OF_MONTH, 31);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isRegisterdAge(birthDay);

		//結果
		assertTrue(actual);
		mockTime.tearDown();
	}
	
	// ケースNo2
	// ケース内容：現在の月が4～12月で比較年月日とイコール(2017/04/01)
	// 引数：2000/04/01
	// 合格条件：true
	@Test
	public void testIsRegisterdAge_現在の月が4_12月で比較年月日とイコール_プレイ可能() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.APRIL);
		birthcal.set(Calendar.DAY_OF_MONTH, 1);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isRegisterdAge(birthDay);

		//結果
		assertTrue(actual);
		mockTime.tearDown();
	}

	// ケースNo3
	// ケース内容：現在の月が4～12月で比較年月日よりあと(2017/04/01)
	// 引数：2000/04/02
	// 合格条件：false
	@Test
	public void testIsRegisterdAge_現在の月が4_12月で比較年月日よりあと_プレイ不可() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.APRIL);
		birthcal.set(Calendar.DAY_OF_MONTH, 2);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isRegisterdAge(birthDay);

		//結果
		assertFalse(actual);
		mockTime.tearDown(); 
	}
	
	// ケースNo4
	// ケース内容：現在の月が1～3月で比較年月日よりまえ(2018/03/31)
	// 引数：2000/03/31
	// 合格条件：true
	@Test
	public void testIsRegisterdAge_現在の月が1_3月で比較年月日よりまえ_プレイ可能() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.MARCH);
		birthcal.set(Calendar.DAY_OF_MONTH, 31);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isRegisterdAge(birthDay);

		//結果
		assertTrue(actual);
		mockTime.tearDown();
	}
	
	// ケースNo5
	// ケース内容：現在の月が1～3月で比較年月日とイコール(2018/03/31)
	// 引数：2000/04/01
	// 合格条件：true
	@Test
	public void testIsRegisterdAge_現在の月が1_3月で比較年月日とイコール_プレイ可能() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.APRIL);
		birthcal.set(Calendar.DAY_OF_MONTH, 1);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isRegisterdAge(birthDay);

		//結果
		assertTrue(actual);
		mockTime.tearDown();
	}

	// ケースNo6
	// ケース内容：現在の月が1～3月で比較年月日とよりあと(2017/03/31)
	// 引数：2000/03/31
	// 合格条件：false
	@Test
	public void testIsRegisterdAge_現在の月が1_3月で比較年月日とよりあと() {

		// 事前処理(Mock)
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		MockCurrentTime mockTime = new MockCurrentTime(date);

		// 引数
		Calendar birthcal = Calendar.getInstance();
		birthcal.set(Calendar.YEAR, 2000);
		birthcal.set(Calendar.MONTH, Calendar.MARCH);
		birthcal.set(Calendar.DAY_OF_MONTH, 31);
		birthcal.set(Calendar.HOUR, 0);
		birthcal.set(Calendar.MINUTE, 0);
		birthcal.set(Calendar.SECOND, 0);
		Date birthDay = birthcal.getTime();

		// 実行
		boolean actual = target.isRegisterdAge(birthDay);

		//結果
		assertFalse(actual);
		mockTime.tearDown();
	}
}
