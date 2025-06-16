 package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				String k_f_name= request.getParameter("k_f_name");
				String k_l_name= request.getParameter("k_l_name");
				String address = request.getParameter("adress");
				String phone = request.getParameter("phone");
		
				
				// 検索処理を行う
				//BcDAO bDao = new BcDAO();
				//List<Bc> cardList = bDao.select(new Bc(k_f_name,k_l_name,address,phone));
	}
	
	
	

}
