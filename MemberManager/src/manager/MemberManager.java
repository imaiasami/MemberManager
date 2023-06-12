package manager;

import java.util.*;
import vo.Member;

public class MemberManager {
	private List<Member> members;
	
	public MemberManager () {
		members = new ArrayList<>();
	}
	
	// 회원정보 추가
	public boolean saveMember(Member member) {
		return members.add(member);
	}
	
	// 회원정보 검색
	public Member findMember(Long id) {
		for (int i =0; i < members.size(); i++) {
			if (members.get(i).getId() == id) {
				return members.get(i);
			}
		}
		return null;
	}
	
	// 회원정보 삭제
	public boolean removeMember(Long id) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getId() == id) {
//				members.remove(i);							// member 타입으로 리턴
//				return true;								// 바로 리턴해줘야 한다. 아니면 오류남.
				return members.remove(members.get(i));		// boolean 타입으로 리턴, 삭제 성공하면 true가 리턴된다.
			}
		}
		return false;
	}
	
	// 회원정보 전체 출력			// 완성!!
	public List<Member> getAllMembers() {
		return members;
	}

}
