package servlet;

import java.io.IOException;
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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Map<String, String>> customers = new ArrayList<>();
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/customer_manager", "user", "password");

			String sql = "SELECT * FROM m_user";
			String searchName = request.getParameter("searchName");

			if (searchName != null && !searchName.isEmpty()) {
				sql += " WHERE name LIKE ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchName + "%");
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					Map<String, String> customer = new HashMap<>();
					customer.put("name", rs.getString("name"));
					customer.put("kana", rs.getString("kana"));
					customer.put("zipcode", rs.getString("zipcode"));
					customer.put("area", rs.getString("area"));
					customer.put("gender", rs.getString("gender"));
					customer.put("birthday", rs.getString("birthday"));
					customer.put("tel", rs.getString("tel"));
					customers.add(customer);
				}
				rs.close();
				pstmt.close();

			} else {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Map<String, String> customer = new HashMap<>();
					customer.put("name", rs.getString("name"));
					customer.put("kana", rs.getString("kana"));
					customer.put("zipcode", rs.getString("zipcode"));
					customer.put("area", rs.getString("area"));
					customer.put("gender", rs.getString("gender"));
					customer.put("birthday", rs.getString("birthday"));
					customer.put("tel", rs.getString("tel"));
					customers.add(customer);
				}
				rs.close();
				stmt.close();

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		request.setAttribute("customers", customers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
	}
}
