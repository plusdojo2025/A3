package servlet;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplyDAO;
import dto.AllDTO;

/**
 * Servlet implementation class ApplyConfirm
 */
@WebServlet("/ApplyConfirmServlet")
public class ApplyConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//セッションからapply2で選択されたコースidを取得
		HttpSession session = request.getSession();
		int courseId = (Integer) session.getAttribute("courseId");
		
		//apply3で選択された式場idとオプションid、備考の取得
		String si = request.getParameter("sikijo");
		int sikijoId = Integer.parseInt(si);
			System.out.println("変換後のsId = " + sikijoId);
		String pla = request.getParameter("planner");
		int plannerId = Integer.parseInt(pla);	
			// 確認用
			System.out.println("選択された式場ID: " + sikijoId);
			System.out.println("選択されたプランナーID: " + plannerId);
		String op = request.getParameter("option");
		String re = request.getParameter("remarks");
//		int opId = Integer.parseInt(op);
		if (re == null || re.trim().isEmpty()) {
		    re = "なし";
		}
		//DAOをインスタンス化
		ApplyDAO appdao = new ApplyDAO();		
		AllDTO sikijo = appdao.getSikijo(sikijoId);
		AllDTO course = appdao.getCourseInfo(courseId);
//		AllDTO option = dao.getOption(sId);
		
		//選択されたオプション(のname属性)を取得
		String[] optionIds = request.getParameterValues("option");
		List<AllDTO> opList = new ArrayList<>();
		//オプション合計
		int opsum = 0;
		if (optionIds != null) {
			for (String oid : optionIds) {
				if (oid != null && !oid.isEmpty()) {
					int optionId = Integer.parseInt(oid);
					// DAOで取得して確認画面に渡すなど
					AllDTO opt = appdao.getOption(optionId); 
					opList.add(opt);
					opsum += Integer.parseInt(opt.getOptionPrice());
				}
			}	
		}else {
			request.setAttribute("opMsg", "未選択");
		}
			//確認用
			System.out.println("siki = " + sikijo);
		
		//全体合計
		int sum = 0;
		sum += Integer.parseInt(course.getcPrice());
		sum += Integer.parseInt(sikijo.getsPrice());
		sum += opsum;  // すでに求めたオプション合計
		
		NumberFormat formatter = NumberFormat.getNumberInstance();
		String appsum = formatter.format(sum);
			// 確認用
			System.out.println("コース金額: " + course.getcPrice());
			System.out.println("式場金額: " + sikijo.getsPrice());
			System.out.println("オプション合計: " + opsum);
			System.out.println("合計金額: " + sum);
			
		//apply3で選択された式場とコースをセッションへ
		session.setAttribute("course", course);
		session.setAttribute("sikijo", sikijo);
		session.setAttribute("plannerId", plannerId);
		session.setAttribute("options", opList);//AllDTO(jsp表示用)
		session.setAttribute("optionIds", optionIds); // ←String[] IDだけ（登録処理用）
//		session.setAttribute("opsum", opsum);
		session.setAttribute("remarks", re);
		request.setAttribute("sum", appsum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply_confirm.jsp");
		dispatcher.forward(request,response);
		
	}
}