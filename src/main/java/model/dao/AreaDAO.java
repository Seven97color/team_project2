package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.entity.AreaBean;

public class AreaDAO {
	private final String url = "jdbc:mysql://localhost:3306/customer_manager";
	private final String user = "customer_managerU";
	private final String password = "customer_managerP";

	public List<AreaBean> findAll() {
		List<AreaBean> list = new ArrayList<>();
		String sql = "SELECT area_code, area_name FROM m_area";
		try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				AreaBean bean = new AreaBean();
				bean.setAreaCode(rs.getString("area_code"));
				bean.setAreaName(rs.getString("area_name"));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
}
