package util.vector;

import java.util.Scanner;
import java.util.Vector;

/*
 * java.util.Vector 의 메소드 중에
 * 추가 기능을 담당하는 add()
 * */
public class AddDemo {
	public static void main(String[] args) {
		Vector<String> avengers = new Vector<String>();
//		avengers.add("홍길동");
		
		// 크기가 4인 스트링 배열의 선언과 생성
		String[] heroes = {"iron", "thor", "hulk", "hawk"};
		for (int i = 0; i < heroes.length; i++) {
			avengers.add(heroes[i]); // 배열의 값들이 벡터의 avengers 로 들어옴.
		}
		// 자료 구조는 저장과 검색이라는 기능을 위해 만들어진 클래스이다.
		// thor 가 avengers 회원인지 검색
		Scanner scanner = new Scanner(System.in);
		System.out.println("어벤저스 회원 검색 이름입력");
		String thor = scanner.next();
		if (avengers.contains(thor)) {
			int idx = avengers.indexOf(thor);
			System.out.println(thor+"는 "+(idx+1)+"번째에 있습니다.");
		} else {
			System.out.println(thor+"는 어벤저스 회원이 아닙니다.");
		}
		// 첫번째 요소 삭제
		avengers.remove(0); // 인덱스 값을 파라미터로 전달 하면 삭제 완료.
	}
}
