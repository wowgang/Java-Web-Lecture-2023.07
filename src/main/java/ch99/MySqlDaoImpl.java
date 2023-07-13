package ch99;
//	실행결과
//MySQL DB에서 검색
//MySQL DB에 삽입
//MySQL DB를 수정
//MySQL DB에서 삭제
public class MySqlDaoImpl implements DataAccessObject {
	
	@Override
	public void select() {
		System.out.println("MySQL DB에서 검색");
	}
	@Override
	public void insert() {
		System.out.println("MySQL DB에서 삽입");
	}
	@Override
	public void update() {
		System.out.println("MySQL DB에서 수정");
	}
	@Override
	public void delete() {
		System.out.println("MySQL DB에서 삭제");
	}
	
	

}
