package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
	 * public RegistServlet() { super(); // TODO Auto-generated constructor stub }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// メニューページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");  
					// メニューページ（menu.jsp）へのディスパッチャを取得

					dispatcher.forward(request, response);  
					// メニューページへリクエストとレスポンスを転送
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("✅ doPost() called");
		// TODO Auto-generated method stub
		
	// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String fName = request.getParameter("fName");
			String lName = request.getParameter("lName");
			String kfName = request.getParameter("kfName");
			String klName = request.getParameter("klName");
			String birthday = request.getParameter("birthday");
			String gender = request.getParameter("gender");
			String zipcode = request.getParameter("zipcode");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");


			// 登録処理を行う
			UserDAO uDao = new UserDAO();
			
			 boolean success = uDao.insert(id, pw, fName, lName, kfName, klName, birthday,
			 gender, zipcode, address, email, phone); if(success) {
			 request.setAttribute("message", "ユーザー登録が完了しました。ログインしてください。");
			 RequestDispatcher dispatcher =
			 request.getRequestDispatcher("/WEB-INF/jsp/login.Servlet");
			 dispatcher.forward(request, response); } else { // 登録失敗時、エラーメッセージを設定して戻る
			 request.setAttribute("error", "ユーザー登録に失敗しました。入力内容を確認してください。");
			 RequestDispatcher dispatcher =
			 request.getRequestDispatcher("/WEB-INF/jsp/regist.Servlet");
			 dispatcher.forward(request, response); }
			 

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

}