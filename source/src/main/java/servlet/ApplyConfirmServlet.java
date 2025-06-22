package servlet;

import java.io.IOException;
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
		
		//apply3で選択された式場idとオプションidの取得
		String si = request.getParameter("sikijo");
			//System.out.println("受け取ったsikijo = " + si);  // 例: "1"
			/*
			 * //もし式場が選択されてなかったら if(si == null || si.isEmpty()) {
			 * request.setAttribute("eroorMsg", "※コースを選択してください"); // 元の画面（例: apply2.jsp）に戻す
			 * RequestDispatcher dispatcher =
			 * request.getRequestDispatcher("/WEB-INF/jsp/apply3.jsp");
			 * dispatcher.forward(request, response); return; }
			 */
		String op = request.getParameter("option");
		
		int sikijoId = Integer.parseInt(si);
			System.out.println("変換後のsId = " + sikijoId);
//		int opId = Integer.parseInt(op);
		
		//DAOをインスタンス化
		ApplyDAO appdao = new ApplyDAO();		
		AllDTO sikijo = appdao.getSiki(sikijoId);
		AllDTO course = appdao.getCourseInfo(courseId);
//		AllDTO option = dao.getOption(sId);
		
		//選択されたオプション(のname属性)を取得
		String[] optionIds = request.getParameterValues("option");
		List<AllDTO> opList = new ArrayList<>();
		
		int opsum = 0;
		if (optionIds != null) {
			for (String oid : optionIds) {
				int optionId = Integer.parseInt(oid);
				// DAOで取得して確認画面に渡すなど
				AllDTO opt = appdao.getOption(optionId); 
				opList.add(opt);
				opsum += Integer.parseInt(opt.getOptionPrice());
			}
		}else {
			request.setAttribute("opMsg", "未選択");
		}
			//確認用
			System.out.println("siki = " + sikijo);
		
		//apply3で選択された式場とコースをセッションへ
//		session.setAttribute("course", course);
		session.setAttribute("sikijo", sikijo);
		session.setAttribute("options", opList);
		session.setAttribute("opsum", opsum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply_confirm.jsp");
		dispatcher.forward(request,response);
		
		
	}
}