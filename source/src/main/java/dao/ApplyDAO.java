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
	
	//選択したコースに対応してる式場idを探す
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
				dto.setUserId(userId);		//要変更-----------------------@
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
	
	public AllDTO getSiki(int sId){
		AllDTO alldto = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT sikijo_id, name, address FROM sikijo WHERE sikijo_id = ?";
			System.out.println(sql);
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			
			pStmt.setInt(1, sId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			
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
//				dto.setsImage(rs.getString("image"));
//				dto.setOptionPrice(rs.getString("sikijo_price"));
				
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
	            dto.setCommnet(rs.getString("comment"));
				
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
	
	//optionを取得
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
}
