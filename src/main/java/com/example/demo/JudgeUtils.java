package com.example.demo;

import java.util.Calendar;
import java.util.Date;

public class JudgeUtils extends MiraiPrjApplication{
	
	/**
	 * 課金可能か判定するメソッド<br>
	 * 下記内容を可能な年齢と判定。<br>
	 * ・満18歳で4月1日以降は、可能<br>
	 * ・4/1生まれは3/31に年齢を加算する<br>
	 * @param birthDay
	 *            生年月日
	 * @return true:課金可能 false:課金不可
	 */
	public boolean isBillingAge(Date birthDay) {
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
			// 比較用年月日 = 現在の西暦マイナス18年した4月1日
			compareYear = curYear - BILLINGABLE_AGE;
			compareCal.set(compareYear, Calendar.APRIL, 1);
			// 比較用年月日よりあとの生年月日ならエラー
			if (birthCal.compareTo(compareCal) > 0) {
				return false;
			}
		} else {
			// 現在の月が4～12月の場合
			// 比較用年月日 = 現在の西暦マイナス17年した4月1日
			compareYear = curYear - (BILLINGABLE_AGE - 1);
			compareCal.set(compareYear, Calendar.APRIL, 1);
			// 比較用年月日よりあとの生年月日ならエラー
			if (birthCal.compareTo(compareCal) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * プレイ対象年齢未満か判定するメソッド<br>
	 * 下記内容を可能な年齢と判定。<br>
	 * ・満18歳で4月1日以降は、可能<br>
	 * ・4/1生まれは3/31に年齢を加算する<br>
	 *
	 * @param birthDay
	 *            生年月日
	 * @return true:プレイ可能年齢 false:プレイ不可年齢
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
			// 比較用年月日 = 現在の西暦マイナス18年した4月1日
			compareYear = curYear - PLAYABLE_AGE;
			compareCal.set(compareYear, Calendar.APRIL, 1);
			// 比較用年月日よりあとの生年月日ならエラー
			if (birthCal.compareTo(compareCal) > 0) {
				return false;
			}
		} else {
			// 現在の月が4～12月の場合
			// 比較用年月日 = 現在の西暦マイナス17年した4月1日
			compareYear = curYear - (PLAYABLE_AGE - 1);
			compareCal.set(compareYear, Calendar.APRIL, 1);
			// 比較用年月日よりあとの生年月日ならエラー
			if (birthCal.compareTo(compareCal) > 0) {
				return false;
			}
		}
		return true;
	}
}
