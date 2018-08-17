package sse;

import java.util.Scanner;

public class D4 {
	
Scanner scan = new Scanner(System.in);
int num, length;
String dummy;
char[][] map;
int start, goal;

	public class Node{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D4 obj = new D4();
		obj.getInput();
	}

	
	public void bfs() {
		
	}
	public void getInput() {
		num = scan.nextInt();
		length = scan.nextInt();
		scan.nextLine();
		map = new char[num][length];
		
		for(int i=0; i<num; i++) {
			dummy = scan.nextLine();
			for(int j=0; j<length; j++) {
				map[i][j] = dummy.charAt(j);
			}
		}
		start = scan.nextInt();
		goal = scan.nextInt();
		
//		for(int i=0; i<num; i++) {
//			for(int j=0; j<length; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
}
