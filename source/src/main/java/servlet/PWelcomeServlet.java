package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PidpwDAO;
import dto.AllDTO;

/**
 * Servlet implementation class PWelcomeServlet
 */
@WebServlet("/PWelcomeServlet")
public class PWelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public PWelcomeServlet() {
      //  super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//LoginUser user = (LoginUser) session.getAttribute("id");
		// ユーザ名（ID）をメニュー画面に渡す
		//request.setAttribute("username", user.getId());
		
		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pwelcome.jsp");  
		// メニューページ（menu.jsp）へのディスパッチャを取得
		dispatcher.forward(request, response);  
		// メニューページへリクエストとレスポンスを転送
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//入力値の取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		
		//daoをインスタンス化
		PidpwDAO pDao = new PidpwDAO();
		
		//daoにidとpwを渡して、返却値を取得する
		AllDTO planner = pDao.findPlannerByLogin(id , password);
		
		
		//分岐
		if(planner != null) {
		//返却値がちゃんと取ってこれたら		
			//取得した返却値（planner型のもの)をセッションにセットする
		HttpSession session = request.getSession();
		session.setAttribute("planner",planner);
		//jspで表示するためにリクエストスコープにも入れる
		request.setAttribute("planner",planner);
		
			//メニューへリダイレクト（menuservlet）※フォワードでもok
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pwelcome.jsp");
		dispatcher.forward(request, response);
		} else {
		//取ってこれなかったら
			//エラーメッセージをリクエストスコープへ格納
		request.setAttribute("errmsg","id、またはpwが違います");
			//ログインページへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/plogin.jsp");
		dispatcher.forward(request, response);
		}
	//セッションからユーザー名を取得
		
		//AllDTO planner = (AllDTO) session.getAttribute("planner");
		
		//jspに渡す
		//request.setAttribute("planner",planner);
		
		
		
	}

}
