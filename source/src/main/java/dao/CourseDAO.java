package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CourseDTO;

public class CourseDAO {
	
	//コーステーブルの全てのデータを取得するメソッド-------------------------------
	public List<CourseDTO> select(){
		//返却するArrayListを予め用意しておく（中身はまだない）
		List<CourseDTO> courseList= new ArrayList<>();
		//DBへの道筋を入れる箱を用意（あとで中身入れる）
		Connection conn = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			// SQL文の準備（コースのデータ全て取得）（ハッピーセット）
			String sql = "SELECT * FROM course ";
					
			PreparedStatement pStmt = conn.prepareStatement(sql);

			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				//空の枝豆（DTO）を作成する
				CourseDTO dto = new CourseDTO();
				
				//上のDTOに値を入れていく（DBの値をDTOへコピーしてく）
				dto.setCourseId(rs.getInt("course_id"));
				dto.setCourseName(rs.getString("course_name"));
				dto.setJmNumber(rs.getString("jm_number"));
				dto.setComment(rs.getString("comment"));
				dto.setOption1(rs.getString("option1"));
				dto.setOption2(rs.getString("option2"));
				dto.setOption2(rs.getString("option3"));
				dto.setCoursePrice(rs.getString("course_price"));
				
			    //値が入った枝豆（上のDTO)をArrayListに追加する
				courseList.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("SQL文おかしいぞ");
			e.printStackTrace();			
			courseList = null;
		} catch (ClassNotFoundException e) {
			System.out.println("ドライバの読み込みおかしいぞ");
			e.printStackTrace();
			courseList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					courseList = null;
				}
			}
		}
		//コースのデータの入ったArrayListをServletへ返却
		return courseList;
	}

}
