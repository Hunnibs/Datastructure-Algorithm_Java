import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**

@author 이병헌
@since 2023. 8. 18.
@see https://www.acmicpc.net/problem/17135
@git
@youtube
@performance
@category # Simulation
@note */

public class Main {
	static class KillEnemyInfo{
		int row, col, distance;

		public KillEnemyInfo(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
		public KillEnemyInfo(int row, int col, int distance) {
			super();
			this.row = row;
			this.col = col;
			this.distance = distance;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			KillEnemyInfo other = (KillEnemyInfo) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
		
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, D, count, killEnemyCount = Integer.MIN_VALUE;
	static int[] archers;  // 궁수의 열 번호를 지정해줄 배열
	static int[][] map;  
	static int[][] inGameMap;
	static Set<KillEnemyInfo> set;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		archers = new int[3];  // 궁수의 정보가 저장될 공간
		map = new int[N+1][M];  // 적의 정보가 저장될 공간
		for (int r = N; r > 0; r--) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		archerCombination(0, 0);  // 정해지는 궁수 위치 개수만큼 게임을 시작할 예정
		System.out.println(killEnemyCount);
	}
	
	
	// map에 적이 하나도 없으면 게임을 끝내버릴 예정
	private static boolean checkAllKill(int stage) {  
		for (int r = stage; r <= N; r++) {
			for (int c = 0; c < M; c++) {
				if (inGameMap[r][c] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	/* 
	 * 핵심 로직
	 * 1. 사수들은 가까운 적부터 쏜다.
	 * 2. 사수들은 거리가 같은 가까운 적이 여러명이라면 사수 기준 좌측부터 쏜다.
	 * 3. 사수들은 전부 같은 적을 공격할 수 있다. 
	 */
	private static void archerKill(int stage, int archerCol) {  // stage 변수만큼 이동해서부터 배열을 탐색하기 시작한다. 앞에는 이미 스테이지가 끝나고 없어진 배열로 생각
		KillEnemyInfo tmp = null;  // 죽이는 적이 누군지 정보를 저장해줄 공간
		
		for (int r = stage; r <= N; r++) {
			for (int c = M-1; c >= 0; c--) {  // 거꾸로 뒤집어서 게임을 진행할 예정이기 때문에 오른쪽 적을 먼저 잡아야한다.
				if (inGameMap[r][c] == 1 && isInDistance(r-stage+1, c, archerCol)) {
					if (tmp == null) {  // 아직 아무도 죽이지 못했다면 걔를 죽일 예정.
						tmp = new KillEnemyInfo(r, c, getDistance(r-stage+1, c, archerCol));
					} else {  // 죽일 예정인 애가 있는데 다른 애가 눈에 들어온다면
						if (tmp.distance > getDistance(r-stage+1, c, archerCol)) {  // 거리를 비교해서 가까운 애를 쏜다.
							tmp = new KillEnemyInfo(r, c, getDistance(r-stage+1, c, archerCol));
						} else if(tmp.distance == getDistance(r-stage+1, c, archerCol) && tmp.col > c) {  // 거리도 같을 때는 늘 사수 기준으로 좌측에 있는 애부터 쏴야한다.
							tmp = new KillEnemyInfo(r, c, getDistance(r-stage+1, c, archerCol));
						}
					}
				}
			}
		}
		
		if (tmp != null) {
			set.add(tmp);
		}
	}
	
	private static void gameStart() {
		count = 0;
		for (int stage = 1; stage <= N; stage++) {  // 스테이지는 총 N 단계로 진행될 예정, 단 중간에 Map이 텅텅 비면 게임이 종료된다.
			set = new HashSet<>();  // 사수가 누군가를 죽일 때 중복된다면 두 번 죽이지 않게 set을 활용해서 관리해준다.
			for (int archerCol : archers) {  // archer 3명이 화살을 쏠 때 적을 어떻게 죽이는지 추적할 예정
				archerKill(stage, archerCol);  // archer 3명이 전부 같은 적을 잡을 수도 있으므로 어디에 있는 적을 죽이는지 확인하고 나중에 적을 없애준다.
			}
			
			Iterator<KillEnemyInfo> iter = set.iterator();
			while(iter.hasNext()) {
				count++;
				KillEnemyInfo tmp = iter.next();
				inGameMap[tmp.row][tmp.col] = 0;
			}
			
			if (checkAllKill(stage+1)) {  // gameMap에 적이 없으면 종료
				return;
			}
		}
	}
	
	private static void archerCombination(int start, int depth) {  // 궁수의 자리 조합은 어떻게 나올 수 있는지 추적
		if (depth == 3) {  // 궁수는 3명만 쓴다고 고정되있다. 
			inGameMap = new int[N+1][M];
			for (int r = 1; r <= N; r++) {
				inGameMap[r] = Arrays.copyOf(map[r], map[r].length);
			}
			
			gameStart();  // 궁수의 현재 자리에 대해서 결과값 연산 시작
			killEnemyCount = Math.max(killEnemyCount, count);
			return;
		} else {
			for (int i = start; i < M; i++) {
				archers[depth] = i;
				archerCombination(i+1, depth+1);
			}
		}
	}
	
	private static int getDistance(int enemyRow, int enemyCol, int archerCol) {  // 적이 얼마나 먼가
		return enemyRow + Math.abs(enemyCol-archerCol);
	}
	
	private static boolean isInDistance(int enemyRow, int enemyCol, int archerCol) {  // 공격이 가능한가
		return (enemyRow + Math.abs(enemyCol-archerCol)) <= D;
	}
}