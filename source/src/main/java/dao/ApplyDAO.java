package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ApplyDTO;

public class ApplyDAO {
	
	public List<ApplyDTO> apply() {
		List<ApplyDTO> applyList = new ArrayList<>();
		Connection conn = null;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベース(webapp2)に接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kkss?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
			
			//SQL文準備（applyデータ全て取得）
			String sql = "SELECT * FROM apply";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文実行
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				ApplyDTO app = new ApplyDTO();
				
				app.setCourseId(rs.getInt("apply_id"));
				app.setCourseId(rs.getInt("user_id"));
				app.setCourseId(rs.getInt("sikijo_id"));
				app.setCourseId(rs.getInt("planner_id"));
				app.setCourseId(rs.getInt("course_id"));
				
				//applyListに表の1行目から結果を入れていく
				applyList.add(app);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			applyList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			applyList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					applyList = null;
				}
			}
		}
		// 結果を返す
		return applyList;
	}

}
