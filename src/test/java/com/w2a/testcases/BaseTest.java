package com.w2a.testcases;

import com.w2a.BasePage.Page;

public class BaseTest {

	public void tearDown() {
		Page.quit();
	}
}
