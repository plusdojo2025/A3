package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SikijoDAO;
import dto.SikijoDTO;

/**
 * Servlet implementation class SikijoServlet
 */
@WebServlet("/SikijoServlet")
public class SikijoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str = request.getParameter("course_id");	
		int courseId = Integer.parseInt(str);
		//DAOインスタンス化
		SikijoDAO dao = new SikijoDAO();
		List<SikijoDTO> sikijolist = dao.select(courseId); 
		//JSPに渡す
		request.setAttribute("sikijoList", sikijolist);
		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sikijo.jsp");  
		// メニューページ（menu.jsp）へのディスパッチャを取得

		dispatcher.forward(request, response);  
		// メニューページへリクエストとレスポンスを転送
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
