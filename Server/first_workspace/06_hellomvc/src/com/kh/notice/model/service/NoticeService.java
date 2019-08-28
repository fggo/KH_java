package com.kh.notice.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

import static common.template.JDBCTemplate.getConnection;
import static common.template.JDBCTemplate.close;
import static common.template.JDBCTemplate.commit;
import static common.template.JDBCTemplate.rollback;

public class NoticeService {
  private NoticeDao dao = new NoticeDao();
  
  public int selectCountNotice() {
    Connection conn = getConnection();

    int count = dao.selectCountNotice(conn);

    close(conn);

    return count;
  }

  public List<Notice> selectNoticeList(int cPage, int numPerPage){
    Connection conn = getConnection();
    List<Notice> noticeList = dao.selectNoticeList(conn, cPage, numPerPage);
    
    close(conn);

    return noticeList;
  }

  public Notice selectNoticeOne(int no) {
    Connection conn = getConnection();
    Notice n = dao.selectNoticeOne(conn, no);
    
    close(conn);

    return n;
  }
  
  public int insertNotice(Notice n){
    Connection conn = getConnection();
    int result = dao.insertNotice(conn, n);
    
    if(result>0) {
//      commit(conn);

//      for() {
//        result = dao.insertAttachment(conn, list.get(i));
//        if(result<0) break;
//      }
//      if(result<0) rollback;

      //noticeView list로 가지 않고, 수정된 화면에 머물도록 바꾸기!

      //하나의 transaction에서 nextval 된 이후에 currval select가능
      //현재 sequence 번호(PK)를 보내서 해당 notice 수정된 정보를 화면에 그대로 나타내 주도록!
      //insert된 sequence를 받아옴 (=result)
      //notice의 seq에 대한 여러가지 첨부파일들 저장할 table생성(seq를 FK로 연결)
      //하나의 트랜젝션: notice insert하고 첨부파일들을 참조테이블에 insert
      //두개의 insert 전부 result>0 일때만, commit(conn);
      commit(conn);
      result = dao.selectSeqNotice(conn); //seq는 commit과 상관 없이 update됨
    }
    else
      rollback(conn);

    close(conn);
    return result;
  }
}
