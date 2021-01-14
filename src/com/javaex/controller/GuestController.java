package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestVo;

@WebServlet("/gbc")
public class GuestController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("controller");

		// 파라미터 action값 읽기
		String action = request.getParameter("action");

		if ("list".equals(action)) {
			System.out.println("리스트 처리");

			// 리스트 출력 처리
			GuestDao guestDao = new GuestDao();
			List<GuestVo> guestList = guestDao.getGuestList();

			// System.out.println(guestList.toString()); 테스트

			// 데이터 전달
			request.setAttribute("gList", guestList);

			// jsp에 포워드
			// RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/list.jsp");
			// //jsp파일 위치
			// rd.forward(request, response);

			WebUtil.forward(request, response, "./WEB-INF/list.jsp");

		} else if ("insert".equals(action)) {
			System.out.println("등록하기");

			// 파라미터 값
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");

			// guestVo 묶기
			GuestVo guestVo = new GuestVo(name, password, content);

			// new dao --> 저장
			GuestDao guestDao = new GuestDao();
			guestDao.guestInsert(guestVo);

			// 리다이렉트
			// response.sendRedirect("/guestbook2/gbc?action=list");

			WebUtil.redirect(request, response, "/guestbook2/gbc?action=list");

		} else if ("delform".equals(action)) {
			System.out.println("삭제폼");

			// jsp에 포워드
			// RequestDispatcher rd =
			// request.getRequestDispatcher("./WEB-INF/deleteForm.jsp"); //jsp파일 위치
			// rd.forward(request, response);

			WebUtil.forward(request, response, "./WEB-INF/deleteForm.jsp");

		} else if ("delete".equals(action)) {
			System.out.println("삭제");

			// no, password 일치하면 삭제/ no,password 파라미터값 읽기
			int no = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");

			// vo에 담기
			GuestVo guestVo = new GuestVo(no, password);

			// dao -> 삭제
			GuestDao guestDao = new GuestDao();
			int count = guestDao.guestDelete(guestVo);

			// 리다이렉트
			// response.sendRedirect("/guestbook2/gbc?action=list");

			// 리턴값이 1이면 삭제, 0이면 삭제안함 추가
			if (count == 1) {
				// response.sendRedirect("/guestbook2/gbc?action=list");
				WebUtil.redirect(request, response, "/guestbook2/gbc?action=list");
				// 삭제됐습니다. <br>
				// <a href="./addList.jsp">처음으로 이동</a>
			} else if (count == 0) {
				System.out.println("삭제실패");
				// 데이터 전달
				request.setAttribute("no", no);

				// jsp에 포워드
				// RequestDispatcher rd =
				// request.getRequestDispatcher("./WEB-INF/deleteForm.jsp"); //jsp파일 위치
				// rd.forward(request, response);
				WebUtil.forward(request, response, "./WEB-INF/deleteForm.jsp");

			}

		} else {
			//기본값을 리스트로
			System.out.println("기본값  리스트 처리");
			
			//리스트 가져오기
			GuestDao guestDao = new GuestDao(); 
			List<GuestVo> guestList = guestDao.getGuestList();
			
			//데이터 담기
			request.setAttribute("gList", guestList);
			
			//포워드
			WebUtil.forward(request, response, "./WEB-INF/list.jsp");
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doGet(request, response);
	}

}
