package com.example.demo;

import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiraiPrjApplication {
	
	public static final int APRIL = 4;
	public static final int WORKABLE_AGE = 16;

	public static void main(String[] args) {
		SpringApplication.run(MiraiPrjApplication.class, args);
	}
	
	public void registPersonInfo(Date birthDay) throws Exception {
		// 応募可能判断
		if(isRegisterdAge(birthDay)) {
			try {
				// 個人情報登録
				dummyRegist();
			} catch(Exception e) {
				throw new Exception("個人情報登録に失敗しました");
			}
		} else {
			System.out.println("16歳未満のため個人情報登録できません");
		}
	}

	/**
	 * 応募可能な年齢か判定するメソッド<br>
	 * 下記内容を応募可能な年齢と判定。<br>
	 * ・満15歳で4月1日以降は、労働可能（労働基準法 第56条（最低年齢））<br>
	 * ・4/1生まれは3/31に年齢を加算する（民法143条）<br>
	 *
	 * @param birthDay
	 *            生年月日
	 * @return true:応募可能年齢 false:応募不可年齢
	 */
	public boolean isRegisterdAge(Date birthDay) {
		// 現在の西暦、月を取得
		Calendar curCal = Calendar.getInstance();

		curCal.setTime(new Date());
		int curYear = curCal.get(Calendar.YEAR);
		int curMonth = curCal.get(Calendar.MONTH) + 1;

		// 生年月日を設定
		Calendar birthCal = Calendar.getInstance();
		birthCal.setTime(birthDay);

		// 判定処理開始
		Calendar compareCal = Calendar.getInstance();
		int compareYear = 0;
		// 現在の月が1～3月の場合
		if (curMonth < APRIL) {
			// 比較用年月日 = 現在の西暦マイナス16年した4月1日
			compareYear = curYear - WORKABLE_AGE;
			compareCal.set(compareYear, Calendar.APRIL, 1);
			// 比較用年月日よりあとの生年月日ならエラー
			if (birthCal.compareTo(compareCal) > 0) {
				return false;
			}
		} else {
			// 現在の月が4～12月の場合
			// 比較用年月日 = 現在の西暦マイナス15年した4月1日
			compareYear = curYear - (WORKABLE_AGE - 1);
			compareCal.set(compareYear, Calendar.APRIL, 1);
			// 比較用年月日よりあとの生年月日ならエラー
			if (birthCal.compareTo(compareCal) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public void dummyRegist() {
		// ダミー処理
	}
	
}
