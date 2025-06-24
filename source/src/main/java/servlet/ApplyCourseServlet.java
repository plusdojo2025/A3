package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplyDAO;
import dao.CourseDAO;
import dto.AllDTO;
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
		//セッション取得
		HttpSession session = request.getSession();
		
//<<<<<<< HEAD
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		AllDTO user = (AllDTO) session.getAttribute("user");

		if (user == null) {
		    response.sendRedirect(request.getContextPath() + "/LoginServlet");
		    return;
		}

		int userId = user.getUserId();
		
//		int userId =user.getUserId();
//		int userId =3; //仮のid、本来ver.に戻したらDAOのuserId使ってる部分の変更あり
//=======
//		AllDTO user =(AllDTO)session.getAttribute("user");
//		int userId =user.getUserId();
		//int userId =3; //仮のid、本来ver.に戻したらDAOのuserId使ってる部分の変更あり
//>>>>>>> a70af932f0e6fc7915df7aa0b16781f6e29ee6b0

		ApplyDAO appdao = new ApplyDAO();
		
		// 申し込み済みかチェック（例：すでに1件以上 apply に存在する）
	    boolean isApplied = appdao.Applied(userId);

//		List<AllDTO> applyList  = appdao.applyComp(userId);
//		request.setAttribute("appList", applyList);
		
		if (isApplied) {
	        // すでに申し込み済み → 確認画面へ
			 System.out.println("申し込み済みのため、ApplyCompServletへリダイレクトします");
	        response.sendRedirect(request.getContextPath() + "/ApplyCompServlet");
	        return;
	    } 
		else {
	        // 未申し込み → 申し込み画面へ
	        //コース表示
			CourseDAO coudao = new CourseDAO();		
			List<CourseDTO>courseList = coudao.select();
			//JSPに渡す
			request.setAttribute("courseList", courseList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply2.jsp");
			dispatcher.forward(request, response);	
	    }
		
		
			
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