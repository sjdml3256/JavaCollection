package util.vector;

import java.util.Vector;

/*
 * 프로그램을 코딩하다 보면
 * 자료구조를 다루는데 있어서
 * CRUD 액션의 반복을 경험하게 됩니다.
 * Create : 입력 생산
 * Read : 출력 조회
 * Update : 수정 -> 저장된 값을 수정 DB
 * Delete : 삭제 -> 완전 삭제 DB, null 값으로 바꾸는 삭제
 * */
public class GradeServiceImpl implements GradeService{
	// 필드에 아래 메소드들이 공유할 자료구조를 뭘 쓸까
	// 1. ArrayList 2. Vector 3. Stack 4. HashMap
	// 순서 O, 중복 O
	private Vector<Grade> vec = new Vector<Grade>();
	Grade = grade = new Grade();
	
	
	
	@Override
	public void input(Grade grade) {
		// 성적표 입력
		vec.add(grade);
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		System.out.println(vec.toString());
		
	}

	@Override
	public String searchGradeByHakbun(String Hakbun) {
		String msg = "";
		Grade grade = null; // 지변으로 인스턴스를 구현했으므로 초기화
		// List 계열의 클래스 길이는 size()
		for (int i = 0; i < vec.size(); i++) {
			// 만약 vec 가 배열이라면
			// vec.get(i)
			String searchHakbun = vec.elementAt(i).getHakbun();
			// 객체.메소드.메소드.메소드..... 이런 패턴은 
			// 반드시 리턴값이 있는 메소드들 끼리 연결시에만 가능하다.
			// 이런 방식을 메소드 체인이라고 한다.
			if (Hakbun.equalsIgnoreCase(searchHakbun)) {
				String name = vec.elementAt(i).getName();
				int kor = vec.elementAt(i).getKor();
				int eng = vec.elementAt(i).getEng();
				int math = vec.elementAt(i).getMath();
				grade = new Grade(searchHakbun, name, kor, eng, math);
				msg = grade.toString();
				break;
			} else {
				msg = "조회하는 학번이 없습니다.";
			}
			
		}
		return msg;
	}

	@Override
	public void ascGradeTotal() {
		// TODO Auto-generated method stub
		
	}

}
