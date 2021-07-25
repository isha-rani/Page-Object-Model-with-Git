package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.Pages.HomePage;
import com.w2a.Pages.LoginPage;
import com.w2a.utlitites.Utilties;

public class LoginTest extends BaseTest{
	@Test(dataProviderClass=Utilties.class, dataProvider="dp")
public void loginTest(Hashtable<String,String> data) {
	HomePage hp=new HomePage();
	LoginPage lp=hp.goToSignIn();
//	lp.doLogin("ishakhurna21@gmail.com", "Mysterious21@");
	lp.doLogin(data.get("username"), data.get("password"));
	
}
}
