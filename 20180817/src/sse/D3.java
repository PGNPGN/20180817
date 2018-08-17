package sse;

import java.util.Scanner;

public class D3 {

	Scanner scan = new Scanner(System.in);
	int L=1, R=1, C=1;
	char[][][] map;
	String dummy = "";
	int startx, starty, startz;
	int[] dx = {1, -1, 0, 0, 0, 0};
	int[] dy = {0, 0, 1, -1, 0, 0};
	int[] dz = {0, 0, 0, 0, 1, -1};
	int rp, wp;
	Node[] queue;
	Node data;
	
	public class Node{
		int x, y, z;
		int minutes;
		
		public Node(int x, int y, int z, int minutes) {
			this.x = x; this.y = y; this.z = z; this.minutes = minutes;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D3 obj = new D3();
		
		while(true) {
			obj.getInput();
//			obj.print(obj.map);
			obj.bfs();
			
			if(obj.L ==0 && obj.R ==0 && obj.C ==0)
				break;
		}
	}
	
	public void bfs() {
		rp =0; wp = 0;
		int nx, ny, nz;
		queue[0] = new Node(startx, starty, startz, 0);
		wp++;
		while(rp<wp) {
			data = queue[rp];
//			System.out.println("now location = "+data.x+" "+data.y+" "+data.z);
			rp++;
//			if(map[data.x][data.y][data.z] == 'E') {
//				System.out.println("Escaped in "+data.minutes+" minute(s)");
//				return;
//			}
			for(int i=0; i<6; i++) {
				nx = data.x + dx[i];
				ny = data.y + dy[i];
				nz = data.z + dz[i];
//				System.out.println("next location = "+nx+" "+ny+" "+nz);
				if(nx>=0 && nx<L && ny>=0 && ny<R && nz>=0 && nz<C) {
//					System.out.println("scope test");
					if(map[nx][ny][nz] =='.') {
						queue[wp] = new Node(nx,ny,nz,data.minutes+1);
//						System.out.println("queue "+ wp + "is filled");
//						System.out.println("minutes is "+(data.minutes+1));
						wp++;
						map[nx][ny][nz] = '#';
//						print(map);
					}
					else if(map[nx][ny][nz] =='E') {
						System.out.println("Escaped in "+(data.minutes+1)+" minute(s).");
						return;
					}
				}
			}
		}
		System.out.println("Trapped!");
	}
	public void getInput() {
		L = scan.nextInt();
		R = scan.nextInt();
		C = scan.nextInt();
		scan.nextLine();
		queue = new Node[L*R*C];
		map = new char[L][R][C];
		
		if(L ==0 && R ==0 && C ==0)
			return;
		
		for(int i=0; i<L; i++) {
			for(int j=0; j<R; j++) {
				dummy = scan.nextLine();
				for(int k=0; k<C; k++) {
					if(dummy.charAt(k) =='S') {
						startx = i; starty = j; startz = k;
//						System.out.println("startx = "+startx+" starty = "+starty+" startz = "+startz);
					}
					map[i][j][k] = dummy.charAt(k);
				}
			}
			if(i!=L-1)
				scan.nextLine();
		}
	}
	
	public void print(char[][][] map) {
		for(int i=0; i<L; i++) {
			for(int j=0; j<R; j++) {
				for(int k=0; k<C; k++) {
					System.out.print(map[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
//		System.out.println(startx+" "+starty+" "+startz);
	}
}
