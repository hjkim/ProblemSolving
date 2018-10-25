package startlink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9613 {
	static ArrayList<Integer> v;
	static long sum;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list = makeBucket(st);
			recursive(0,0,list);
			System.out.println(sum);
		}
		
	}
	public static ArrayList<Integer> makeBucket(StringTokenizer st) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		v = new ArrayList<Integer>();
		sum = 0;
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		return list;
	}
	
	public static void recursive(int node, int len, ArrayList<Integer> list) {
		if(len == 2) {
			sum += gcd(v.get(0),v.get(1));
		}else {
			for(int i = node; i<list.size(); i++) {
				v.add(list.get(i));
				recursive(i+1,len+1,list);
				v.remove(v.size()-1);
			}
		}
	}
	
	public static int gcd(int a, int b) {
		int rest=a%b;
		if(rest == 0) {
			return b;
		}else {
			return gcd(b,rest);
		}
	}
}
