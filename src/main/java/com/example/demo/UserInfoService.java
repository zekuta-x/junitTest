package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserInfoService extends MiraiPrjApplication{
	
	private JudgeUtils judgeUtils = new JudgeUtils();

	/**
	 * ユーザー情報作成メソッド<br>
	 * @param birthDay
	 *            生年月日
	 * @param age
	 *            年齢
	 * @return userInfo:ユーザー情報
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, String> createUserInfo(Date birthDay, int age) throws Exception {
		Map userInfo = new HashMap<>();
		// プレイ可能判断
		if(judgeUtils.isRegisterdAge(birthDay)) {
			try {
				userInfo.put("playF", "1");
				// 課金可能判断
				if(judgeUtils.isBillingAge(age)) {
					userInfo.put("billingF", "1");
				} else {
					userInfo.put("billingF", "0");
				}
			} catch(Exception e) {
				throw new Exception("想定外のエラー");
			}
		} else {
			userInfo.put("playF", "0");
			userInfo.put("billingF", "0");
		}
		
		return userInfo;
	}
	
	/**
	 * ユーザー情報登録メソッド<br>
	 * @param birthDay
	 *            生年月日
	 * @param age
	 *            年齢
	 * @return userInfo:ユーザー情報
	 */
	@SuppressWarnings("rawtypes")
	public String registUserInfo(Map userInfo) {
		// 引数チェック
		if(userInfo.isEmpty()) {
			return "ユーザ情報登録なし：ユーザー情報不足のため";
		} else if(userInfo.get("playF") == "0") {
			return "ユーザ情報登録なし：プレイ不可のため";
		} else if(userInfo.get("playF") == "1") {
			if(userInfo.get("billingF") == "0") {
				return "ユーザ情報登録：プレイ可能,課金不可";
			} else if(userInfo.get("billingF") == "1") {
				return "ユーザ情報登録：プレイ可能,課金可能";		
			} else {
				return "ユーザ情報登録なし：想定外";
			}
		} else {
			return "ユーザ情報登録なし：想定外";
		}
	}
}
