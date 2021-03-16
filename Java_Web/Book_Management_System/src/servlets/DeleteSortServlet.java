package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SortService;

public class DeleteSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String sort_id = request.getParameter("sort_id");
		SortService sortService = new SortService();
		if (sortService.deleteById(sort_id)) {
			response.getWriter().print("<script>alert('删除成功'); window.location.href='" + request.getContextPath() + "/GetSortServlet'</script>");
		} else {
			response.getWriter().print("删除类别失败！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
