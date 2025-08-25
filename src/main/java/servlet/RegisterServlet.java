package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.AreaDAO;
import model.entity.AreaBean;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AreaDAO dao = new AreaDAO();
		List<AreaBean> areaList = dao.findAll();

		// デバッグ用に内容を印刷（サーバーのコンソールに出ます）
		System.out.println("areaList size: " + areaList.size());
		for (AreaBean area : areaList) {
			System.out.println(area.getAreaCode() + ": " + area.getAreaName());
		}
		request.setAttribute("areaList", areaList);
		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

	// 顧客登録処理：POST時
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String customer_id = request.getParameter("customer_id");
		String customer_name = request.getParameter("customer_name");
		String post_code = request.getParameter("post_code");
		String area_code = request.getParameter("area_code");

		String genderParam = request.getParameter("gender"); // フォームからの値（例："男性"）

		String gender = null;
		if ("男性".equals(genderParam)) {
			gender = "M";
		} else if ("女性".equals(genderParam)) {
			gender = "F";
		}

		String birthday = request.getParameter("birthday");
		String phone_number = request.getParameter("phone_number");

		String format = "yyyy-MM-dd HH:mm:ss";
		String now = new SimpleDateFormat(format).format(new Date());
		String insert_datetime = now;
		String update_datetime = now;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/customer_manager?useSSL=false&serverTimezone=Asia/Tokyo";
			String user = "customer_managerU";
			String password = "customer_managerP";

			try (Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(
							"INSERT INTO m_customer (customer_id, customer_name, post_code, area_code, gender, birthday, phone_number, insert_datetime, update_datetime) "
									+
									"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
				pstmt.setString(1, customer_id);
				pstmt.setString(2, customer_name);
				pstmt.setString(3, post_code);
				pstmt.setString(4, area_code);
				pstmt.setString(5, gender);
				pstmt.setString(6, birthday);
				pstmt.setString(7, phone_number);
				pstmt.setString(8, insert_datetime);
				pstmt.setString(9, update_datetime);

				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("list.jsp");
	}
}
