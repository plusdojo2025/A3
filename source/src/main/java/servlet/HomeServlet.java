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

//↓LoginUserクラス（DTO）を使えるようにインポート
import dto.UserDTO;//○○DTOを使うための宣言

//↓このクラスを「/○○Servlet」というURLパターンで呼び出せるように登録せよ
@WebServlet("/HomeServlet")  

//↓HttpServletを継承して○○Servletクラスを定義
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// DoGetリクエストを受け取ったときの処理を定義
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException,IOException{
	
	// もしもログインしていなかったらログインサーブレットにリダイレクト
	HttpSession session = request.getSession();
	
	//セッションに"id"属性を取得してUserDTO型にキャスト
	UserDTO user = (UserDTO) session.getAttribute("id");
	
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");  
			// メニューページ（menu.jsp）へのディスパッチャを取得

			dispatcher.forward(request, response);  
			// メニューページへリクエストとレスポンスを転送

	}

}

