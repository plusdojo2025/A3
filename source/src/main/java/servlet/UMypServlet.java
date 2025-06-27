package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dto.AllDTO;

/**
 * Servlet implementation class UMypServlet
 */
@WebServlet("/UMypServlet")
public class UMypServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UMypServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    	
    	// もしもログインしていなかったらログインサーブレットにリダイレクトする
    			HttpSession session = request.getSession();
    			//ユーザー情報をとってきてないってことはログインしてない状態
    			if (session.getAttribute("user") == null) {
    				response.sendRedirect("LoginServlet");
    				return;
    			}
    	
    	
    	
    	
		UserDAO dao = new UserDAO();
		AllDTO searchUser = new AllDTO();
		searchUser.setfName("");
		searchUser.setlName("");

		List<AllDTO> cardList = dao.searchByFullName(searchUser);
		
		
		request.setAttribute("cardList", cardList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/umyp.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		String fName = request.getParameter("f_name");
		String lName = request.getParameter("l_name");
		
		//daoをインスタンス化
		UserDAO uDao = new UserDAO();
		
		//daoにidとpwを渡して、返却値を取得する
		AllDTO user = uDao.findExactUser(fName,lName);
		
		
		//分岐
		if(user != null) {
		//返却値がちゃんと取ってこれたら		
			//取得した返却値（planner型のもの)をセッションにセットする
		HttpSession session = request.getSession();
		session.setAttribute("user",user);
		//jspで表示するためにリクエストスコープにも入れる
		request.setAttribute("user",user);
		
	}
	}
}
