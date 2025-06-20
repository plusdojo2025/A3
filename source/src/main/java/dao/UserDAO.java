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
       
        String sql = "SELECT * FROM user WHERE f_name like=? OR l_name like=?";
        PreparedStatement pStmt = conn.prepareStatement(sql);
			
        String fullName= user.getfName() + user.getlName();
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
	public boolean insert(String id,String pw,String fName,String lName,
			String kfName,String klName,String birthday,String gender,String zipcode,
			String address,String email,String phone) {
		Connection conn = null;
		boolean result = false;
		
		System.out.println(gender);
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "INSERT INTO User VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			
			pStmt.setString(1,id);
			
			pStmt.setString(2 ,pw);
	
			pStmt.setString(3,fName);
		
			pStmt.setString(4,lName);
		
			pStmt.setString(5, kfName);
			
			pStmt.setString(6, klName);
		
			pStmt.setString(7, birthday);
		
			pStmt.setString(8, gender);
		
			pStmt.setString(9, zipcode);
		
			pStmt.setString(10, address);
		
			pStmt.setString(11, email);
		
			pStmt.setString(12, phone);
			

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
	
	//更新メソッド
	public boolean update(int userId,String birthday,String zipcode,String phone,String email ,String address) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean ans = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // JDBCドライバ読み込み
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/a3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                "root", "password");

            String sql = "UPDATE user SET  birthday=?, zipcode=?, address=?, email=?, phone=? WHERE user_id=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, birthday);
            pstmt.setString(2, zipcode);
            pstmt.setString(3, address);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            pstmt.setInt(6, userId);
			/*
			 * pstmt.setString(7, dto.getBirthday()); pstmt.setString(8, dto.getGender());
			 * pstmt.setString(9, dto.getZipcode()); pstmt.setString(10, dto.getAddress());
			 * pstmt.setString(11, dto.getEmail()); pstmt.setString(12, dto.getPhone());
			 * pstmt.setInt(13, dto.getUserId());
			 */

            int result = pstmt.executeUpdate();
            
            if(result == 1) {
            	ans = true;
            }
            return ans;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 削除メソッド
	public boolean delete(int userId,String birthday,String zipcode,String phone,String email ,String address) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean ans = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // JDBCドライバ読み込み
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/a3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                "root", "password");

            String sql = "UPDATE user SET  birthday=?, zipcode=?, address=?, email=?, phone=? WHERE user_id=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, birthday);
            pstmt.setString(2, zipcode);
            pstmt.setString(3, address);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            pstmt.setInt(6, userId);
            
            //String sql = "DELETE FROM user WHERE user_id=?";
            //pstmt = conn.prepareStatement(sql);
            //pstmt.setInt(1, user_id);

            int result = pstmt.executeUpdate();
            if(result == 1) {
            	ans = true;
            }
            return ans;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
	}
      
