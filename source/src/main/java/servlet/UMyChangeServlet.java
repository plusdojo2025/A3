package servlet;

import java.io.IOException;

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
 * Servlet implementation class UMyChangeServlet
 */
@WebServlet("/UMyChangeServlet")
public class UMyChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public UMyChangeServlet() {
     //   super();
        // TODO Auto-generated constructor stub
    //}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/umychange.jsp");  
		dispatcher.forward(request, response);
	}

	/**
	 * @param id 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("submita")+"ボタンの名前だよ");
		 if (request.getParameter("submita").equals("更新")) {
			//もしログインしていなかったらユーザーログイン画面へ
				HttpSession session = request.getSession();
				AllDTO loginUser = (AllDTO) session.getAttribute("user");
				if(loginUser == null) {
					response.sendRedirect("LoginServlet");
					return;
				}
				
				//リクエストパラメーターを取得する
			
				System.out.println(loginUser.getUserId()+"ログインユーザー");
				int user_id =loginUser.getUserId();
//				int user_id = Integer.parseInt(request.getParameter("user_id"));
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String f_name = request.getParameter("f_name");
				String l_name = request.getParameter("l_name");
				String k_f_name = request.getParameter("k_f_name");
				String k_l_name = request.getParameter("k_l_name");
				String birthday = request.getParameter("birthday");
				String gender = request.getParameter("gender");
				String zipcode = request.getParameter("zipcode");
				String address = request.getParameter("address");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");

				
				// 更新または削除を行う
				UserDAO uDao = new UserDAO();
				 //String action = request.getParameter("submit");
				 boolean success = uDao.update(user_id, birthday,zipcode, phone, email, address);
		 
		        if (success) {
		            request.setAttribute("message", "更新成功しました！");
		        } else {
		            request.setAttribute("message", "更新に失敗しました。");
		        }
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/umychange.jsp");
		        dispatcher.forward(request, response);
		        
		    } else if (request.getParameter("submita").equals("削除"))  {
		    	HttpSession session = request.getSession();
		        AllDTO loginUser = (AllDTO) session.getAttribute("user");
		        if (loginUser == null) {
		            response.sendRedirect("LoginServlet");
		            return;
		        }

		        int user_id = loginUser.getUserId();
		        UserDAO uDao = new UserDAO();
		        boolean deleteSuccess = uDao.delete(user_id);

		        if (deleteSuccess) {
		            session.invalidate(); // セッション無効化
		            request.setAttribute("message", "削除完了しました。ご利用ありがとうございました。");
		            response.sendRedirect("LoginServlet");
		            return;
		            
		        } else {
		            request.setAttribute("message", "削除に失敗しました。");
		            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UMyServlet.jsp");
		            dispatcher.forward(request, response);
		            return;
		        }
		    }
	}
}
		        
		        // 削除結果表示用JSPにフォワード
		        //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LoginServlet.jsp");
		        //dispatcher.forward(request, response);
		   // }
		/*if (request.getParameter("submit").equals("更新")) {
			if (uDao.update(new AllDTO(user_id,id,pw,f_name,l_name,k_f_name,k_l_name,birthday,gender,zipcode,address,email,phone))) { // 更新成功
				request.setAttribute("result");
			} else { // 更新失敗
				request.setAttribute("result", new Result("更新失敗！", "レコードを更新できませんでした。", "UMyChangeServlet"));
			}
		} else {
			if (uDao.update(new AllDTO(user_id,id,pw,f_name,l_name,k_f_name,k_l_name,birthday,gender,zipcode,address,email,phone))) { // 削除成功
				request.setAttribute("result", new Result("削除成功！", "レコードを削除しました。", "UMypServlet"));
			} else { // 削除失敗
				request.setAttribute("result", new Result("削除失敗！", "レコードを削除できませんでした。", "UMyChangeServlet"));
			}
		}*/
//		    	 boolean deleteSuccess = uDao.delete(user_id);
//		            if (deleteSuccess) {
//		                session.invalidate();
//		    	request.setAttribute("message", "削除完了！");
//		            } else {
//		                request.setAttribute("message", "削除に失敗しました。");
//		            }

		// 結果ページにフォワードする
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UMyServlet.jsp");
		//dispatcher.forward(request, response);
	//}

	//}

