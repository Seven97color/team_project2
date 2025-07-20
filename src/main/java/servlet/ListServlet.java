package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CustomerDAO;
import model.entity.CustomerBean;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        CustomerDAO dao = new CustomerDAO();
        try {
            List<CustomerBean> customers = dao.findAll();
            request.setAttribute("customers", customers);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "顧客の取得に失敗しました");
        }
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
