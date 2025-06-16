package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplyServlet
 */
@WebServlet("/ApplyServlet")
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//申し込みページ（apply.jsp）へのディスパッチャを取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply.jsp");
		//申し込みページへリクエストとレスポンスを転送
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//オプション選択
		String option = request.getParameter("option");
		//式場選択
		String sikijo = request.getParameter("sikijo");
		//プランナー選択
		String planner = request.getParameter("planner");
		
		request.setAttribute("option", option);
		 if (option.equals("tuna") != false) {
		      request.setAttribute("option", "マグロ入刀");
		    } 
		 	else if (option.equals("osake") != false) {
		      request.setAttribute("option", "鏡抜き");
		    }
		 	else if (option.equals("omochi") != false) {
		      request.setAttribute("option", "鏡開き");
		    }
				
		request.setAttribute("sikijo", sikijo);
			if (sikijo.equals("tom") != false) {
				request.setAttribute("sikijo", "トム・クルージョン");
			}
			else if(sikijo.equals("d4c") != false) {
				request.setAttribute("sikijo", "D4C館");
			}
			else if(sikijo.equals("brother") != false) {
				request.setAttribute("sikijo", "ドウェイン・ブラザー");
			}
			else if(sikijo.equals("ema") != false) {
				request.setAttribute("sikijo", "エマ・ワトシン");
			}
			
		request.setAttribute("planner", planner);
			if (sikijo.equals("katasa") != false) {
				request.setAttribute("planner", "①麺乃　片佐");
			}
			else if(sikijo.equals("raoome") != false) {
				request.setAttribute("planner", "②阿武　羅多芽");
			}
			else if(sikijo.equals("koime") != false) {
				request.setAttribute("planner", "③安治　鯉女");
			}
			else if(sikijo.equals("no") != false) {
				request.setAttribute("planner", "④選択しない");
			}
		
			
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply_confirm.jsp");
		dispatcher.forward(request, response);			
			
			
	}

}
