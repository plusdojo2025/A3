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
	
	public PlannerDTO findPlannerByLogin(String id,String password) {
		Connection conn = null;
		PlannerDTO planner = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			// SELECT文を準備する
			String sql = "SELECT * FROM planner WHERE id=? AND password=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2, password);
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
			//while (rs.next()) {
				//result = rs.getString("name");
			//}
            if (rs.next()) {
                planner = new PlannerDTO();
                planner.setId(rs.getString("id"));
                planner.setPassword(rs.getString("password"));
                planner.setPlannerName(rs.getString("name"));
                planner.setGender(rs.getString("gender"));
                planner.setPhone(rs.getString("phone"));
                planner.setSikiAdd(rs.getString("sikiAdd"));
                planner.setStrongFild(rs.getString("strongFild"));
                planner.setImage(rs.getString("image"));
            }
            System.out.println(planner.getPlannerName()+"：ぷらんなのなまえ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return planner;
	}
	
	//インスタンス化＝（セレクトメソッド）
	public List<PlannerDTO> select(int sikijoId){
		//返却用ArrayList
		List<PlannerDTO> plannerList = new ArrayList<>();
		//DBの道筋用conn
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			//SQL準備（プランナーのデータすべて取得）（ハッピーセット）
			String sql = "SELECT * FROM planner "
			           + "JOIN sp ON planner.planner_id = sp.planner_id "
			           + "WHERE sikijo_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, sikijoId);//SQL内の 1つ目の ? に sikijoId の値（int型）を設定
			//SQL文実行（結果を返すSQLの実行用）
			ResultSet rs = pStmt.executeQuery();
			
			//結果表をコレクションにコピー
			while (rs.next()) {
				//空の枝豆をインスタンス化
				PlannerDTO dto = new PlannerDTO();
				
				//上のDTOに値を入れていく（DTOにコピー）
				dto.setPlannerId(rs.getInt("planner_id"));
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setPlannerName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));//要変更
				dto.setPhone(rs.getString("phone"));
				dto.setSikiAdd(rs.getString("siki_add"));
				dto.setStrongFild(rs.getString("strong_fild"));
				dto.setImage(rs.getString("image"));
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
	//インスタンス化＝（セレクトメソッド）
		public List<PlannerDTO> select(){
			//返却用ArrayList
			List<PlannerDTO> plannerList = new ArrayList<>();
			//DBの道筋用conn
			Connection conn = null;
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				//SQL準備（プランナーのデータすべて取得）（ハッピーセット）
				String sql = "SELECT * FROM planner ";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				ResultSet rs = pStmt.executeQuery();
				
				//結果表をコレクションにコピー
				while (rs.next()) {
					//空の枝豆をインスタンス化
					PlannerDTO dto = new PlannerDTO();
					
					//上のDTOに値を入れていく（DTOにコピー）
					dto.setPlannerId(rs.getInt("planner_id"));
					dto.setId(rs.getString("id"));
					dto.setPassword(rs.getString("password"));
					dto.setPlannerName(rs.getString("name"));
					dto.setGender(rs.getString("gender"));//要変更
					dto.setPhone(rs.getString("phone"));
					dto.setSikiAdd(rs.getString("siki_add"));
					dto.setStrongFild(rs.getString("strong_fild"));
					dto.setImage(rs.getString("image"));
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
