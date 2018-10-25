package startlink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최대공약수와 최소공배수
public class BOJ_2609 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a=0, b=0;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		/*
		int result_BruteForce= gcd_BruteForce(a,b);
		System.out.printf("BruteForece : %d\n",result_BruteForce);
		 */
		int result_Euclidean = gcd_Euclidean(a,b);
		System.out.printf("%d\n",result_Euclidean);
		
		int result_lcm = a*b/result_Euclidean;
		System.out.printf("%d\n",result_lcm);
	
	}
	
	public static int gcd_BruteForce(int a, int b) {
		int max = 0;
		int range = Math.min(a, b);
		
		for(int i=range; i >= 1; i--) {
			if(a % i == 0 && b % i == 0) {
				max = i;
				break;
			}
		}
		return max;
	}
	
	public static int gcd_Euclidean(int a, int b) {
		
		int rest = a%b;
		
		if(rest == 0) {
			return b;
		}else {
			return gcd_Euclidean(b,rest);
		}
		
	}
}
