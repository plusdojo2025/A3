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
		
		request.setCharacterEncoding("UTF-8");
		String co = request.getParameter("course");	
		int courseId = Integer.parseInt(co);
		
		HttpSession session = request.getSession();	
		session.setAttribute("courseId",courseId); //選択されたcourseidをセッションへ
		AllDTO user =(AllDTO)session.getAttribute("user"); //セッションにあるユーザー情報を取得
//		int userId =user.getUserId();
		int userId =3; //仮のid、本来ver.に戻したらDAOのuserId使ってる部分の変更あり
		
		//DAOインスタンス化
		ApplyDAO dao = new ApplyDAO();
		//選択されたコースに対応する式場を持ってくる（先生が書いてくれた）
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

		//apply3へフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply3.jsp");
		dispatcher.forward(request, response);
	}



}
