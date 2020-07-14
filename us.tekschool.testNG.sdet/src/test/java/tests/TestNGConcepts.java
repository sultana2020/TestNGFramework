package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGConcepts {
	
	@Test
	public void signIn() {
		String a = "school";
		String b = "school";
		Assert.assertEquals(a,b);
			
	}
	
	// Test HomePage depends on successful execution of SignIn test. 
	@Test (dependsOnMethods = {"signIn"})
	public void homePage() {
		System.out.println("This test is depended on Sign In test cases");
		
	}
	
	@Test (invocationCount = 10)
	public void checkTitle() {
		System.out.println("this test case will run 10 times");
	}
	@Test(groups = {"smokeTest"})
	public void logout() {
		System.out.println("log out test");
	}
	
	@Test(groups = {"smokeTest"})
	public void dashboard() {
		System.out.println("dashboard test");
	}
	
	@Test(groups = {"smokeTest"})
	public void customerPage() {
		System.out.println("customer page test");
	}
	
	
	
	

}
