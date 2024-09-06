package mainService.Service;

import java.util.List;

import  mainService.DAO.BoardDAO;
import  mainService.DTO.Board;

/**
 * 	게시판 기능 - 비즈니스 로직 클래스
 */

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO = new BoardDAO();
	
	@Override
	public List<Board> list() {
		// 1. DAO 객체로 게시글 목록 요청하고 List<Board>
		List<Board> boardList = boardDAO.list();
		// 게시글 목록 데이터 반환
		return boardList;
	}

	@Override
	public Board select(int no) {
		// 1. 게시글 번호 no 를 DB 로 넘겨주고 게시글 정보 요청
		Board board = boardDAO.select(no);
		// 게시글 정보 반환
		return board;
	}

	@Override
	public int insert(Board board) {
		// 게시글 정보를 전달하여 DB에 데이터 등록 요청
		int result = boardDAO.insert(board);
		// 적용된 데이터 개수를 반환
		// - result(결과)		: 0 --> 데이터 등록 실패
		// - result(결과)		: 1 --> 데이터 등록 성골
		if(result>0)System.out.println("DB_insert 성공 : BoardServiceImpl");
		else System.err.println("DB_insert 실패 : BoardServiceImpl");
		return result;
	}

	@Override
	public int update(Board board) {
		int result = boardDAO.update(board);
		// 적용된 데이터 개수를 반환
		// - result(결과)		: 0 --> 데이터 등록 실패
		// - result(결과)		: 1 --> 데이터 등록 성골
		if(result>0)System.out.println("DB_update 성공 : BoardServiceImpl");
		else System.err.println("DB_update 실패 : BoardServiceImpl");
		return result;
	}

	@Override
	public int delete(int no) {
		int result = boardDAO.delete(no);
		// 적용된 데이터 개수를 반환
		// - result(결과)		: 0 --> 데이터 등록 실패
		// - result(결과)		: 1 --> 데이터 등록 성골
		if(result>0)System.out.println("DB_delete 성공 : BoardServiceImpl");
		else System.err.println("DB_delete 실패 : BoardServiceImpl");
		return result;
	}

	@Override
	public void view_update(Board currentboard) {
		// TODO Auto-generated method stub
		int result = boardDAO.view_update(currentboard);
		// 적용된 데이터 개수를 반환
		// - result(결과)		: 0 --> 데이터 등록 실패
		// - result(결과)		: 1 --> 데이터 등록 성골
		if(result>0)System.out.println("DB_update 성공 : BoardServiceImpl");
		else System.err.println("DB_update 실패 : BoardServiceImpl");
		
	}

}
