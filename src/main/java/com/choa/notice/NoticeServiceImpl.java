package com.choa.notice;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.ListInfo;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Service
//NoticeService noticeService = new NoticeService();
public class NoticeServiceImpl implements BoardService {

	@Autowired
	private NoticeDAOImpl noticeDAO;
	
	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		int result = noticeDAO.boardCount(listInfo);
		listInfo.makePage(result);
		listInfo.makeRow();
		return noticeDAO.boardList(listInfo);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.boardView(num);
	}


	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.boardDelete(num);
	}

}
