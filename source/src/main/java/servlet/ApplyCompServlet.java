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
 * Servlet implementation class ApplyCompServlet
 */
@WebServlet("/ApplyCompServlet")
public class ApplyCompServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ApplyDAO appdao = new ApplyDAO();
		HttpSession session = request.getSession();
		AllDTO user =(AllDTO)session.getAttribute("user");
		int userId =user.getUserId();
//		int userId =3; //仮のid、本来ver.に戻したらDAOのuserId使ってる部分の変更あり
//		if (user == null) {
//		    response.sendRedirect(request.getContextPath() + "/LoginServlet");
//		    return;
//		}
		List<AllDTO> applyList  = appdao.applyComp(userId);
		request.setAttribute("appList", applyList);
		//合計金額
		int total = 0;	
		if (!applyList.isEmpty()) {
			AllDTO dto = applyList.get(0);
			// コース金額
		    if (dto.getcPrice() != null && !dto.getcPrice().isEmpty()) {
		        total += Integer.parseInt(dto.getcPrice());
		    }
		    // 式場金額
		    if (dto.getsPrice() != null && !dto.getsPrice().isEmpty()) {
		        total += Integer.parseInt(dto.getsPrice());
		    }
		}
		for (AllDTO dto : applyList) {
		System.out.println("OptionPrices: " + dto.getOptionPrices());
			for (String priceStr : dto.getOptionPrices()) {
			    if (priceStr != null && !priceStr.isEmpty()) {
			        total += Integer.parseInt(priceStr);
			        System.out.println("Option price added: " + priceStr + ", total: " + total);
			    }
			}
		}
		request.setAttribute("totalPrice", total);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/applyhistory.jsp");
		dispatcher.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//セッションからapply2,3で選択されたコース、式場、オプションidと備考欄を取得
		HttpSession session = request.getSession();
		AllDTO user =(AllDTO)session.getAttribute("user");
		int userId =user.getUserId();
		//int userId =3; //仮のid、本来ver.に戻したらDAOのuserId使ってる部分の変更あり
		int courseId = (Integer) session.getAttribute("courseId");
		AllDTO sikijo = (AllDTO) session.getAttribute("sikijo");
		int sikijoId = sikijo.getSikijoId();
		int plannerId = (Integer) session.getAttribute("plannerId");
//		int plannerId = planner.getPlannerId();
		String remarks = (String) session.getAttribute("remarks");	
		
		
		//セッションからoptionIds(String[]型)を取得
		String[] optionIds = (String[]) session.getAttribute("optionIds");
		//List<Integer>に変換
		List<Integer> opIds = new ArrayList<>();
		System.out.println("opIds size: " + (opIds == null ? "null" : opIds.size()));
		if (opIds != null) {
		    for (int i = 0; i < opIds.size(); i++) {
		        System.out.println("Index " + i + ": " + opIds.get(i));
		    }
		}
		if (optionIds != null) {
		    for (String oid : optionIds) {		    	
		    	opIds.add(Integer.parseInt(oid));
		    }
		}
		//登録処理
		ApplyDAO appdao = new ApplyDAO();
		appdao.insert(userId, courseId, sikijoId, plannerId, opIds, remarks);
//		int opsum = (Integer) session.setAttribute("opsum", opsum);
//		

		List<AllDTO> applyList  = appdao.applyComp(userId);
		if (remarks == null) {
			remarks = "なし";
		}
		int total = 0;	
		if (!applyList.isEmpty()) {
			AllDTO dto = applyList.get(0);
			// コース金額
		    if (dto.getcPrice() != null && !dto.getcPrice().isEmpty()) {
		        total += Integer.parseInt(dto.getcPrice());
		    }

		    // 式場金額
		    if (dto.getsPrice() != null && !dto.getsPrice().isEmpty()) {
		        total += Integer.parseInt(dto.getsPrice());
		    }
		}
		for (AllDTO dto : applyList) {
		System.out.println("OptionPrices: " + dto.getOptionPrices());
			for (String priceStr : dto.getOptionPrices()) {
			    if (priceStr != null && !priceStr.isEmpty()) {
			        total += Integer.parseInt(priceStr);
			        System.out.println("Option price added: " + priceStr + ", total: " + total);
			    }
			}
		}
		NumberFormat formatter = NumberFormat.getNumberInstance();
		String apptotal = formatter.format(total);
		
		
		
		System.out.println(applyList.size());
		request.setAttribute("totalPrice", apptotal);
		request.setAttribute("appList", applyList);
		System.out.println(applyList.size());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/applyhistory.jsp");
		dispatcher.forward(request,response);	
	}
}
