package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AllDTO;

/**
 * Servlet implementation class ApplyCompServlet
 */
@WebServlet("/ApplyCompServlet")
public class ApplyCompServlet extends HttpServlet {
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
		
		//セッションからapply2,3で選択されたコース、式場、オプションidを取得
		HttpSession session = request.getSession();
		AllDTO user =(AllDTO)session.getAttribute("user");
//		int userId =user.getUserId();
		int userId =3; //仮のid、本来ver.に戻したらDAOのuserId使ってる部分の変更あり
		int courseId = (Integer) session.getAttribute("courseId");
		int sikijoId = (Integer) session.getAttribute("sikijo");
		String[] optionIds = (String[]) session.getAttribute("options");
		List<Integer> opIds = new ArrayList<>();
		if (optionIds != null) {
		    for (String idStr : optionIds) {
		        opIds.add(Integer.parseInt(idStr));
		    }
		}
//		int opsum = (Integer) session.setAttribute("opsum", opsum);
		
	
		
		
	}

}
