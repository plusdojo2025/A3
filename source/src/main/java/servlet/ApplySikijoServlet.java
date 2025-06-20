package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplyDAO;
import dto.AllDTO;
import dto.ApplyDTO;

/**
 * Servlet implementation class ApplySikijoServlet
 */
@WebServlet("/ApplySikijoServlet")
public class ApplySikijoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String co = request.getParameter("course");	
		int courseId = Integer.parseInt(co);
		
		HttpSession session = request.getSession();	

		AllDTO user =(AllDTO)session.getAttribute("user");
//		int userId =user.getUserId();
		int userId =3;
		//DAOインスタンス化
		ApplyDAO dao = new ApplyDAO();
		List<ApplyDTO> sikijoList = dao.course(courseId,userId);
		ArrayList<Integer> idList = new ArrayList<>();
		for(ApplyDTO sid : sikijoList) {
			idList.add(sid.getSikijoId());
		}
		
		ArrayList<AllDTO> sList = new ArrayList<>(); 
		for(int id :idList) {
			sList.add(dao.getSikijo(id));
		}
		//コースのオプションを取得
		List<AllDTO> optionList =dao.getCourse(courseId);
		request.setAttribute("optionList", optionList);
		//JSPに渡す
		request.setAttribute("sikijoList", sList);

		session.setAttribute("courseId", courseId);	
		
		// フォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply3.jsp");
		dispatcher.forward(request, response);
	}



}
