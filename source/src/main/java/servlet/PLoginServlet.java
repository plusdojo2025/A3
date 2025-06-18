package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PidpwDAO;
import dto.AllDTO;

/**
 * Servlet implementation class PLoginServlet
 */
@WebServlet("/PLoginServlet")
public class PLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public PLoginServlet() {
      //  super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/plogin.jsp");  
		// メニューページ（menu.jsp）へのディスパッチャを取得
		dispatcher.forward(request, response);  
		// メニューページへリクエストとレスポンスを転送
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");//idをjspで書かないとString""=となる　nullではない
		String pw = request.getParameter("pw");
		
		PidpwDAO pDao = new PidpwDAO();
		AllDTO planner = pDao.findPlannerByLogin(id, pw);
		if (planner != null) { // ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("loginPlanner",planner);

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/webapp/PWelcomeServlet");
		} else { // ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("errorMsg", "IDまたはPWに間違いがあります。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/plogin.jsp");
			dispatcher.forward(request, response);//再度ログイン画面へ
		}
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
