package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("customer_Name");
        String kana = request.getParameter("customer_kana");
        String zipcode = request.getParameter("zipcode");
        String area = request.getParameter("area");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String tel = request.getParameter("tel");

        // データベース接続
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/customer_manager", "m_user", "pass");
            String sql = "INSERT INTO customers (name, kana, zipcode, area, gender, birthday, tel) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, kana);
            pstmt.setString(3, zipcode);
            pstmt.setString(4, area);
            pstmt.setString(5, gender);
            pstmt.setString(6, birthday);
            pstmt.setString(7, tel);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 登録後は顧客一覧画面へリダイレクト
        response.sendRedirect("list.jsp");
    }
}
