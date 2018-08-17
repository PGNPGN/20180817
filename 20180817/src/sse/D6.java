package sse;

import java.util.Scanner;

public class D6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int sum = fibo(a);
		System.out.println(sum);
		scan.close();
	}
	static int fibo(int n) {
		if(n==2 || n==1) {
			return 1;
		}
		return fibo(n-1) + fibo(n-2);
	}
}
