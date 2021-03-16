package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sort;
import service.SortService;

public class FindSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String sort_id = request.getParameter("sort_id");
		String sort_name = request.getParameter("sort_name");
		SortService service = new SortService();
		List<Sort> sortList = service.findByManyCondition(sort_id, sort_name);
		request.setAttribute("sortsFromDB", sortList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/sort/find.jsp");
		dispatcher.forward(request, response);
	}

}
