package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sort;
import service.SortService;
import utils.Page;

public class GetSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 10;
		int pageIndex = 1;
		Object pageSizeStr = request.getParameter("pageSize");
		Object pageIndexStr = request.getParameter("pageIndex");
		if (pageSizeStr != null)
			pageSize = Integer.parseInt(pageSizeStr.toString());
		if (pageIndexStr != null)
			pageIndex = Integer.parseInt(pageIndexStr.toString());
		SortService ss = new SortService();
		Page<Sort> sortList = ss.getAllByPage(pageIndex, pageSize);
		request.setAttribute("sortsFromDB", sortList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/sort/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
