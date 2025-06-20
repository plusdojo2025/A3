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
import dto.AllDTO;
/**
 * Servlet implementation class CDataServlet
 */
@WebServlet("/CDataServlet")
public class CDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cdata.jsp");  
		// メニューページ（menu.jsp）へのディスパッチャを取得
		//dispatcher.forward(request, response); 
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String fullName= request.getParameter("fullName");
		String fName= request.getParameter("fName");
		String lName= request.getParameter("lName");
		String gender= request.getParameter("gender");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		
		 
		//fullNameがnullでなく空
		if (fullName != null && !fullName.isEmpty()) {
		    if (fullName.contains(" ")) { // 半角スペース区切り
		    String[] parts = fullName.split(" "); // スペースで分割して
		    fName = parts[0];// 最初の部分を「名字」として扱う
		    lName = parts.length > 1 ? parts[1] : "";// 2つ目があれば「名前」、なければ空文字
		  } else if (fullName.length() >= 2) { // 例：「山田太郎」→ 山田＋太郎に分ける
		   fName = fullName.substring(0, 2);// 最初の2文字を「名字」
		   lName = fullName.substring(2); // それ以降を「名前」
		  }else {
//		        fName = fullName;
//		        lName = fullName;
		    
		    }
		}
		
		//DAOをdaoとしてインスタンス化して持ってきてる
		UserDAO dao = new UserDAO();
		//DTOをsearchUserとしてインスタンス化して持ってきてfullNameの値取得
		AllDTO searchUser = new AllDTO();
		searchUser.setfName(fullName);
		searchUser.setlName(lName);

		List<AllDTO> cardList = dao.searchByFullName(searchUser);
		
		request.setAttribute("cardList", cardList);
		// 検索処理を行う
		//BcDAO bDao = new BcDAO();
		//List<Bc> cardList = bDao.select(new Bc(k_f_name,k_l_name,address,phone));
		//jspに処理を飛ばして
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cdata.jsp");
		dispatcher.forward(request, response);
		
	}

	/**a
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("通ったよ～～");
		UserDAO dao = new UserDAO();
		AllDTO searchUser = new AllDTO();
		searchUser.setfName("");
		searchUser.setlName("");

		List<AllDTO> cardList = dao.searchByFullName(searchUser);
		
		request.setAttribute("cardList", cardList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cdata.jsp");
		dispatcher.forward(request, response);
		
		
	}
}
	
	
	


