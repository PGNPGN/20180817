package sse;

import java.util.Scanner;

public class D6_2 {

	static int[] array;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		array = new int[a];
		int sum = fibo(a);
		System.out.println(sum);
		scan.close();
	}
	static int fibo(int n) {

		if(n==2 || n==1) {
			return 1;
		}
		if(array[n-1]>0) return array[n-1];
		return array[n-1] = fibo(n-1) + fibo(n-2);
	}
}
