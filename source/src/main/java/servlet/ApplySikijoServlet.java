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

/**
 * Servlet implementation class ApplySikijoServlet
 */
@WebServlet("/ApplySikijoServlet")
public class ApplySikijoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//選択されたコースを取得
		String co = request.getParameter("course");	
			//もしコースが選択されてなかったら
//			if(co == null || co.isEmpty()) {
//				request.setAttribute("eroorMsg", "※コースを選択してください");
//				// 元の画面（例: apply2.jsp）に戻す
//		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply2.jsp");
//		        dispatcher.forward(request, response);
//		        return;
//			}
		int courseId = Integer.parseInt(co);
		
		HttpSession session = request.getSession();	
		session.setAttribute("courseId",courseId); //選択されたcourseidをセッションへ
		AllDTO user =(AllDTO)session.getAttribute("user"); //セッションにあるユーザー情報を取得
		int userId =user.getUserId();
		//int userId =3; //仮のid、本来ver.に戻したらDAOのuserId使ってる部分の変更あり
		
		//DAOインスタンス化
		ApplyDAO dao = new ApplyDAO();
		//選択されたコースに対応する式場を持ってくる（先生が書いてくれた）
		List<AllDTO> sikijoList = dao.course(courseId,userId);
		ArrayList<Integer> idList = new ArrayList<>();
		for(AllDTO sid : sikijoList) {
			idList.add(sid.getSikijoId());
		}
		ArrayList<AllDTO> sList = new ArrayList<>(); 
		for(int id :idList) {
			 AllDTO siki = dao.getSikijo(id); // getSikijoメソッドの中でPlannerも取れるようにしておく
			sList.add(siki);
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
