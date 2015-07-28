package util.vector;
// 전체에서 특정 글자 바꾸기 전체 블록 씌우고 Ctrl + F
import java.util.Collections;
import java.util.Comparator;
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
	Grade grade = new Grade();
	
	
	
	
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
	public Vector<Grade> searchGradeByName(String name) {	 	// String 이 아닌 Vector<Grade> 인 이유는
		Vector<Grade> temp = new Vector<Grade>();				// String 일시 동명이인 존재시 에러
		Grade grade = null;										// GradeService 와 똑같이 맞춰줘야함
		for (int i = 0; i < vec.size(); i++) {
			String searchName = vec.elementAt(i).getName();

			// 고정값(파라미터).equalsIgnoreCase(변수값(for문으로 계속 바뀌는값))
			if (name.equalsIgnoreCase(searchName)) {
				/*String hakbun = vec.elementAt(i).getHakbun();
				int kor = vec.elementAt(i).getKor();
				int eng = vec.elementAt(i).getEng();
				int math = vec.elementAt(i).getMath();
				grade = new Grade(hakbun, name, kor, eng, math);
				위 의 5줄 과 아래의 2줄은 같은 코딩
				*/
				grade = new Grade(vec.elementAt(i).getHakbun(), searchName, 
						vec.elementAt(i).getKor(), vec.elementAt(i).getEng(), vec.elementAt(i).getMath());
				temp.add(grade);
				break;
			} else {
				
				// temp 라는 벡터를 완전히 비워서 null 로 리턴
				temp.remove(new Grade());
			}
		}
		return temp;
	}

	@Override
	public void descbyTotal() {
		// Java API 중에서 ★ 정렬을 담당하는 클래스 Comparator
		// 인터페이스를 구현한 익명 내부 클래스 (anonymous inner class)
		Comparator<Grade> desc = new Comparator<Grade>() { // new 치고 컨트롤스페이스바 로 바로 Comparator를 불러와야 오버라이드..
			
			
			@Override
			public int compare(Grade g1, Grade g2) {
				// 삼항연산자
				/*
				 * if(조건식) {
				 * 	-> true 면 statement 실행
				 * }else{
				 * 	-> false 면 statement 실행
				 * }
				 * (조건식) ? 참 : 거짓;
				 * */
				
//				if (g1.getTotal() < g2.getTotal()) {
//					return 1;
//				} else {
//					if (g1.getTotal() == g2.getTotal()) {
//						return 0;
//					} else {
//						return -1;
//					}
//				}
				return (g1.getTotal() < g2.getTotal()) ? 1 : (g1.getTotal() == g2.getTotal()) ? 0 : -1 ;
			}
		};
		Collections.sort(vec,desc); // 정렬
		System.out.println(vec.toString());
	}

	@Override
	public void ascbyName() {
		Comparator<Grade> asc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				// 값(value)이 int 타입이 아니고 
				// String 타입의 우선순위 결정할 때는...
				// compareTo 라는 메소드를 사용해야한다. 
				return g1.getName().compareTo(g2.getName());
			}
		};
		Collections.sort(vec,asc);
		System.out.println(vec.toString());
	}

}
