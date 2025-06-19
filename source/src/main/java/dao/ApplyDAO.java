package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AllDTO;
import dto.ApplyDTO;

public class ApplyDAO {
	
	public List<ApplyDTO> course(int courseId,int userId) {
		List<ApplyDTO> applyList = new ArrayList<>();
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT * FROM course "
					+ "JOIN sc ON course.course_id = sc.course_id "
					+ "JOIN sikijo ON sc.sikijo_id = sikijo.sikijo_id "
					+ "WHERE course.course_id =?";
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			pStmt.setInt(1, courseId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			ResultSet rs = pStmt.executeQuery();//なんでも表が入るResultSet型に格納（DAOでしか使えない）
			
			while(rs.next()) {
				//空の枝豆（DTO）作成
				ApplyDTO dto = new ApplyDTO();

				//上のDTOに値を入れていく（DBの値をDTOへコピー）
				dto.setUserId(userId);
//				dto.setPlannerId(rs.getInt("planner_id"));
				dto.setSikijoId(rs.getInt("sikijo_id"));
				dto.setCourseId(rs.getInt("course_id"));
				
//				dto.setOptionId(rs.getInt("option_id"));
				


				//値が入った枝豆（上のDTO）をArrayListに追加
				applyList.add(dto);
			}
		}catch (SQLException e) {
			System.out.println("SQL文おかしいよ");
			e.printStackTrace();
			applyList = null;
		}catch (ClassNotFoundException e) {
			System.out.println("ドライバの読み込みおかしい");
			e.printStackTrace();
			applyList = null;
		}finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
					applyList = null;
				}
			}
		}
		//コースのデータの入ったArrayListをServletへ返却
		return applyList;
	}
	
	public AllDTO getSikijo(Integer sId){
		AllDTO dto =null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT * FROM sikijo WHERE sikijo_id=?";
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			
			
			pStmt.setInt(1, sId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			ResultSet rs = pStmt.executeQuery();//なんでも表が入るResultSet型に格納（DAOでしか使えない）
			
			while(rs.next()) {
				//空の枝豆（DTO）作成
				dto =new AllDTO();

				//上のDTOに値を入れていく（DBの値をDTOへコピー）
				
//				
				dto.setSikijoId(rs.getInt("sikijo_id"));
				dto.setsName(rs.getString("name"));
				dto.setsAddress(rs.getString("address"));
				
//				dto.setOptionId(rs.getInt("option_id"));
				


				//値が入った枝豆（上のDTO）をArrayListに追加
				
			}
		}catch (SQLException e) {
			System.out.println("SQL文おかしいよ");
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			System.out.println("ドライバの読み込みおかしい");
			e.printStackTrace();
			
		}finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
					
				}
			}
		}
		//コースのデータの入ったArrayListをServletへ返却
		return dto;
	}
	public List<AllDTO> getCourse(Integer cId){
		List<AllDTO> optionList = new ArrayList<>();
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT * FROM options where option_id IN("
					+ "SELECT option1 FROM course WHERE course_id=? "
					+ "UNION ALL "
					+ "SELECT option2 FROM course WHERE course_id=? "
					+ "UNION ALL "
					+ "SELECT option3 FROM course WHERE course_id=?)";
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			
			
			pStmt.setInt(1, cId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			pStmt.setInt(2, cId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			pStmt.setInt(3, cId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			ResultSet rs = pStmt.executeQuery();//なんでも表が入るResultSet型に格納（DAOでしか使えない）
			
			while(rs.next()) {
				//空の枝豆（DTO）作成
				AllDTO dto =new AllDTO();

				//上のDTOに値を入れていく（DBの値をDTOへコピー）
				
//				
				dto.setOptionId(rs.getInt("option_id"));
				dto.setOptionName(rs.getString("option_name"));
				dto.setOptionPrice(rs.getString("option_price"));
				
//				dto.setOptionId(rs.getInt("option_id"));
				optionList.add(dto);


				//値が入った枝豆（上のDTO）をArrayListに追加
				
			}
		}catch (SQLException e) {
			System.out.println("SQL文おかしいよ");
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			System.out.println("ドライバの読み込みおかしい");
			e.printStackTrace();
			
		}finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
					
				}
			}
		}
		//コースのデータの入ったArrayListをServletへ返却
		return optionList;
	}
}
