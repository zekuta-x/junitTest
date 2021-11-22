package com.example.demo;

import java.util.Calendar;
import java.util.Date;

public class JudgeUtils extends MiraiPrjApplication{
	/**
	 * 課金可能か判定するメソッド<br>
	 * 18歳を超えている場合は課金可能<br>
	 * ※例外発生時は握り潰しで後続処理継続<br>
	 * @param birthDay
	 *            生年月日
	 * @param age
	 *            年齢
	 * @return true:課金可能 false:課金不可
	 */
	public boolean isBillingAge(int age) {
		// 課金可能年齢(対象かつ18歳以上)
		if(age >= WORKABLE_AGE) {
			return true;
		// 課金不可
		} else {
			return false;
		}
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
}
