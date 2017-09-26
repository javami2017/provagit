package com.riccardofinazzi.hibernate.util;

import java.util.Scanner;

public class SysinReader {

	public String readString(String msg) {

		String s = null;
		try (Scanner scn = new Scanner(System.in)) {
			if (scn.hasNextLine()) {
				System.out.println(msg);
				s = scn.nextLine();
			}
		}
		return s;
	}

	public Integer readInteger(String msg) {

		Integer i = null;
		try (Scanner scn = new Scanner(System.in)) {
			if (scn.hasNextLine()) {
				System.out.println(msg);
				i = Integer.parseInt(scn.nextLine());
			}
		}
		return i;
	}
	
}
