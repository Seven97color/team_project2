package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//フォームから送信された値を取得
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		try {
			UserDAO userDAO = new UserDAO();
			UserBean user = userDAO.checkLogin(id, password);

			if (user != null) {
				// 認証成功 → セッションにユーザー情報を保存
				request.getSession().setAttribute("loginUser", user.getUserId());
				response.sendRedirect("menu.jsp");
			} else {
				// 認証失敗
				request.setAttribute("error", "ログイン失敗しました。もう一度入力してください。");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "システムエラーが発生しました");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	//仮の認証（本来はDB等でチェック）GETリクエストはログイン画面を表示するようにしても良い
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
