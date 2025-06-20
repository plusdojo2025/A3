package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.AllDTO;

public class UidpwDAO {

	// 引数で指定されたidpwでログイン成功ならtrueを返す
			public AllDTO findUserByLogin(String id, String pw) {
			Connection conn = null;
			AllDTO user = null;

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SELECT文を準備する
				String sql = "SELECT * FROM user WHERE id=? AND pw=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,id);
				pStmt.setString(2,pw);

				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

	            if (rs.next()) {
	                user = new AllDTO();
	                user.setId(rs.getString("id"));
	                user.setPw(rs.getString("pw"));
	                user.setlName(rs.getString("f_name"));
	                user.setlName(rs.getString("l_name"));
	                user.setlName(rs.getString("k_f_name"));
	                user.setlName(rs.getString("k_l_name"));
	                user.setlName(rs.getString("birthday"));
	                user.setlName(rs.getString("gender"));
	                user.setlName(rs.getString("zipcode"));
	                user.setlName(rs.getString("address"));
	                user.setlName(rs.getString("phone"));
	                user.setlName(rs.getString("email"));
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
			return user;
		}
}
