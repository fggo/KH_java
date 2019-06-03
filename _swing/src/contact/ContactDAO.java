package contact;

import java.util.ArrayList;

public interface ContactDAO {

	// 연락처 등록
	public abstract int insert(ContactVO vo);

	// 연락처 전체 검색
	public abstract ArrayList<ContactVO> select();

	// 연락처 인덱스 검색
	public abstract ContactVO select(int menuNo);

	// 연락처 수정 - 이름, 전화번호, 이메일
	public abstract int update(int menuNo, ContactVO vo);

	// 연락처 삭제
	public abstract int delete(int menuNo);

} // end interface ContactDAO 