package servlet;

import java.io.IOException;
import java.util.List;//追加

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlannerDAO;//追加
import dto.PlannerDTO;//追加

/**
 * Servlet implementation class PMypServlet
 */
@WebServlet("/PMypServlet")
public class PMypServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PMypServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PMypServlet起動したよ！");
		PlannerDAO dao = new PlannerDAO();
		List<PlannerDTO>plannerList = dao.select();
		request.setAttribute("plannerList", plannerList);
		System.out.println(plannerList.size());
		//プランナーページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pmyp.jsp");
		// プランナーマイページ（pmyp.jsp）へのディスパッチャを取得
		dispatcher.forward(request, response);
		// プランナーマイページへリクエストとレスポンスを転送
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
