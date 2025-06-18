package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplyConfirm
 */
@WebServlet("/ApplyConfirmServlet")
public class ApplyConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String course = request.getParameter("course");
//		String option = request.getParameter("option");
//		String sikijo = request.getParameter("sikijo");
//		String planner = request.getParameter("planner");
//		
//		if (course.equals("Acourse") != false) {
//	        request.setAttribute("course", "Aコース");
//	    } else if (course.equals("Bcourse") != false) {
//	        request.setAttribute("course", "Bコース");
//	    } else if (course.equals("Ccourse") != false) {
//	        request.setAttribute("course", "Cコース");
//	    }
//		
////		request.setAttribute("course", course);
//		request.setAttribute("option", option);
//		request.setAttribute("sikijo", sikijo);
//		request.setAttribute("planner", planner);
//		//		common(request,response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply_confirm.jsp");
		dispatcher.forward(request,response);
		
	}
	
}