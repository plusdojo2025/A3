package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.SikijoDTO;

public class SikijoDAO {
	
	
	//コーステーブルの全てのデータを取得するメソッド
	public List<SikijoDTO> select(int courseId){
		//返却するArrayListをあらかじめ用意しておく（中身なし）
		List<SikijoDTO> sikijoList = new ArrayList<>();
		//DBへの道筋を入れる箱を用意（あとで中身入れる）
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			//SQL文準備（式場のデータ全て取得）
			String sql = "SELECT sikijo.sikijo_id,sikijo.jm_number,sikijo.name,sikijo.address,sikijo.image FROM sikijo "
					+ "JOIN sc ON sikijo.sikijo_id = sc.sikijo_id "
					+ "WHERE course_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);//全部凝縮されたのが「ｐStmt」
			pStmt.setInt(1, courseId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			//SQL文実行
			ResultSet rs = pStmt.executeQuery();//なんでも表が入るResultSet型に格納（DAOでしか使えない）
			
			//結果表をコレクションにコピー
			while(rs.next()) {
				//空の枝豆（DTO）作成
				SikijoDTO dto = new SikijoDTO();
				
				//上のDTOに値を入れていく（DBの値をDTOへコピー）
				dto.setSikijoId(rs.getInt("sikijo_id"));
				dto.setSikijoJmNumber(rs.getString("jm_number"));//要変更
				dto.setSikijoName(rs.getString("name"));//要変更
				dto.setSikijoAddress(rs.getString("address"));//要変更
				dto.setImage(rs.getString("image"));//要変更
				//値が入った枝豆（上のDTO）をArrayListに追加
				sikijoList.add(dto);
			}
		}catch (SQLException e) {
			System.out.println("SQL文おかしいよ");
			e.printStackTrace();
			sikijoList = null;
		}catch (ClassNotFoundException e) {
			System.out.println("ドライバの読み込みおかしい");
			e.printStackTrace();
			sikijoList = null;
		}finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
					sikijoList = null;
				}
			}
		}
		//コースのデータの入ったArrayListをServletへ返却
		return sikijoList;
	}

}
