package ui;

import java.util.*;

import manager.MemberManager;
import vo.Member;
import vo.idGenerator;

public class MemberUI {
	private Scanner scanner = new Scanner(System.in);
	private MemberManager manager = new MemberManager();
	
	public MemberUI () {
		while (true) {
				mainMenu();
				int input = scanner.nextInt();
				switch (input) {
						case 1: addMember(); break;
						case 2: searchMember();	break;
						case 3: updateMember();	break;
						case 4: removeMember();	break;
						case 5: showAllMembers(); break;
						case 6: System.exit(0); break;
						default: System.out.println("잘못 입력 했습니다.");
					}
			}
	}

		private void addMember() {
			System.out.print("이름 : ");
			String name = scanner.next();
			System.out.print("나이 : ");
			int age = scanner.nextInt();
			
			Member member = new Member(idGenerator.generateId(), name);
			member.setAge(age);
			if (manager.saveMember(member)) {
				System.out.println("회원등록 성공");
			} else {
				System.out.println("회원 등록 실패");
			}
}
		
		private void searchMember() {
			System.out.print("검색할 아이디 : ");
			long id = scanner.nextLong();
			Member findMember = manager.findMember(id);
			if (findMember != null) {
				System.out.println(findMember);
			} else {
				System.out.println("검색 결과가 없습니다.");
			}
			
		}
		
		private void updateMember() {
			System.out.print("수정할 아이디 : ");
			long id = scanner.nextLong();
			Member findMember = manager.findMember(id);
			if (findMember != null) {
				System.out.print("검색결과 : " + findMember);
				System.out.print("수정할 이름 : ");
				String name = scanner.next();
				System.out.print("수정할 나이 : ");
				int age = scanner.nextInt();
				
				findMember.setName(name);
				findMember.setAge(age);
				
				System.out.println("수정 성공");
			} else {
				System.out.println("수정할 대상을 찾지 못했습니다.");
			}
			
		}
	
		private void removeMember() {
			System.out.print("삭제할 아이디 : ");
			long id = scanner.nextLong();
			if (manager.removeMember(id)) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
		}

		private void showAllMembers() {
			List<Member> result = manager.getAllMembers();
			if (result != null && result.size() > 0) {
				for (int i = 0; i < result.size(); i++) {
					System.out.println(result.get(i));
			}
		}
}
		
		// 메인메뉴
		public void mainMenu() {
			System.out.println(" [ 회원정보 관리 ] ");
			System.out.println("1.회원정보 추가");
			System.out.println("2.회원정보 검색");
			System.out.println("3.회원정보 수정");
			System.out.println("4.회원정보 삭제");
			System.out.println("5.회원정보 전체 출력");
			System.out.println("6.프로그램 종료");
			System.out.print("선택> ");
		}

}
