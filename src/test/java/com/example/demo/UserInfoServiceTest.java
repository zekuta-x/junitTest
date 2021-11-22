package com.example.demo;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserInfoServiceTest {
	
	@InjectMocks
	private UserInfoService target = new UserInfoService();

	@Mock
	private JudgeUtils judgeUtils;
	
	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
		
		// Mock
		when(judgeUtils.isRegisterdAge(new Date())).thenReturn(true);
	}
	
	// ********************************
	// createUserInfo()
	// ********************************
	// ケースNo1 プレイ対象、かつ、課金対象
	@Test
	public void testCreateUserInfo_プレイ対象_課金対象() throws Exception {
		// 引数
		Date date = new Date();
		int age = 18;

		// 実行
		Map<String, String> actual = target.createUserInfo(date, age);
		
		MockUp<>
		// 結果
		assertThat(actual.size(), is(2));
		assertThat(actual.get("playF"), is("1"));
		assertThat(actual.get("billingF"), is("1"));
	}
	// ケースNo2 プレイ対象、かつ、課金対象でない

	// ケースNo3 プレイ対象でない、かつ、課金対象
	
	// ケースNo4 プレイ対象でない、かつ、課金対象でない
	
	// ケースNo5 例外発生
	
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
