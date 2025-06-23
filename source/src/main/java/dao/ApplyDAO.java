package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.AllDTO;

public class ApplyDAO {
	
	//選択したコースに対応してる式場idを探す
	public List<AllDTO> course(int courseId,int userId) {
		List<AllDTO> applyList = new ArrayList<>();
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
				AllDTO dto = new AllDTO();

				//上のDTOに値を入れていく（DBの値をDTOへコピー）
//				dto.setUserId(userId);		//要変更-----------------------@
//				dto.setUserId(rs.getInt("user_id"));
//				dto.setPlannerId(rs.getInt("planner_id"));
				dto.setSikijoId(rs.getInt("sikijo_id"));
				dto.setCourseId(rs.getInt("course_id"));
//				dto.setsImage(rs.getString("image"));
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
	
	//式場idから式場のデータを探す
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
				dto.setsImage(rs.getString("image"));
				dto.setsPrice(rs.getString("sikijo_price"));
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
	
	//オプションを持ってくる
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
	
	public AllDTO getSiki(int sikijoId){
		AllDTO alldto = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT * FROM sikijo WHERE sikijo_id = ?";
//			String sql = "SELECT sikijo_id, name, address, sikijo_price FROM sikijo WHERE sikijo_id = ?";

			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			
			pStmt.setInt(1, sikijoId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			
			ResultSet rs = pStmt.executeQuery();//なんでも表が入るResultSet型に格納（DAOでしか使えない）
			
			if(rs.next()) {
				 System.out.println("ヒットした！DBにデータある！");
				//空の枝豆（DTO）作成
				alldto =new AllDTO();

				//上のDTOに値を入れていく（DBの値をDTOへコピー）
				//setはDTOで決めたやつ、getはDBのカラム名
				alldto.setSikijoId(rs.getInt("sikijo_id"));
//				dto.setJmNumber(rs.getInt("jm_number"));
				alldto.setsName(rs.getString("name"));
				alldto.setSikiAdd(rs.getString("address"));
				alldto.setsImage(rs.getString("image"));
				alldto.setsPrice(rs.getString("sikijo_price"));
				
				//値が入った枝豆（上のDTO）をArrayListに追加
//				dto.add(dto);
				
			}else {
			    System.out.println("DBに該当IDなし！");
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
		return alldto;
	}
	
	//選ばれたコースを取得----------------------------------------
	public AllDTO getCourseInfo(int courseId) {
	    AllDTO dto = null;
	    Connection conn=null;
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT * FROM course WHERE course_id = ?";
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			
			pStmt.setInt(1, courseId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			
			ResultSet rs = pStmt.executeQuery();//なんでも表が入るResultSet型に格納（DAOでしか使えない）
			
			if(rs.next()) {
				 System.out.println("ヒットした！DBにデータある！");
				//空の枝豆（DTO）作成
				dto =new AllDTO();

				//上のDTOに値を入れていく（DBの値をDTOへコピー）
				//setはDTOで決めたやつ、getはDBのカラム名
				dto.setCourseId(rs.getInt("course_id"));
	            dto.setCourseName(rs.getString("course_name"));
	            dto.setIntro(rs.getString("comment"));
				
				//値が入った枝豆（上のDTO）をArrayListに追加
//				dto.add(dto);
			}else {
			    System.out.println("DBに該当IDなし！");
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
	
	//optionを取得--------------------------------------------
	public AllDTO getOption(int optionId) {
	    AllDTO dto = null;
	    Connection conn=null;
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT * FROM options WHERE option_id = ?";
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			
			pStmt.setInt(1, optionId);//SQL内の 1つ目の ? に optionId の値（int型）を設定
			
			ResultSet rs = pStmt.executeQuery();//なんでも表が入るResultSet型に格納（DAOでしか使えない）
			
			if(rs.next()) {
				 System.out.println("ヒットした！DBにデータある！");
				//空の枝豆（DTO）作成
				dto =new AllDTO();

				//上のDTOに値を入れていく（DBの値をDTOへコピー）
				//setはDTOのセッター、getはDBのカラム名
				dto.setOptionId(rs.getInt("option_id"));
	            dto.setOptionName(rs.getString("option_name"));
	            dto.setOptionPrice(rs.getString("option_price"));
				
				//値が入った枝豆（上のDTO）をArrayListに追加
//				dto.add(dto);
			}else {
			    System.out.println("DBに該当IDなし！");
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
	
	//登録（applyテーブルへデータを入れる）------------------------------
	public void insert(int userId, int courseId, int sikijoId, List<Integer> opIds, String remarks) {
	    Connection conn=null;
//	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int applyId = -1;
	    System.out.println("call insert() with opIds: " + opIds);
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			conn.setAutoCommit(false); 
			
			// SQL文の準備
			String sql = "INSERT INTO apply (user_id, course_id, sikijo_id, remarks) VALUES (?, ?, ?, ?)";
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pStmt.setInt(1, userId);
			pStmt.setInt(2, courseId);
			pStmt.setInt(3, sikijoId);
			pStmt.setString(4, remarks);
//			pStmt.executeUpdate();
//			pStmt.setString(4, optionIds); //SQL内の4つ目の ? に optionId の値（int型）を設定
			
			int affectedRows = pStmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("applyテーブルへの挿入に失敗しました。");
	        }

	        rs = pStmt.getGeneratedKeys();
	        if (rs.next()) {
	            applyId = rs.getInt(1);
	        } else {
	            throw new SQLException("apply_id の取得に失敗しました。");
	        }
	        // ② apply_option テーブルに複数INSERT
	        String sqlOption = "INSERT INTO AO (apply_id, option_id) VALUES (?, ?)";
	        pStmt = conn.prepareStatement(sqlOption);
	        for (Integer optId : opIds) {
	            pStmt.setInt(1, applyId);
	            pStmt.setInt(2, optId);
	            pStmt.addBatch();
	        }
	        pStmt.executeBatch();
	       
	        // コミット
	        conn.commit();
	        return;	        
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
		
	}
	
	public List<AllDTO> applyComp(int userId) {
		List<AllDTO> applyList = new ArrayList<>();
		Map<Integer, AllDTO> applyMap = new HashMap<>();
		AllDTO alldto = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT * FROM apply "
							+ "JOIN user ON apply.user_id = user.user_id "
							+ "JOIN course ON apply.course_id = course.course_id "
							+ "JOIN sikijo ON apply.sikijo_id = sikijo.sikijo_id "
							+ "LEFT JOIN AO ON apply.apply_id = AO.apply_id "
							+ "LEFT JOIN options ON AO.option_id = options.option_id "
							+ "WHERE apply.user_id = ?";
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			
			pStmt.setInt(1, userId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			ResultSet rs = pStmt.executeQuery();//なんでも表が入るResultSet型に格納（DAOでしか使えない）
			
			while(rs.next()) {
				System.out.println("ヒットした！DBにデータある！");
				
				int applyId = rs.getInt("apply_id");
				//空の枝豆（DTO）作成
				alldto = new AllDTO();
				
				if(applyMap.containsKey(applyId)) {
					alldto = applyMap.get(applyId);
				}else {
					//上のDTOに値を入れていく（setはDTOのセッター、getはDBのカラム名）
						/*コース*/
					alldto.setCourseId(rs.getInt("course_id"));
					alldto.setCourseName(rs.getString("course_name"));
					alldto.setIntro(rs.getString("comment"));
					alldto.setcPrice(rs.getString("course_price"));
						/*式場*/	
					alldto.setSikijoId(rs.getInt("sikijo_id"));				
					alldto.setJmNumber(rs.getString("jm_number"));
					alldto.setsName(rs.getString("name"));
					alldto.setSikiAdd(rs.getString("address"));
					alldto.setsImage(rs.getString("image"));
					alldto.setsPrice(rs.getString("sikijo_price"));
						/*オプション*/
					alldto.setOptionId(rs.getInt("option_id")); 
					alldto.setOptionName(rs.getString("option_name"));
					alldto.setOptionPrice(rs.getString("option_price"));
					alldto.setOptionNames(new ArrayList<>());
						/*備考*/
					alldto.setRemarks(rs.getString("remarks"));
					
					applyMap.put(applyId, alldto);
					//値が入った枝豆（上のDTO）をArrayListに追加
					applyList.add(alldto);
				}
				// オプション名をリストに追加（nullチェック）
	            String optionName = rs.getString("option_name");
	            if(optionName != null && !optionName.isEmpty()) {
	                alldto.getOptionNames().add(optionName);
	            }
				// オプションが null の場合にも対応
	            int optionId = rs.getInt("option_id");
	            if (!rs.wasNull()) {
	                alldto.setOptionId(optionId);
	                alldto.setOptionName(rs.getString("option_name"));
	                alldto.setOptionPrice(rs.getString("option_price"));
	            }
				
//			}else {
//			    System.out.println("DBに該当IDなし！");
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
		return applyList;
	}
	
	//申し込み済かどうか
	public boolean Applied(int userId) {
		Connection conn=null;
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT COUNT(*) FROM apply WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			
			pStmt.setInt(1, userId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			
			try (ResultSet rs = pStmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0;
	            }
	        }catch (SQLException e) {
	        e.printStackTrace();
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
		return false;
	}
}
