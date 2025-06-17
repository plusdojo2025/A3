package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.AllDTO;

public class PidpwDAO {
	// 引数で指定されたidpwでログイン成功ならtrueを返す
			public AllDTO findPlannerByLogin(String id, String pw) {
				Connection conn = null;
				AllDTO planner = null;

				try {
					// JDBCドライバを読み込む
					Class.forName("com.mysql.cj.jdbc.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/planner?"
							+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
							"root", "password");

					// SELECT文を準備する
					String sql = "SELECT * FROM planner WHERE id=? AND password=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1, id);
					pStmt.setString(2, pw);

					// SELECT文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
					//while (rs.next()) {
						//result = rs.getString("name");
					//}
		            if (rs.next()) {
		                planner = new AllDTO();
		                planner.setpId(rs.getString("id"));
		                planner.setpPassword(rs.getString("password"));
		                planner.setpName(rs.getString("name"));
		            }
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (conn != null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return planner;
			}
}
