package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		// TODO Auto-generated method stub
		
	}
	
	// リクエストパラメータを取得する
			//request.setCharacterEncoding("UTF-8");
			//String user_id = request.getParameter("user_id");
			//String id = request.getParameter("id");
			//String pw = request.getParameter("pw");
			//String f_name = request.getParameter("f_name");
			//String l_name = request.getParameter("l_name");
			//String k_f_name = request.getParameter("k_f_name");
			//String k_l_name = request.getParameter("k_l_name");
			//String birthday = request.getParameter("birthday");
			//String gender = request.getParameter("gender");
			//String zipcode = request.getParameter("zipcode");
			//String address = request.getParameter("address");
			//String email = request.getParameter("email");
			//String phone = request.getParameter("phone");


			// 登録処理を行う
			//UserDAO uDao = new UserDAO();
			//if (uDao.insert(new User(0, company, department, position, name,
					//zipcode, address, phone, fax, email, remarks))) { // 登録成功
				//request.setAttribute("result", new Result("登録成功！", "レコードを登録しました。", "/webapp/RegistServlet"));
			//} else { // 登録失敗
				//request.setAttribute("registErr","レコードを登録できませんでした。");
				//request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/webapp/RegistServlet"));
			//}

			// 結果ページにフォワードする
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			//dispatcher.forward(request, response);
		//}

}