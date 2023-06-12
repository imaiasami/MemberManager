package vo;

public class Member {
	private long id;					// 아이디
	private String name;				// 이름
	private int age;					// 나이
	
	
	public Member(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {				// 프린트를 하기위해 필요하다.
		return "Member [아이디 = " + id + ", 이름 = " + name + ", 나이 = " + age + "]";
	}


}
