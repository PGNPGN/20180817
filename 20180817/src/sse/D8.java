package sse;

import java.util.Scanner;

public class D8 {

	static Scanner scan= new Scanner(System.in);
	static int num;
	static char[][] map, map_Blind;
	static String dummy = "";
	static int cnt;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] check, check_Blind;
	static char color;
	static int area;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getInput();
		check();
		getInput_Blind();
		check_Blind();
	}
	private static void check_Blind() {
		area = 0;
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(check_Blind[i][j] != 1) {
					area++;
					color = map_Blind[i][j];
					recursion_Blind(i,j);
				}
			}
		}
		System.out.print(area);
	}
	public static void check() {
		area = 0;
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(check[i][j] != 1) {
					area++;
					color = map[i][j];
					recursion(i,j);
				}
			}
		}
		System.out.print(area+" ");
	}
	
	public static void getInput() {
		num = scan.nextInt();
		scan.nextLine();
		map = new char[num][num];
//		map_Blind = new char[num][num];
		check = new int[num][num];
//		check_Blind = new int[num][num];
		//for map
		for(int i=0; i<num; i++) {
			dummy = scan.nextLine();
			for(int j=0; j<num ; j++) {
				map[i][j] = dummy.charAt(j);
			}
		}
		//for map_Blind
//		for(int i=0; i<num; i++) {
//			for(int j=0; j<num ; j++) {
//				if(map[i][j] =='G') {
//					map_Blind[i][j] = 'R';
//				}else
//					map_Blind[i][j] = map[i][j];
//			}
//		}
		//print map
//		for(int i=0; i<num; i++) {
//			for(int j=0; j<num ; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		//print map_Blind
//		for(int i=0; i<num; i++) {
//			for(int j=0; j<num ; j++) {
//				System.out.print(map_Blind[i][j]);
//			}
//			System.out.println();
//		}
	}
	public static void getInput_Blind() {
		map_Blind = new char[num][num];
		check_Blind = new int[num][num];
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num ; j++) {
				if(map[i][j] =='G') {
					map_Blind[i][j] = 'R';
				}else
					map_Blind[i][j] = map[i][j];
			}
		}
//				for(int i=0; i<num; i++) {
//					for(int j=0; j<num ; j++) {
//						System.out.print(map_Blind[i][j]);
//					}
//					System.out.println();
//				}
	}
	private static void recursion_Blind(int x, int y) {
		int nx = 0, ny = 0;
		check_Blind[x][y] = 1;

		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if(nx>=0 && nx<num && ny>=0 && ny<num) {
				if(check_Blind[nx][ny] == 0 && map_Blind[nx][ny] == color) {
					recursion_Blind(nx,ny);
				}
			}
		}
		
	}
	public static void recursion(int x, int y) {
		int nx = 0, ny = 0;
		check[x][y] = 1;

		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if(nx>=0 && nx<num && ny>=0 && ny<num) {
				if(check[nx][ny] == 0 && map[nx][ny] == color) {
					recursion(nx,ny);
				}
			}
		}
	}
}
