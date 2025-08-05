package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;

public class CustomerDAO {

    public List<CustomerBean> findAll() throws ClassNotFoundException, SQLException {
        List<CustomerBean> list = new ArrayList<>();

        String sql = "SELECT * FROM m_customer";  // テーブル名修正

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet res = pstmt.executeQuery()) {

            while (res.next()) {
                CustomerBean customer = new CustomerBean();
                customer.setCustomerName(res.getString("customer_name"));
                customer.setPostCode(res.getString("post_code"));
                customer.setAreaCode(res.getString("area_code"));
                customer.setGender(res.getString("gender"));
                customer.setBirthday(res.getString("birthday"));
                customer.setPhoneNumber(res.getString("phone_number"));
                list.add(customer);
            }
        }
        return list;
    }
}
