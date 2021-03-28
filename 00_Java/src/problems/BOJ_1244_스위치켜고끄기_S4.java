package problems;

import java.util.Scanner;
/*
 * 이문제는 솔직히 쉬워서 풀이할게 따로 없는데,,,
 * 배열 인덱스 주의 해서 좀 풀면 될듯하다.
 */
public class BOJ_1244_스위치켜고끄기_S4 {
	private static int[] switchState;
	private static int studentN;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int switchN = sc.nextInt();
		
		// 스위치 수 및 스위치 상태 입력
		switchState = new int[switchN + 1];
		for(int i = 1; i <= switchN; i++) {
			switchState[i] = sc.nextInt();
		}
		
		
		// 학생 수 및 학생 성별과 받은 숫자 입력
		studentN = sc.nextInt();
		for(int i = 0; i < studentN; i++) {
			int sex = sc.nextInt();
			int num = sc.nextInt();
			
			switch(sex) {
			case 1:
				boy(num);
				break;
			case 2:
				girl(num);
				break;
			default:
				System.out.println("잘못된 성별");
			}
		}
		
		
        for (int i = 1; i <= switchN; i++) {
            System.out.print(switchState[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        sc.close();
	}
	
	private static void boy(int num) {
		for(int i = 1; i < switchState.length; i++) {
			int idx = num * i;
			if(idx < switchState.length) {
				switch(switchState[idx]) {
				case 0:
					switchState[idx] = 1;
					break;
				case 1:
					switchState[idx] = 0;
					break;
				default :
					System.out.println("오류");
				}
			}
		}
	}
	
	private static void girl(int num) {
		int left = num - 1;
		int right = num + 1;
			
		while(left > 0 && right < switchState.length) {
			if(switchState[left] == switchState[right]) {
				left--;
				right++;
			}
			else
				break;
		}
		for(int idx = left+1; idx <= right-1; idx++) {
			switch(switchState[idx]) {
				case 0: 
					switchState[idx] = 1;
					break;
				case 1: 
					switchState[idx] = 0;
					break;
				default: System.out.println("오류");
			}
		}
	}
}
