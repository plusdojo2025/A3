package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.AllDTO;
import util.DBConnection;

public class UserDAO {

    // フルネームで検索（f_name + l_name）
    public List<AllDTO> searchByFullName(String fullName) {
        List<AllDTO> list = new ArrayList<>();

        String sql = "SELECT * FROM users WHERE CONCAT(f_name, ' ', l_name) LIKE ?";
        ${All,fName} ${All,lName}
            
                AllDTO dto = new AllDTO();
                dto.setfName(rs.getString("fName"));
                dto.setlName(rs.getString("lName"));
                dto.setGender(rs.getString("gender"));
                dto.setAddress(rs.getString("address"));
                dto.setPhone(rs.getString("phone"));
                list.add(dto);
            }

      
}