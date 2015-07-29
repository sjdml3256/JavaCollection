package util.hashmap;

import java.util.Scanner;

public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		
		Scanner scanner = new Scanner(System.in);
		String input ="";
		
		while (true) {
			System.out.println("[JOIN] : 회원가입, [LOGIN] : 로그인, [LOGOUT] : 로그아웃");
			input = scanner.next();
			if (input.equals("logout")) {
				System.out.println("로그아웃!");
				break;
			} else if (input.equals("join")) {
				System.out.println("아이디 : ");
				String userid = scanner.next();
				System.out.println("비밀번호 : ");
				String password = scanner.next();
				System.out.println("이름 : ");
				String name = scanner.next();
				System.out.println("나이 : ");
				int age = scanner.nextInt();
				System.out.println("주소 : ");
				String address = scanner.next();
				
				service.join(userid, password, name, age, address);
			} else if (input.equals("login")) {
				System.out.println("아이디 :");
				String userid2 = scanner.next();
				System.out.println("비밀번호 :");
				String password2 = scanner.next();
				
				// service 에서 void를 String으로 바꿨기 때문에 service.login(userid2, password2); 이 아니라
				String result = service.login(userid2, password2);
				String flag = result.substring(0,5); // flag 에 result로 들어갈 문구 0부터 5칸에 해당하는값(0,1,2,3,4)을 넣는다.
				if (flag.equals("환영합니다.")) { // 서비스 임플에서 로그인 성공시 뜨는 문구에서 변수는 어떻게 올지 모르나 환영합니다는 같기 때문에...
					System.out.println(result);
					break;
				} else if(flag.equals("비번이 다")) {
					System.out.println(result);
				}
			} else {
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	}
}
