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
        System.out.println(user.getfName()+"：渡ってきた値");
        try {
        	//ここでspl接続
        	Class.forName("com.mysql.cj.jdbc.Driver"); 
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
				+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
				"root", "password");
       
        //SQLから姓と名を取得
        String sql = "SELECT * FROM user WHERE f_name like ? OR l_name like ?";
        PreparedStatement pStmt = conn.prepareStatement(sql);
			
        //ワイルドカードで名前かすったところをとってくる。
        pStmt.setString(1, "%"+user.getfName()+"%");
        pStmt.setString(2, "%"+user.getfName()+"%");
        //rsとsqlの関係的な
			ResultSet rs = pStmt.executeQuery();
		
			//ここでdaoから取得をnext()で順番に入れ込んでwhileで繰り返し
			while(rs.next()) {
				AllDTO all = new AllDTO();
			    all.setfName(rs.getString("f_name"));
			    all.setlName(rs.getString("l_name"));
			    all.setGender(rs.getString("gender"));
			    all.setAddress(rs.getString("address"));
			    all.setPhone(rs.getString("phone"));
			    list.add(all);
			}
        } catch (SQLException e) {
            e.printStackTrace();
				
			} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        return list;
         }
    
    
 //みょうじとなまえとってくる
    public AllDTO findExactUser(String fName, String lName) {
        AllDTO all = null;
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/a3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
                "root", "password");

            String sql = "SELECT * FROM user WHERE f_name = ? AND l_name = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, fName);
            pStmt.setString(2, lName);

            ResultSet rs = pStmt.executeQuery();

            if (rs.next()) {
                all = new AllDTO();
                all.setfName(rs.getString("f_name"));
                all.setlName(rs.getString("l_name"));
                
            }

            rs.close();
            pStmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return all;
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
			
			//IDとPWが既に登録されていないか確認する
			String checkSql = "SELECT COUNT(*) FROM User WHERE id = ? OR pw = ?";
			try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
			    checkStmt.setString(1, id);
			    checkStmt.setString(2, pw);
			    try (ResultSet rs = checkStmt.executeQuery()) {
			        if (rs.next() && rs.getInt(1) > 0) {
			            // IDまたはPWがすでに使われている → 登録失敗
			            return false;
			        }
			    }
			}

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
	public boolean update(int userId,String fName,String lName,String birthday,String phone,String email ,String address) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean ans = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // JDBCドライバ読み込み
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/a3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                "root", "password");

            String sql = "UPDATE user SET  f_name=?, l_name=?,birthday=?, address=?, email=?, phone=? WHERE user_id=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, fName);
            pstmt.setString(2, lName);
            pstmt.setString(3, birthday);
            pstmt.setString(4, address);
            pstmt.setString(5, email);
            pstmt.setString(6, phone);
            pstmt.setInt(7, userId);
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

    // 削除メソッド	public boolean delete(int user_id) {
	// TODO 自動生成されたメソッド・スタブ
	//return false;
//}
	public boolean delete(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean ans = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // JDBCドライバ読み込み
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/a3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
                "root", "password");

            String sql = "DELETE FROM user WHERE user_id=?";  //birthday=?, zipcode=?, address=?, email=?, phone=? WHERE user_id=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userId);
			/*
			 * pstmt.setString(2, zipcode); pstmt.setString(3, address); pstmt.setString(4,
			 * email); pstmt.setString(5, phone); pstmt.setInt(6, userId);
			 */
            
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
	//plannnerIdを元に担当しているユーザーを取得
	 public List<AllDTO> getUserList(int plannerId) {
	    	Connection conn = null;
	        List<AllDTO> userList = new ArrayList<>();
	        System.out.println(plannerId+"：渡ってきた値");
	        try {
	        	//ここでspl接続
	        	Class.forName("com.mysql.cj.jdbc.Driver"); 
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
	       
	        //SQLから姓と名を取得
	        String sql = "SELECT DISTINCT user.user_id,user.f_name,user.l_name "
	        	+ "FROM sp "
	        	+ "JOIN planner "
	        	+ "ON planner.planner_id = sp.planner_id "
	        	+ "JOIN sikijo "
	        	+ "ON sikijo.sikijo_id = sp.sikijo_id "
	        	+ "JOIN apply "
	        	+ "ON sikijo.sikijo_id = apply.sikijo_id "
	        	+ "JOIN user "
	        	+ "ON user.user_id = apply.user_id "
	        	+ "WHERE planner.planner_id = ? " ;
	        		
	        		
	        System.out.println(sql);
	        PreparedStatement pStmt = conn.prepareStatement(sql);
				
	        //ワイルドカードで名前かすったところをとってくる。
	        pStmt.setInt(1, plannerId);
	        
	        //rsとsqlの関係的な
				ResultSet rs = pStmt.executeQuery();
			
				//ここでdaoから取得をnext()で順番に入れ込んでwhileで繰り返し
				while(rs.next()) {
					AllDTO all = new AllDTO();
					all.setUserId(rs.getInt("user_id"));
				    all.setfName(rs.getString("f_name"));
				    all.setlName(rs.getString("l_name"));
				    
				    userList.add(all);
				}
	        } catch (SQLException e) {
	            e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        return userList;
	         }
	 public boolean memoUpdate(int memoId,String memo,int mUserId, int mPlannerId) {
		 Connection conn = null;
	        PreparedStatement pStmt = null;
	        boolean ans = false;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");  // JDBCドライバ読み込み
	            conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/a3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
	                "root", "password");
	            String sql = "UPDATE memo SET memo = ? WHERE user_id = ? AND planner_id = ? ";
	           
	           
	            pStmt = conn.prepareStatement(sql);

	            pStmt.setString(1, memo);
	            pStmt.setInt(2, mUserId);
	            pStmt.setInt(3, mPlannerId);
	            
	            if(pStmt.executeUpdate()==1) {
	            	ans = true;
	            }else{
	            	//insert
		            String sql2 = "INSERT INTO memo (memo_id,memo, user_id, planner_id) VALUES (null,?, ?, ?)";
	
		            pStmt = conn.prepareStatement(sql2);
		            pStmt.setString(1, memo);
		            pStmt.setInt(2, mUserId);
		            pStmt.setInt(3, mPlannerId);
	            	pStmt.executeUpdate();
	            	ans = true;
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
			return ans;
	  }
	 public String getMemo(int userId, int plannerId) {
		    Connection conn = null;
		    PreparedStatement pStmt = null;
		    ResultSet rs = null;
		    String memo = "";

		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        conn = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/a3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
		            "root", "password");

		        String sql = "SELECT memo FROM memo WHERE user_id = ? AND planner_id = ?";
		        pStmt = conn.prepareStatement(sql);
		        pStmt.setInt(1, userId);
		        pStmt.setInt(2, plannerId);
		        rs = pStmt.executeQuery();

		        if (rs.next()) {
		            memo = rs.getString("memo");
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (rs != null) rs.close();
		            if (pStmt != null) pStmt.close();
		            if (conn != null) conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    return memo;
		}

	
	 }
	        
	 
	

      
