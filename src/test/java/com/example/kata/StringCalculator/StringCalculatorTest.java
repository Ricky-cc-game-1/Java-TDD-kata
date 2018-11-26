package com.example.kata.StringCalculator;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringCalculatorTest {

	private static Logger logger = LoggerFactory.getLogger(StringCalculatorTest.class);

	public IStringCalculator getCalculator() {
		return new StringCalculator();
	}

	@Test
	public void testEmptyString() {
		IStringCalculator calculator = this.getCalculator();
		int result = calculator.Add("");
		logger.info("result=" + result);
		Assert.assertEquals("test empty", 0, result);
	}

	@Test
	public void testOneString() {
		IStringCalculator calculator = this.getCalculator();
		
		{
			int result = calculator.Add("2");
			logger.info("result=" + result);
			Assert.assertEquals("test {2}", 2, result);
		}
		
		{
			int result = calculator.Add("100");
			logger.info("result=" + result);
			Assert.assertEquals("test {100}", 100, result);
		}
	}

	@Test
	public void testTwoString() {
		IStringCalculator calculator = this.getCalculator();
		int result = calculator.Add("1,2");
		logger.info("result=" + result);
		Assert.assertEquals("test {1,2}", 3, result);

	}

	@Test
	public void testManyString() {
		IStringCalculator calculator = this.getCalculator();
		
		{
			int result = calculator.Add("1,2,3,4,5");
			logger.info("result=" + result);
			Assert.assertEquals("test {1,2,3,4,5}", 15, result);
		}
		
		{
			int result = calculator.Add("14,5");
			logger.info("result=" + result);
			Assert.assertEquals("test {14,5}", 19, result);
		}
		
		{
			int result = calculator.Add("1,2,7,8,5,3,4,5,6,7,5,4,3");
			logger.info("result=" + result);
			Assert.assertEquals("test {1,2,7,8,5,3,4,5,6,7,5,4,3}", 60, result);
		}
	}
	
	@Test
	public void testNewLine() {
		IStringCalculator calculator = this.getCalculator();
		
		{
			int result = calculator.Add("1,2\n3\n4,5");
			logger.info("result=" + result);
			Assert.assertEquals("test {1,2\\n3\\n4,5}", 15, result);
		}
		
		{
			int result = calculator.Add("14\n5");
			logger.info("result=" + result);
			Assert.assertEquals("test {14\\n5}", 19, result);
		}
		
	}	
	
	@Test
	public void testSupportDelimitersChange() {
		IStringCalculator calculator = this.getCalculator();
		
		{
			int result = calculator.Add("//;\n1;2;3;4;5");
			logger.info("result=" + result);
			Assert.assertEquals("test {//;\\n1;2;3;4;5}", 15, result);
		}
		
		{
			int result = calculator.Add("//:\n14:5");
			logger.info("result=" + result);
			Assert.assertEquals("test {//:14:5}", 19, result);
		}

		{
			int result = calculator.Add("//\n\n14\n5");
			logger.info("result=" + result);
			Assert.assertEquals("test {//:14:5}", 19, result);
		}

	}
}
