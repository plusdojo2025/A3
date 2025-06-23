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

import dao.SampleDAO;
import dao.UserDAO;
import dto.AllDTO;

@WebServlet("/ChatSelectServlet")
public class ChatSelectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // JSPにフォワードするで
        
    	HttpSession session = request.getSession();
    	AllDTO planner = (AllDTO)session.getAttribute("planner");
    	int plannerId = planner.getPlannerId();
    	//plannerIdを元に、担当しているお客さんの情報を取得する
    	UserDAO dao = new UserDAO();
    	List<AllDTO> userList =dao.getUserList(plannerId);
    	//取得したユーザーのリストをリクエストにセット（jspで取得する用）
    	request.setAttribute("userList", userList);       	
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chatselect.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストのエンコーディングを設定するで
        request.setCharacterEncoding("UTF-8");
        // フォームからのパラメータを取得するで
        String chatString = request.getParameter("chat_string");
        String userIDSpeaker = request.getParameter("user_id_speaker");
        String userIDListener = request.getParameter("user_id_listener");
        String inputTime = request.getParameter("input_time");

        // データベースにデータを挿入するで
        SampleDAO dao = new SampleDAO();
        int ans = dao.insert(userIDSpeaker, userIDListener, chatString, null, 0, inputTime);

        // 挿入が成功したら、JSPにフォワードするで
        if(ans == 1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chatselect.jsp");
            dispatcher.forward(request, response);
        }
    }
}