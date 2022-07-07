package com.arab.leaseland.controllers;

import java.util.Arrays;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "jsonp ({\"statuscode\":\"025\",\"RRR\":\"200008473541\",\"status\":\"Payment Reference generated\"})";
		String[] inputArray = input.split(",");
		String rrr = inputArray[1];
		String getrrr = rrr.substring(6, rrr.length());
		
		System.out.println(Arrays.toString(inputArray));
		System.out.println(rrr);
		System.out.println(getrrr);
	}

}
