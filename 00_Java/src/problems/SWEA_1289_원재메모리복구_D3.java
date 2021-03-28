package problems;

import java.util.*;
 
public class SWEA_1289_원재메모리복구_D3 {
    private static Scanner sc = new Scanner(System.in);
    private static int T;
    public static void main(String[] args) {
        T = sc.nextInt();
        sc.nextLine();
         
        for(int test_case=1; test_case<=T; test_case++) {
            String str = sc.nextLine();
            char[] reset =new char[str.length()];
             
            for(int i=0; i<str.length();i++)
                reset[i]='0';
             
            int ans=0;
            for(int i=0; i<str.length(); i++) {
                if(reset[i]==str.charAt(i)) {
                    continue;
                }
                if(reset[i]!=str.charAt(i)) {
                    ++ans;
                    char ch=str.charAt(i);
                    for(int j=i; j<reset.length; j++) {
                        reset[j] = ch;
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}