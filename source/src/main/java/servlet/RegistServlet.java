package servlet;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;
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
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// メニューページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");  
					// メニューページ（menu.jsp）へのディスパッチャを取得

					dispatcher.forward(request, response);  
					// メニューページへリクエストとレスポンスを転送
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String f_name = request.getParameter("f_name");
			String l_name = request.getParameter("l_name");
			String k_f_name = request.getParameter("k_f_name");
			String k_l_name = request.getParameter("k_l_name");
			String birthday = request.getParameter("birthday");
			String gender = request.getParameter("gender");
			String zipcode = request.getParameter("zipcode");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");


			// 登録処理を行う
			UserDAO uDao = new UserDAO();
			if (uDao.insert(new User(id, pw, f_name, l_name, k_f_name, k_l_name, birthday, gender, zipcode, address, email, phone))) { // 登録成功
				request.setAttribute("result", new Result("/A3/RegistServlet"));
			} 

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}