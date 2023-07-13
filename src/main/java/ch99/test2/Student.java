package ch99.test2;
// 학번(sid), 이름(name)
public class Student {
	public int sid;
	public String name;
	
	public Student() { }
	public Student(int sid, String name) {
		this.sid = sid;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return this.sid;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student))
			return false;
		Student student = (Student) obj;
		return this.sid == student.sid;
	}
	
 
}
