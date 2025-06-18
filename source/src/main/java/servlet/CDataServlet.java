 package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class CDataServlet
 */
@WebServlet("/CDataServlet")
public class CDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public CDataServlet() {
      //  super();
        // TODO Auto-generated constructor stub
   // }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cdata.jsp");  
		// メニューページ（menu.jsp）へのディスパッチャを取得
		dispatcher.forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String fullName= request.getParameter("fullName");
				String fName= request.getParameter("fName");
				String lName= request.getParameter("lName");
				String gender= request.getParameter("gender");
				String address = request.getParameter("adress");
				String phone = request.getParameter("phone");
		
				UserDAO bDao = new UserDAO();
				List<User> cardList = UserDAO.select(new User(fName,lName,gender,"",phone));
				
				request.setAttribute("cardList", cardList);
				// 検索処理を行う
				//BcDAO bDao = new BcDAO();
				//List<Bc> cardList = bDao.select(new Bc(k_f_name,k_l_name,address,phone));
				//jspに処理を飛ばして
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cdata.jsp");
				dispatcher.forward(request, response);
	}
	
	
	
	

}
