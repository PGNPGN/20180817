package sse;

import java.util.Scanner;

public class D2 {

	Scanner scan = new Scanner(System.in);
	int x;
	int y;
	String dummy = "";
	char[][] map, mapcopy;
	int startx, starty;
	int goalx, goaly;
	Node[] queue;
	Node data;
	int hour=0, hourmax;
	int rp=0, wp=1;
	int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	int nx, ny;

	public class Node{
		int x, y, hour;

		public Node(int x, int y, int hour) {
			this.x = x;
			this.y = y;
			this.hour = hour;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D2 obj = new D2();
		obj.getInput();
		obj.selectPoint();
		System.out.println(obj.hourmax);
	}

	public void getInput() {
		x = scan.nextInt();
		y = scan.nextInt();
		scan.nextLine();
		map = new char[x][y];
		mapcopy = new char[x][y];
		queue = new Node[x*y];

		for(int i=0; i<x; i++) {
			dummy = scan.nextLine();
			for(int j=0; j<y; j++) {
				map[i][j] = dummy.charAt(j);
			}
		}
	}
	public void selectPoint() {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				if(map[i][j] == 'L') {
//					System.out.println(" i = "+i+"j = "+j);
					bfs(i, j);
				}
			}
		}
	}
	private void bfs(int i, int j) {
		
		for(int u=0; u<x; u++) {
			for(int v=0; v<y; v++) {
				mapcopy[u][v] = map[u][v];
			}
		}
//		mapcopy = map.clone();
		rp=0; wp=0;
		queue[0] = new Node(i, j, 0);
		wp++;



		while(rp<wp) {
			data = queue[rp];
			rp++;
//			System.out.println(" data.x = "+data.x+"data.y = "+data.y);
			for(int k=0; k<4; k++) {
				nx = data.x + dx[k];
				ny = data.y + dy[k];

//				System.out.println(" nx = "+nx+" ny = "+ny);

				if(nx>=0 && nx<x && ny>=0 && ny<y) {
					if(mapcopy[nx][ny]=='L') {
						queue[wp] = new Node(nx, ny, data.hour+1);
//						System.out.println("queue["+wp+"] is filled");
						wp++;
						mapcopy[nx][ny] = 'W';

//						print(mapcopy);
					}
				}
			}


//			for(int l=0; l<wp; l++) {
//				System.out.print(queue[l].hour);
//			}
//			System.out.println();
			if(queue[wp-1].hour>hourmax) {
				hourmax = queue[wp-1].hour;
			}
			

//			print(map);
//			System.out.println();
//			print(mapcopy);
		}

	}

	public void print(char[][] map) {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
