package ch99.test2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//HashSet에 Student 객체를 저장하려고 합니다. Student 객체의 필드는 학번(sid), 이름(name) 이다. 
//학번이 같으면 동일한 Student라고 가정하고 중복 저장이 되지 않도록 하고 싶습니다. 
//1. Student 클래스에서 재정의해야 하는 hashCode( )와 equals( ) 메소드를 작성하여 Student 클래스를 만드세요.(30)
//
//2. Student 객체를 3개 만들어 HashSet에 넣고, 이를 출력하는 Main 클래스를 만드세요.(20)

public class Test2 {

	public static void main(String[] args) {
			Set<Student> set = new HashSet<>();
			
			set.add(new Student(1,"최가람"));
			set.add(new Student(2,"김철기"));
			set.add(new Student(3,"김기철"));
			
			Iterator<Student> iterator = set.iterator();
			while(iterator.hasNext()) {
				Student student = iterator.next();
				System.out.println(student.sid + ":" + student.name);
				
			}
			
	}

}
