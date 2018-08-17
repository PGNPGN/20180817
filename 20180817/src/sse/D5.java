package sse;

import java.util.Scanner;

public class D5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a = sum(n);
		System.out.println(a);
		scan.close();
	}
	
	static int sum(int n) {
		if(n<1)
			return 0;
		return sum(n-1) + n;
	}
}
