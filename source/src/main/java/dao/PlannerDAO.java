package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.PlannerDTO;

public class PlannerDAO {
	
	//インスタンス化＝（セレクトメソッド）
	public List<PlannerDTO> select(){
		//返却用ArrayList
		List<PlannerDTO> plannerList = new ArrayList<>();
		//DBの道筋用conn
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kkss?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			//SQL準備（プランナーのデータすべて取得）（ハッピーセット）
			String sql = "SELECT * FROM planner";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文実行（結果を返すSQLの実行用）
			ResultSet rs = pStmt.executeQuery();
			
			//結果表をコレクションにコピー
			while (rs.next()) {
				//空の枝豆をインスタンス化
				PlannerDTO dto = new PlannerDTO();
				
				//上のDTOに値を入れていく（DTOにコピー）
				dto.setPlannerId(rs.getInt("planner_id"));
				dto.setPlannerName(rs.getString("planner_name"));
				dto.setPlanner〇〇(rs.getString("〇〇"));//要変更
				
				//枝豆をArrayListに追加
				plannerList.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("SQL文おかしいぞ");
			e.printStackTrace();			
			plannerList = null;
		} catch (ClassNotFoundException e) {
			System.out.println("ドライバの読み込みおかしいぞ");
			e.printStackTrace();
			plannerList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					plannerList = null;
				}
			}
		}
			//コースのデータの入ったArrayListをSarvletへ返却
			return plannerList;
		}
	}
