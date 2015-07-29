package util.hashmap;

public interface MemberService {
	public void join(String userid, String password, String name, int age, String address);
	
	public String login(String userid, String password);
	// 리턴값으로 메세지(로그인성공,실패) 라는 리턴값을 주기위해 void 를 String 으로 준다
}
