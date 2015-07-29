package util.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MemberServiceImpl implements MemberService{
	
	//Map<String, Member> map = new HashMap<String, Member>();
	//위처럼 하는것이 정석. jsp , DB 만지게 되면
	//<String, Object> 가 정석
	//하지만 이 예제서는 <String, String>으로 하겠다.
	//이유는 쉽게 하려고
	Map<String, String> map = new HashMap<String, String>();
	Member member = new Member();
	String userid, password, name, address;
	int age;
	
	@Override
	public void join(String userid, String password, String name, int age,
			String address) {
		member.setUserid(userid);
		member.setPassword(password);
		member.setName(name);
		member.setAge(age);
		member.setAddress(address);
		
		map.put("userid", member.getUserid());
		map.put("password", member.getPassword());
		map.put("name", member.getName());
		map.put("age", String.valueOf(member.getAge())); // int => String 은 String.valueOf(...) 으로
		map.put("address", member.getAddress());
	}

	@Override
	public String login(String userid, String password) {
		String msg = "";
		if (map.get("userid").equals(userid) && map.get("password").equals(password)) { // 두조건을 모두 충족
			msg = "환영합니다."+member.getAddress()+"에 사시는"
					+member.getAge()+" 세 되시는"+member.getName()+" 님";
		} else if(map.get("userid").equals(userid) && !map.get("password").equals(password)) { // 비밀번호 틀림
			msg = "비밀번호가 다릅니다. 다시 입력하세요";
		} else {
			msg = "입력하신 아이디는 존재 하지 않거나 일치하지 않습니다. 다시 입력하세요";
		}
		return msg;
		
	}
	
	

}
