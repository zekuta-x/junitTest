package com.example.demo;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import mockit.Mock;
import mockit.MockUp;

class UserInfoServiceTest {
	
	private UserInfoService target = new UserInfoService();


	// ********************************
	// createUserInfo()
	// ********************************
	// ケースNo1
	// ケース内容：プレイ対象でかつ課金対象
	// 引数：日時=現在日時, 年齢=18歳
	// Mock：isRegisterdAge()をtrueで返却
	// 合格条件：ユーザー情報Mapに{playF=1,billingF=1}が格納されていること
	@Test
	public void testCreateUserInfo_プレイ対象_課金対象() throws Exception {
		// 引数
		Date date = new Date();
		int age = 18;

		// 実行
		MockUp<JudgeUtils> mock = new MockUp<JudgeUtils>() {
			@Mock
			public boolean isRegisterdAge(Date birthDay) {
				return true;
			}
		};
		
		Map<String, String> actual = target.createUserInfo(date, age);
		
		// 結果
		assertThat(actual.size(), is(2));
		assertThat(actual.get("playF"), is("1"));
		assertThat(actual.get("billingF"), is("1"));
		
		mock.tearDown();
	}
	
	// ケースNo2 
	// ケース内容：プレイ対象でかつ課金対象でない
	// 引数：日時=現在日時, 年齢=17歳
	// Mock：isRegisterdAge()をtrueで返却
	// 合格条件：ユーザー情報Mapに{playF=1,billingF=0}が格納されていること
	@Test
	public void testCreateUserInfo_プレイ対象_課金対象でない() throws Exception {
		// 引数
		Date date = new Date();
		int age = 17;

		// 実行
		MockUp<JudgeUtils> mock = new MockUp<JudgeUtils>() {
			@Mock
			public boolean isRegisterdAge(Date birthDay) {
				return true;
			}
		};
		
		Map<String, String> actual = target.createUserInfo(date, age);
		
		// 結果
		assertThat(actual.size(), is(2));
		assertThat(actual.get("playF"), is("1"));
		assertThat(actual.get("billingF"), is("0"));
		
		mock.tearDown();
	}

	// ケースNo3
	// ケース内容：プレイ対象でないかつ課金対象
	// 引数：日時=現在日時, 年齢=18歳
	// Mock：isRegisterdAge()をfalseで返却
	// 合格条件：ユーザー情報Mapに{playF=0,billingF=0}が格納されていること
	@Test
	public void testCreateUserInfo_プレイ対象でない_課金対象() throws Exception {
		// 引数
		Date date = new Date();
		int age = 18;

		// 実行
		MockUp<JudgeUtils> mock = new MockUp<JudgeUtils>() {
			@Mock
			public boolean isRegisterdAge(Date birthDay) {
				return false;
			}
		};
		
		Map<String, String> actual = target.createUserInfo(date, age);
		
		// 結果
		assertThat(actual.size(), is(2));
		assertThat(actual.get("playF"), is("0"));
		assertThat(actual.get("billingF"), is("0"));
		
		mock.tearDown();
	}
	
	// ケースNo4
	// ケース内容：プレイ対象でないかつ課金対象でない
	// 引数：日時=現在日時, 年齢=17歳
	// Mock：isRegisterdAge()をfalseで返却
	// 合格条件：ユーザー情報Mapに{playF=0,billingF=0}が格納されていること
	@Test
	public void testCreateUserInfo_プレイ対象でない_課金対象でない() throws Exception {
		// 引数
		Date date = new Date();
		int age = 17;

		// 実行
		MockUp<JudgeUtils> mock = new MockUp<JudgeUtils>() {
			@Mock
			public boolean isRegisterdAge(Date birthDay) {
				return false;
			}
		};
		
		Map<String, String> actual = target.createUserInfo(date, age);
		
		// 結果
		assertThat(actual.size(), is(2));
		assertThat(actual.get("playF"), is("0"));
		assertThat(actual.get("billingF"), is("0"));
		
		mock.tearDown();
	}

	
	// ********************************
	// registUserInfo()
	// ********************************
	// ケースNo1
	// ケース内容：ユーザー情報不足
	// 引数：空Map
	// 合格条件：「ユーザ情報登録なし：ユーザー情報不足のため」が返却されること
	@Test
	public void testRegistUserInfo_ユーザ情報不足() throws Exception {
		// 引数
		Map<Object, Object> userInfo = new HashMap<>();
		
		// 実行
		String actual = target.registUserInfo(userInfo);
		
		// 結果
		assertThat(actual, is("ユーザ情報登録なし：ユーザー情報不足のため"));
	}
	
