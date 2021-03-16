package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sort;
import service.SortService;

public class AddSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String sort_id = request.getParameter("sort_id");
		String sort_name = request.getParameter("sort_name");
		Sort sort = new Sort(sort_id, sort_name);
		SortService sortService = new SortService();
		if (sortService.add(sort)) {
			response.getWriter().print("<script>alert('添加类别成功'); window.location.href='" + request.getContextPath()
					+ "/GetSortServlet'</script>");
		} else {
			response.getWriter().print("<script>alert('添加类别失败'); window.location.href='" + request.getContextPath()
					+ "/admin/sort/AddSort.jsp'</script>");
		}
	}

}
