package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UidpwDAO;
import dto.LoginUser;
import dto.Uidpw;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public LoginServlet() {
      //  super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");  
		// メニューページ（login.jsp）へのディスパッチャを取得
		dispatcher.forward(request, response);  
		// メニューページへリクエストとレスポンスを転送
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// リクエストパラメーターを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");//idをjspで書かないとString""=となる　nullではない
		String pw = request.getParameter("pw");
		
		UidpwDAO uDao = new UidpwDAO();
		String name = uDao.isLoginOK(new Uidpw(id, pw));
		if (name != null) { // ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", new LoginUser(id,name));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/webapp/HomeServlet");
		} else { // ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("errorMsg", "IDまたはPWに間違いがあります。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);//再度ログイン画面へ
		}

	}
}
