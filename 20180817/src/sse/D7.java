package sse;

import java.util.Scanner;

public class D7 {
	static Scanner scan = new Scanner(System.in);
	static int size;
	static char[][] map;
	static String dummy="";
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int cnt;
	static int[] count = new int[350];
	static int index=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getInput();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++){
				cnt = 0;
				if(map[i][j] == '1') {
					map[i][j] = '*';
					recursion(i, j);
				}
//				System.out.println("End of recursion");
				if(cnt!=0) {
//					System.out.println("cnt³Ö±â");
					count[index] = cnt;
//					System.out.println("[index]= "+index);
//					System.out.println("count[index]= "+count[index]);
					index++;
				}
			}
		}
		sorting();
		print();
	}

	static void recursion(int x, int y) {
		cnt++;
//		System.out.println("cnt = "+cnt);
		int nx=0, ny=0;
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if(nx>=0 && nx<size && ny>=0 && ny<size) {
				if(map[nx][ny] =='1') {
					map[nx][ny] = '*';
					recursion(nx, ny);
//					System.out.println(cnt);
				}
			}
		}
	}

	static void getInput() {
		size = scan.nextInt();
		scan.nextLine();
		map = new char[size][size];
		for(int i=0; i<size; i++) {
			dummy = scan.nextLine();
			for(int j=0; j<size; j++) {
				map[i][j] = dummy.charAt(j);
			}
		}
//		for(int i=0; i<size; i++) {
//			for(int j=0; j<size; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		
	}
	
	static void sorting() {
		for(int i=0; i<349; i++) {
			for(int j=i+1; j<350; j++) {
				if(count[j] == 0) {
					break;
				}
				if(count[i]>count[j]) {
					int temp = count[i];
					count[i] = count[j];
					count[j] = temp;
				}
				
			}
		}
	}
	
	static void print() {
		System.out.println(index);
		for(int i=0; i<index; i++) {
			System.out.println(count[i]);
		}
	}
}
