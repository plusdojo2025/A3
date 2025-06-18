package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AllDTO;
import util.DBConnection;

public class UserDAO {

    // フルネームで検索（f_name + l_name）
    public List<AllDTO> searchByFullName(String fullName) {
    	Connection conn = null;
        List<AllDTO> list = new ArrayList<>();
       
        
        String sql = "SELECT * FROM users WHERE CONCAT(f_name, ' ', l_name) LIKE ?";
        //${All,fName} ${All,lName}
            
            AllDTO dto = new AllDTO();
          dto.setfName(rs.getString("fName"));           
          dto.setlName(rs.getString("lName"));
          dto.setGender(rs.getString("gender"));
          dto.setAddress(rs.getString("address"));
          dto.setPhone(rs.getString("phone"));
              list.add(dto);
            
    
              // SQL文を実行し、結果表を取得する
		//ここではけっかがすぐにかえってこさせてる（resultset型は票のなんでも取りますよって感じ
		ResultSet rs = pStmt.executeQuery();
		
		// 結果表をコレクションにコピーする
		//BC.setName(rs.getInt("number")):
		//リザルトセットはカードリストはDAOだから仕事が終わってサーブレットに渡す。カードリストの中にアレイリスト
		while (rs.next()) {
			Bc bc = new Bc(rs.getInt("number"),
						   rs.getString("company"),
						   rs.getString("department"),
						   rs.getString("position"),
						   rs.getString("name"),
						   rs.getString("zipcode"),
						   rs.getString("address"),
						   rs.getString("phone"),
						   rs.getString("fax"),
						   rs.getString("email"),
						   rs.getString("remarks"));
			cardList.add(bc);
		}



	    PreparedStatement pStmt = conn.prepareStatement(sql);
	    if (user.getCompany() != null) {
			pStmt.setString(1, "%" + user.getCompany() + "%");
		} else {
			pStmt.setString(1, "%");
		}
		if (user.getDepartment() != null) {
			pStmt.setString(2, "%" +user.getDepartment() + "%");
		} else {
			pStmt.setString(2, "%");
		}
		if (user.getPosition() != null) {
			pStmt.setString(3, "%" + user.getPosition() + "%");
		} else {
			pStmt.setString(3, "%");
		}
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
      
}