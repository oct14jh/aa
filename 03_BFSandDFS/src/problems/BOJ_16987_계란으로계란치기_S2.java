package problems;

import java.util.Scanner;

class Egg {
	int durability;
	int weight;
	public Egg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Egg(int durability, int weight) {
		super();
		this.durability = durability;
		this.weight = weight;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Egg [durability=" + durability + ", weight=" + weight + "]";
	}
}
public class BOJ_16987_계란으로계란치기_S2 {
	private static Egg[] eggArr;
	private static int N, result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine().trim());
		eggArr = new Egg[N];
		for(int i = 0; i < N; i++) {
			eggArr[i] = new Egg(sc.nextInt(), sc.nextInt());
		}
		
		dfs(0);
		System.out.println(result);
	}
	
	private static void dfs(int index) {
		Egg catchEgg = eggArr[index];		
		if(index==N-1) {
			for(int i = 0; i< N; i++) {
				if(eggArr[i].durability <= 0)
					result++;
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(index == i) continue;
			if(eggArr[i].durability <= 0) continue;
			eggArr[i].durability -= catchEgg.weight;
			catchEgg.durability -= eggArr[i].weight;
			if(catchEgg.durability <= 0 || (eggArr[i].durability > 0 && catchEgg.durability > 0)) {
				dfs(index+1);
			}
			
		}
	}
	
	
}
