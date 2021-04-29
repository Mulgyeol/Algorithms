package algo.study.thisweek;

public class Kakao_2021_신규아이디추천 {

	public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
		int len = new_id.length();
		
		//1단계
		new_id = new_id.toLowerCase();
		
		//2단계
		for(int i=0; i<len; i++) {
			char c = new_id.charAt(i);
			if(c >= 'a' && c <= 'z') {
				sb.append(c);
			}else if(Character.isDigit(c)) {
				sb.append(c);
			}else if(c == '-' || c=='_' || c =='.') {
				sb.append(c);
			}else {
				continue;
			}
		}
		
        //3단계
		new_id = sb.toString();
		len = new_id.length();
		sb.setLength(0);
		sb.append(new_id.charAt(0));
		int back = 0, front = 1;
		while(front < len) {
			if(new_id.charAt(back)=='.' && new_id.charAt(front)=='.') {
				front++;
			}else{
				sb.append(new_id.charAt(front));
				back = front;
				front++;
			}
		}

		//4단계
		if(sb.length() >= 1 && sb.charAt(0) == '.') {
			sb = new StringBuilder(sb.substring(1, sb.length()));
		}
		
		if(sb.length() >= 1 && sb.charAt(sb.length()-1) == '.') {
			sb = new StringBuilder(sb.substring(0, sb.length()-1));
		}
		
		
		//5단계
		if(sb.length() == 0) {
			sb.append('a');
		}
        
		//6단계
		if(sb.length() >= 16) {
			sb = new StringBuilder(sb.substring(0, 15));
		}
        
        while(sb.length() != 0 && sb.charAt(sb.length()-1) == '.'){
            sb = new StringBuilder(sb.substring(0, sb.length()-1));
        }
		
        //7단계
		while(sb.length() <= 2) {
			sb.append(sb.charAt(sb.length()-1));
		}
        
        answer = sb.toString();
		
		return answer;
    }
}