//↓servletパッケージに属するクラスとして定義
package servlet;
//↓JavaのIOExceptionクラスを使えるようにインポート
import java.io.IOException;

import javax.servlet.RequestDispatcher;
//↓ServletExceptionクラスを使えるようにインポート
import javax.servlet.ServletException;
//↓@WebServletアノテーションを使えるようにインポート
import javax.servlet.annotation.WebServlet;
//↓HttpServletクラスを継承できるようにインポート
import javax.servlet.http.HttpServlet;
//↓クライアントからのリクエスト情報を扱えるようにする
import javax.servlet.http.HttpServletRequest;
//↓クライアントへのレスポンス情報を扱えるようにする
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UidpwDAO;
import dto.AllDTO;

//↓このクラスを「/○○Servlet」というURLパターンで呼び出せるように登録せよ
@WebServlet("/HomeServlet")  

//↓HttpServletを継承して○○Servletクラスを定義
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// DoGetリクエストを受け取ったときの処理を定義
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException,IOException{
	
	// もしもログインしていなかったらログインサーブレットにリダイレクト
	//HttpSession session = request.getSession();
	
	//セッションに"id"属性を取得してUserDTO型にキャスト
	//UserDTO user = (UserDTO) session.getAttribute("id");
	
	//セッションから"id"が存在しない場合の条件をチェック
	//if(session.getAttribute("id") == null) {
		
		//ログインしていない場合はLoginServletにリダイレクト
		//response.sendRedirect("/A3/HomeServlet");

		
//	
//		return;
//	}
	// ユーザ名（ID）をメニュー画面に渡す
			//request.setAttribute("username", user.getId());  
			// リクエストスコープにユーザーIDを"username"という名前で保存

			// メニューページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");  
			// メニューページ（menu.jsp）へのディスパッチャを取得

			dispatcher.forward(request, response);  
			// メニューページへリクエストとレスポンスを転送

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UidpwDAO uDao = new UidpwDAO();
		
		AllDTO user = uDao.findUserByLogin(id, pw);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("errMsg","ID,PWが違います");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		// もしもログインしていなかったらログインサーブレットにリダイレクト
		//HttpSession session = request.getSession();
		
		//セッションに"id"属性を取得してUserDTO型にキャスト
		//UserDTO user = (UserDTO) session.getAttribute("id");
		
		//セッションから"id"が存在しない場合の条件をチェック
		//if(session.getAttribute("id") == null) {
			
			//ログインしていない場合はLoginServletにリダイレクト
			//response.sendRedirect("/A3/HomeServlet");

			
	//	
//			return;
//		}
		// ユーザ名（ID）をメニュー画面に渡す
				//request.setAttribute("username", user.getId());  
				// リクエストスコープにユーザーIDを"username"という名前で保存

				// メニューページにフォワードする
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");  
				// メニューページ（menu.jsp）へのディスパッチャを取得

				//dispatcher.forward(request, response);  
				// メニューページへリクエストとレスポンスを転送

		}

}

