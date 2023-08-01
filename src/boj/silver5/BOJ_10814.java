package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry; 
import java.util.StringTokenizer;

public class BOJ_10814 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		Map<Integer, ArrayList<String>> hashMap = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<String> tmp = new ArrayList();
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			if(hashMap.containsKey(age)){
				hashMap.get(age).add(name);
			} else {
				tmp.add(name);
				hashMap.put(age, tmp);
			}
		}
		
		List<Entry<Integer, ArrayList<String>>> entry = new ArrayList(hashMap.entrySet());
		Collections.sort(entry, new Comparator<Entry<Integer, ArrayList<String>>>(){
			public int compare(Entry<Integer, ArrayList<String>> o1, Entry<Integer, ArrayList<String>> o2) {
				return o1.getKey() - o2.getKey();
			}
		});
		
		entry.forEach(e -> {
			for (int i = 0; i < e.getValue().size(); i++) {
				System.out.println(e.getKey() + " " + e.getValue().get(i));
			}
		});
	}

}
