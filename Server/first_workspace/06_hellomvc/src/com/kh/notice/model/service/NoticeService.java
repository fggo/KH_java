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
    
    if(result>0)
      commit(conn);
    else
      rollback(conn);

    close(conn);
    return result;
  }
}
