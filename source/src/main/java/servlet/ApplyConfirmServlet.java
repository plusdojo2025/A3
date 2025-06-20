package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplyDAO;
import dto.AllDTO;

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
		
//		HttpSession session = request.getSession();
//		AllDTO courseId =(AllDTO)session.getAttribute("courseId");
		String si = request.getParameter("sikijo");
//		String op = request.getParameter("option");
		
		int sId = Integer.parseInt(si);
		
		ApplyDAO dao = new ApplyDAO();
		AllDTO siki = dao.getSiki(sId);
		
		System.out.println("siki = " + siki);
		
		request.setAttribute("siki", siki);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply_confirm.jsp");
		dispatcher.forward(request,response);

	}
	

}