package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.AllDTO;
import dto.Bc;
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
            }
    
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