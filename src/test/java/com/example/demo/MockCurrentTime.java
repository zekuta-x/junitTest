package com.example.demo;

import java.util.Date;

import mockit.Mock;
import mockit.MockUp;


// Mock Date用クラス
class MockCurrentTime extends MockUp<System>{

	private Date mockTime;

	public MockCurrentTime(Date mockTime) {
		this.mockTime = mockTime;
	}

	@Mock
	public long currentTimeMillis() {
		return mockTime.getTime();
	}

	public Date getDate() {
		return (Date) mockTime.clone();
	}

}
