package com.example.kata.StringCalculator;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringCalculatorTest {
	
	private static Logger logger = LoggerFactory.getLogger(StringCalculatorTest.class);
	
	public IStringCalculator getCalculator()
	{
		return new StringCalculator();
	}

	@Test
	public void testEmptyString()
	{
		IStringCalculator calculator = this.getCalculator();
		int result = calculator.Add("");
		logger.info("result="+result);
		Assert.assertEquals("test empty stirng", 0, result);
	}
	
	@Test
	public void testOneString()
	{
		IStringCalculator calculator = this.getCalculator();
		int result = calculator.Add("2");
		logger.info("result="+result);
		Assert.assertEquals("test {2} stirng", 2, result);
	}

	@Test
	public void testTwoString()
	{
		IStringCalculator calculator = this.getCalculator();
		int result = calculator.Add("1,2");
		logger.info("result="+result);
		Assert.assertEquals("test {1,2} stirng", 3, result);
		
	}
	
}
