package ch99;
//실행결과
//Oracle DB에서 검색
//Oracle DB에 삽입
//Oracle DB를 수정
//Oracle DB에서 삭제
public class OracleDaoImpl implements DataAccessObject{
	@Override
	public void select() {
		System.out.println("Oravle DB에서 검색");
	}
	@Override
	public void insert() {
		System.out.println("Oravle DB에서 삽입");
	}
	@Override
	public void update() {
		System.out.println("Oravle DB에서 수정");
	}
	@Override
	public void delete() {
		System.out.println("Oravle DB에서 삭제");
	}

}
