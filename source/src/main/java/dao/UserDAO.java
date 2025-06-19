package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AllDTO;

public class UserDAO {

    // フルネームで検索（f_name + l_name）
    public List<AllDTO> searchByFullName(AllDTO user) {
    	Connection conn = null;
        List<AllDTO> list = new ArrayList<>();
       
        try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
				"root", "password");
       
        String sql = "SELECT * FROM user WHERE fName like=? OR lName like=?";
        PreparedStatement pStmt = conn.prepareStatement(sql);
		
			pStmt.setString(1, "%" + user.getfName() + "%");		
			pStmt.setString(2, "%" +user.getlName() + "%");
		
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				AllDTO all = new AllDTO();
			    all.setfName(rs.getString("fName"));
			    all.setlName(rs.getString("lName"));
			    all.setGender(rs.getString("gender"));
			    all.setAddress(rs.getString("address"));
			    all.setPhone(rs.getString("phone"));
			    list.add(all);
			}
        } catch (SQLException e) {
            e.printStackTrace();
				
			}
        return list;
         }
    
	//新規登録
	public boolean insert(AllDTO user) {
		Connection conn = null;
		boolean result = false;
		

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "INSERT INTO Bc VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (user.getId() != null) {
				pStmt.setString(1, user.getId());
			} else {
				pStmt.setString(1, "");
			}
			if (user.getPw() != null) {
				pStmt.setString(1, user.getPw());
			} else {
				pStmt.setString(1, "");
			}
			if (user.getfName() != null) {
				pStmt.setString(1, user.getfName());
			} else {
				pStmt.setString(1, "");
			}
			if (user.getkfName() != null) {
				pStmt.setString(1, user.getkfName());
			} else {
				pStmt.setString(1, "");
			}
			if (user.getklName() != null) {
				pStmt.setString(1, user.getklName());
			} else {
				pStmt.setString(1, "");
			}
			if (user.getBirthday() != null) {
				pStmt.setString(2, user.getBirthday());
			} else {
				pStmt.setString(2, "");
			}
			
			if (user.getGender() != null) {
				pStmt.setString(3, user.getGender());
			} else {
				pStmt.setString(3, "");
			}
			if (user.getZipcode() != null) {
				pStmt.setString(4, user.getZipcode());
			} else {
				pStmt.setString(4, "");
			}
			if (user.getAddress() != null) {
				pStmt.setString(5, user.getAddress());
			} else {
				pStmt.setString(5, "");
			}
			if (user.getEmail() != null) {
				pStmt.setString(6, user.getEmail());
			} else {
				pStmt.setString(6, "");
			}
			if (user.getPhone() != null) {
				pStmt.setString(7, user.getPhone());
			} else {
				pStmt.setString(7, "");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
	
	}
      
