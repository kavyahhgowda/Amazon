package com.genericlib.amazon;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hi {

	public static void main(String[] args)  {

		int a[][]=new int[2][3];
		
		a[0][0]=1;
		a[0][1]=1;
		a[0][2]=1;
		
		a[1][0]=2;
		a[1][1]=2;
		a[1][2]=2;
		
	
		
		for(int i=0;i<a.length;i++)
		{
			
			for(int j=0;j<a[i].length;j++) 
			{
				
			
				System.out.println(a[i][j]);
				
			}	
		}			 	
	}
	}