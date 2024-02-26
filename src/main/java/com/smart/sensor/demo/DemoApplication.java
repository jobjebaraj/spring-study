package com.smart.sensor.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.lalyos.jfiglet.FigletFont;
 

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		int input[] = {5, 3, -3, -4, 0, 2, -1, 4, -7, 2};
		
		 int[] result = Rearrange(input);
		 for(int i=0;i<result.length;i++)
		 {
			 System.out.println(result[i]);
		 }
		 
	}

	
	private static int[] Rearrange(int[] inputData)
	{
	    int[] response = new int[inputData.length];
	    int arrayPointer = 0;
		for(int i=0;i<inputData.length;i++)
		{
		   if(inputData[i] > 0)
		   {
			   response[arrayPointer] = inputData[i];
			   arrayPointer++;
		   }
		}
	 
		for(int i=0;i<inputData.length;i++)
		{
			if(inputData[i] <= 0)
			   {
				   response[arrayPointer] = inputData[i];
				   arrayPointer++;
			   } 
		}
	 
		return response;
	}
}
