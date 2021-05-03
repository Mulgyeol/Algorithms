package algo.study.thisweek;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Kakao_2021_메뉴리뉴얼 {
	
	static Map<String, Integer>[] map;
	
	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		int people = orders.length;
		int maxMenu = course[course.length-1]+1;
		
		
		map = new HashMap[maxMenu+1];
		
		for(int i=2; i<maxMenu+1; i++) {
			map[i] = new HashMap<>();
		}
		
		for(int i=0; i<people; i++) {
			int menuCnt = orders[i].length();
			boolean[] check = new boolean[menuCnt];
			SubSet(orders[i], 0, 0, menuCnt, check);
		}
		
		for(int i : course) {
			
			if(map[i].isEmpty()) continue;
			
			Set<String> keys = map[i].keySet();
			int max = 0;
			for(String s : keys) {
				if(map[i].get(s) > max) {
					max = map[i].get(s);
				}
			}
			
			if(max < 2) continue;
			
			for(String s : keys) {
				if(map[i].get(s) == max) {
					pq.offer(s);
				}
			}
		}
		
		int size = pq.size();
		String[] answer = new String[size];
		for(int i=0; i<size; i++) {
			answer[i] = pq.poll();
			System.out.println(answer[i]);
		}
		
		
		System.out.println("end");
		
	}

	private static void SubSet(String menu, int start, int cnt, int menuCnt, boolean[] check) {
		if(start == menuCnt) {
			if (cnt < 2) return;
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<menuCnt; i++) {
				if(check[i]) {
					sb.append(menu.charAt(i));					
				}
			}
			
			char[] stringToChar = sb.toString().toCharArray();
			Arrays.sort(stringToChar);
			String combMenu = new String(stringToChar);
			if(map[cnt].containsKey(combMenu)) {
				map[cnt].replace(combMenu, map[cnt].get(combMenu)+1);
			}else {
				map[cnt].put(combMenu, 1);
			}
			return;
		}
		
		check[start] = true;
		SubSet(menu, start+1, cnt+1, menuCnt,check);
		check[start] = false;
		SubSet(menu, start+1, cnt, menuCnt,check);

	}
}