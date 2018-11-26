package com.example.kata.StringCalculator;

public class StringCalculator implements IStringCalculator {
	public int Add(String numbers) {
		if(null == numbers)
			return 0;
		
		String seperatorReg = "[,\n]";
		String numberAfterProcess = numbers;
		if(numbers.startsWith("//"))
		{
			String[] tmpArray = numbers.split("\n", 2)
		}
		
		String[] numberList = numberAfterProcess.split(seperatorReg);
					
		if(numberList.length == 1)
		{
			return parseInt(numberList[0]);
		}
		else 
		{
			int r = 0;
			for(String strTemp: numberList)
			{
				r += parseInt(strTemp);
			}
			return r;
			
		}
		
//		//return 0;
	}
	
	protected int parseInt(String number)
	{
		if(null == number || "" == number)
			return 0;
		else
			return Integer.parseInt(number);
	}
}
