package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String button = request.getParameter("button");
		System.out.println("button=" + button);

		if ("顧客一覧".equals(button)) {
			response.sendRedirect("ListServlet");
		} else if ("顧客登録".equals(button)) {
			response.sendRedirect("RegisterServlet"); // 顧客登録画面のJSP名
		} else if ("権限編集".equals(button)) {
			response.sendRedirect("");
		} else {
			// デフォルトはメニュー画面にリダイレクト
			response.sendRedirect("menu.jsp");
		}
	}
}
