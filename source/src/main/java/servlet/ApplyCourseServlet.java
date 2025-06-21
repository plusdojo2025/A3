package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dto.CourseDTO;

/**
 * Servlet implementation class ApplyServlet
 */
@WebServlet("/ApplyCourseServlet")
public class ApplyCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseDAO coudao = new CourseDAO();		
		List<CourseDTO>courseList = coudao.select();
		//JSPに渡す
		request.setAttribute("courseList", courseList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply2.jsp");
		dispatcher.forward(request, response);		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		//apply2.jspのデータを取得
//		request.setCharacterEncoding("UTF-8");
//		String course = request.getParameter("course");
//		
//		//aply3.jspへ
//		request.setAttribute("course", course);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply3.jsp");
//		dispatcher.forward(request, response);		
		
	}

	
}