	// ケースNo2
	// ケース内容：プレイ対象、かつ、課金対象
	// 引数：{playF=1,billingF=1}のMap
	// 合格条件：「ユーザ情報登録：プレイ可能,課金可能」が返却されること
	@Test
	public void testRegistUserInfo_プレイ対象_課金対象() throws Exception {
		// 引数
		Map<Object, Object> userInfo = new HashMap<Object, Object>() {
			{ put("playF", "1"); };
			{ put("billingF","1"); };
		};	
		// 実行
		String actual = target.registUserInfo(userInfo);
		
		// 結果
		assertThat(actual, is("ユーザ情報登録：プレイ可能,課金可能"));
	}


	// ケースNo3
	// ケース内容：プレイ対象、かつ、課金対象でない
	// 引数：{playF=1,billingF=0}のMap
	// 合格条件：「ユーザ情報登録：プレイ可能,課金不可」が返却されること
	@Test
	public void testRegistUserInfo_プレイ対象_課金対象でない() throws Exception {
		// 引数
		Map<Object, Object> userInfo = new HashMap<Object, Object>() {
			{ put("playF", "1"); };
			{ put("billingF","0"); };
		};	
		// 実行
		String actual = target.registUserInfo(userInfo);
		
		// 結果
		assertThat(actual, is("ユーザ情報登録：プレイ可能,課金不可"));
	}

	// ケースNo4
	// ケース内容：プレイ対象でない、かつ、課金対象
	// 引数：{playF=0,billingF=1}のMap
	// 合格条件：「ユーザ情報登録なし：プレイ不可のため」が返却されること
	@Test
	public void testRegistUserInfo_プレイ対象でない_課金対象() throws Exception {
		// 引数
		Map<Object, Object> userInfo = new HashMap<Object, Object>() {
			{ put("playF", "0"); };
			{ put("billingF","1"); };
		};	
		// 実行
		String actual = target.registUserInfo(userInfo);
		
		// 結果
		assertThat(actual, is("ユーザ情報登録なし：プレイ不可のため"));
	}
	
	// ケースNo5
	// ケース内容：プレイ対象でない、かつ、課金対象でない
	// 引数：{playF=0,billingF=0}のMap
	// 合格条件：「ユーザ情報登録なし：プレイ不可のため」が返却されること
	@Test
	public void testRegistUserInfo_プレイ対象でない_課金対象でない() throws Exception {
		// 引数
		Map<Object, Object> userInfo = new HashMap<Object, Object>() {
			{ put("playF", "0"); };
			{ put("billingF","0"); };
		};	
		// 実行
		String actual = target.registUserInfo(userInfo);
		
		// 結果
		assertThat(actual, is("ユーザ情報登録なし：プレイ不可のため"));
	}
	
	// ケースNo6
	// ケース内容：想定外のユーザー情報
	// 引数：{playF=2,billingF=1}のMap
	// 合格条件：「ユーザ情報登録なし：想定」が返却されること
	@Test
	public void testRegistUserInfo_playFに想定外の値が詰まっている() throws Exception {
		// 引数
		Map<Object, Object> userInfo = new HashMap<Object, Object>() {
			{ put("playF", "2"); };
			{ put("billingF","1"); };
		};	
		// 実行
		String actual = target.registUserInfo(userInfo);
		
		// 結果
		assertThat(actual, is("ユーザ情報登録なし：想定外"));
	}

	// ケースNo7
	// ケース内容：想定外のユーザー情報
	// 引数：{playF=1,billingF=2}のMap
	// 合格条件：「ユーザ情報登録なし：想定」が返却されること
	@Test
	public void testRegistUserInfo_billingFに想定外の値が詰まっている() throws Exception {
		// 引数
		Map<Object, Object> userInfo = new HashMap<Object, Object>() {
			{ put("playF", "1"); };
			{ put("billingF","2"); };
		};	
		// 実行
		String actual = target.registUserInfo(userInfo);
		
		// 結果
		assertThat(actual, is("ユーザ情報登録なし：想定外"));
	}
}
