package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlannerDAO;
import dto.PlannerDTO;


/**
 * Servlet implementation class PlannerServlet
 */
@WebServlet("/PlannerServlet")
public class PlannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlannerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str = request.getParameter("sikijo_id");
		int sikijoId = Integer.parseInt(str);
		 
		
		//DAOのインスタンス化
		PlannerDAO dao = new PlannerDAO();
		List<PlannerDTO>plannerList = dao.select(sikijoId);
		
		//JSPに渡す
		request.setAttribute("plannerList", plannerList);
		//request.setAttribute("sikijoName", sikijoName);
		// プランナーページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/planner.jsp");  
		// ディスパッチャを取得

		dispatcher.forward(request, response);  
		// メニューページへリクエストとレスポンスを転送
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
