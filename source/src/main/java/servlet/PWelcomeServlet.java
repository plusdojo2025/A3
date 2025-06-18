package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AllDTO;

/**
 * Servlet implementation class PWelcomeServlet
 */
@WebServlet("/PWelcomeServlet")
public class PWelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public PWelcomeServlet() {
      //  super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//LoginUser user = (LoginUser) session.getAttribute("id");
		// ユーザ名（ID）をメニュー画面に渡す
		//request.setAttribute("username", user.getId());
		
		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pwelcome.jsp");  
		// メニューページ（menu.jsp）へのディスパッチャを取得
		dispatcher.forward(request, response);  
		// メニューページへリクエストとレスポンスを転送
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	//セッションからユーザー名を取得
		HttpSession session = request.getSession();
		AllDTO planner = (AllDTO) session.getAttribute("planner");
		
		//jspに渡す
		request.setAttribute("planner",planner);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pwelcome.jsp");
		dispatcher.forward(request, response);
		
	}

}
