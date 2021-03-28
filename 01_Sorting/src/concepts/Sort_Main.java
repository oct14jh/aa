package concepts;
import java.util.Scanner;

public class Sort_Main {
	public final static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void result(int arr[]) {
		for(int i : arr) 
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 4, 3, 2, 9, 7, 8, 5, 10, 6, 19, 20, 18, 13, 11, 17, 16, 12, 14, 15};
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("정렬 선택(1.선택 2.버블 3.삽입 4.병합 5.퀵 6.힙 7.계수) : ");
			int input = sc.nextInt();
			if(input==0)
				System.exit(0);
			long start=0, end=0;
			
			switch(input) {
			case 1:
				start = System.currentTimeMillis();
				Sort1_Selection sort1 = new Sort1_Selection(arr);
				end = System.currentTimeMillis();
				result(arr);
				System.out.println("선택정렬 작업시간="+(end-start)+"ms");
				break;
			case 2:
				start = System.currentTimeMillis();
				Sort2_Bubble sort2 = new Sort2_Bubble(arr);
				end = System.currentTimeMillis();
				result(arr);
				System.out.println("버블정렬 작업시간="+(end-start)+"ms");
				break;
			case 3:
				start = System.currentTimeMillis();
				Sort3_Insertion sort3 = new Sort3_Insertion(arr);
				end = System.currentTimeMillis();result(arr);
				System.out.println("삽입정렬 작업시간="+(end-start)+"ms");
				break;
			case 4:
				start = System.currentTimeMillis();
				Sort4_MergeTD sort4 = new Sort4_MergeTD(arr);
				end = System.currentTimeMillis();result(arr);
				System.out.println("병합정렬 작업시간="+(end-start)+"ms");
				break;
			case 5:
				start = System.currentTimeMillis();
				Sort5_Quick sort5 = new Sort5_Quick(arr);
				end = System.currentTimeMillis();result(arr);
				System.out.println("퀵정렬 작업시간="+(end-start)+"ms");
				break;
			case 6:
				start = System.currentTimeMillis();
				Sort6_Heap sort6 = new Sort6_Heap(arr);
				end = System.currentTimeMillis();
				result(arr);
				System.out.println("힙정렬 작업시간="+(end-start)+"ms");
				break;
			case 7:
				start = System.currentTimeMillis();
				Sort7_Counting sort7 = new Sort7_Counting(arr);
				end = System.currentTimeMillis();
				result(arr);
				System.out.println("계수정렬 작업시간="+(end-start)+"ms");
				break;
			default:
				System.out.println("숫자 1~7만 입력하세요.");
			}
		}
	}
}
