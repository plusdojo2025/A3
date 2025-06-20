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
			System.out.println("受け取ったsikijo = " + si);  // 例: "1"
		String op = request.getParameter("option");
		
		int sId = Integer.parseInt(si);
			System.out.println("変換後のsId = " + sId);
//		int opId = Integer.parseInt(op);
		
		//DAOをインスタンス化
		ApplyDAO dao = new ApplyDAO();		
		AllDTO siki = dao.getSiki(sId);
		AllDTO course = dao.getCourseInfo(courseId);
//		AllDTO option = dao.getOption(sId);
		
		//選択されたオプション(のname属性)を取得
		String[] optionIds = request.getParameterValues("option");
		List<AllDTO> opList = new ArrayList<>();
		
		int opsum = 0;
		if (optionIds != null) {
			for (String oid : optionIds) {
				int optionId = Integer.parseInt(oid);
				// DAOで取得して確認画面に渡すなど
				AllDTO opt = dao.getOption(optionId);  // ←個別取得メソッドを用意してもOK
				opList.add(opt);
				opsum += Integer.parseInt(opt.getOptionPrice());
			}
		}else {
			request.setAttribute("opMsg", "未選択");
		}
			//確認用
			System.out.println("siki = " + siki);
		
		request.setAttribute("course", course);
		request.setAttribute("siki", siki);
		request.setAttribute("options", opList);
		request.setAttribute("opsum", opsum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/apply_confirm.jsp");
		dispatcher.forward(request,response);

	}
	

}