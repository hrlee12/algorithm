package algorithm.simulation;


/*
 * @author 이효리
 * 
 * 
 * <진행 방법>
 * 1. 입력값을 받는다. 
 * 2. playGame함수를 호출해서 문제를 해결한다. 
 * 3. 명령어를 for문으로 돌리면서 해당 명령을 확인하고 이동이면 move함수 호출 shoot이면 슛함수 호출
 * 4. 명령어를 모두 확인하면 playGame함수 리턴되고 map을 출력한다. 
 * 
 * 
 * 
 * 
 * 
 * <이동할 때 가능한 시나리오>
 * 이동하는 곳이 평지일 때 -> 이동, 주어진 방향으로 바꿈
 * 					     원래 좌표의 값을 평지로 바꾸고 가려는 쪽의 좌표의 값을 가는 방향의 화살표로 바꾼다. 
 * 			 평지가 아닐 때 -> 제자리, 주어진 방향으로 바꿈. 
 * 					          현재 좌표의 값을 가려는 방향의 화살표로 바꾼다.
 * 
 * move 함수로 구현
 * 
 * move(String direct)
 * 방향의 인덱스가 평지이면
 * 	현재 인덱스를 평지로 바꿈
 * 	가는 방향으로 전차의 위치 바꿈
 * 
 * 현재 전차의 위치에 전차의 방향 입력해줌. 
 * 
 * 
 * 
 * 
 * 
 * <포탄을 던질 때 시나리오>
 * 현재 전차가 바라보는 방향에 벽이나 강철이 없으면(map의 범위를 벗어나면) -> 아무일도 일어나지 않음. 
 * 					    벽을 만나면 -> 벽이 평지로 바뀜. 탐색 종료
 * 					    강철을 만나면 -> 아무일도 일어나지 않음. 탐색 종료
 * 
 * shoot 재귀함수를 만듦.
 * 
 * shoot(int goRow, int goColumn, int bombRow, int bombColumn)
 * 
 * 기저조건 : map의 인덱스를 벗어날 때 -> 리턴
 * 			벽-> 벽을 평지로 바꿈. 리턴
 * 			강철 -> 리턴

 * 
 * 진행로직 : 다음 칸 인덱스로 재귀함수 호출
 * 
 * 
 * 
 * 
 * 
 * <전역변수> 
 * goDirect : Map<Character, Character>	이동하는 방향에 맞게 map에 나타낼 기호
 * tankDirect : Map<Character, int[]>	전차의 방향에 맞게 포탄이 나아가는 인덱스 저장. 
 * row : int     					현재 전차의 행
 * column : int						현재 전차의 열
 * map : String[][]
 * commands : String[]
 * 
 * 
 * 
 * 
 * <만들 메서드> 
 * 
 * playGame()
 * 
 * 포탄을 쏘는 메서드
 * shoot(int goRow, int goColumn, int bombRow, int bombColumn)
 * 
 * 이동하는 메서드
 * move(char command)
 * 
 * 
 */


import java.util.*;
import java.io.*;


public class SWEA_1873_상호의배틀필드_이효리 {
	
	public static int height, width, command_length, row, column;
	public static char[][] map;
	public static String commands;
	public static Map<Character, Character> goDirect = new HashMap<Character, Character>(){{
		put('U', '^');
		put('D', 'v');
		put('L', '<');
		put('R', '>');
	}};
	
	public static  Map<Character, int[]> tankDirect = new HashMap<Character, int[]>() {{
		put('^', new int[] {-1, 0});
		put('v', new int[] {1, 0});
		put('<', new int[] {0, -1});
		put('>', new int[] {0, 1});
	}};
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			map = new char[height][width];
			
			for (int r = 0; r < height; r++) {
				String input = br.readLine();
				for (int c = 0; c < width; c++) {
					char current = input.charAt(c);
					
					if (current == '^' || current == '<' || current == '>' || current == 'v') {
						row = r;
						column = c;
					}
						

					map[r][c] = input.charAt(c);
				}
			}
			
			command_length = Integer.parseInt(br.readLine());
			commands = br.readLine();


			playGame();
			
			sb.append("#" + (tc+1) + " ");
			
			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
					sb.append(map[row][col]);
				}
				sb.append("\n");
			}
			
			
// 입력값 잘 받았는지 확인하는 코드
//			System.out.println("height : " + height + "  width : " + width);
//			for (int idx = 0; idx < height; idx++) {
//				System.out.println(Arrays.toString(map[idx]));
//			}
//			
//			System.out.println("command_length : " + command_length);
//			System.out.println(commands);
//			System.out.println(row + " " + column);
		}
		System.out.println(sb);
	}

	public static void playGame() {
		for (int idx=0; idx < command_length; idx++) {
			
			char command = commands.charAt(idx);
			if (command == 'U' || command=='D' || command=='L' || command=='R') {
				move(command);
			}
			if (command == 'S') {
				int[] direct = tankDirect.get(map[row][column]);
				shoot(direct[0], direct[1], row, column);
			}
		}
	}
	
	public static void move(char command) {
		
		char change_direct = goDirect.get(command);
		int[] go_direct = tankDirect.get(change_direct); 
		int go_row = row+go_direct[0];
		int go_column = column+go_direct[1];
		
	
		if ((go_row>=0 && go_row < height) && (go_column>=0 && go_column < width)) {
			if (map[go_row][go_column] == '.') {
				map[row][column] = '.';
				row = go_row;
				column =go_column;
			}
		}
		map[row][column] = change_direct;

		

	}

	
	public static void shoot(int goRow, int goColumn, int bombRow, int bombColumn) {
		if (bombRow < 0 || bombRow >= height)
			return;		
		if (bombColumn < 0 || bombColumn >= width)
			return;
		
		if (map[bombRow][bombColumn] == '*') {
			map[bombRow][bombColumn] = '.';
			return;
		}
		
		if (map[bombRow][bombColumn] == '#') {
			return;
		}
		
		shoot(goRow, goColumn, bombRow+goRow, bombColumn+goColumn);
		
	}
}

