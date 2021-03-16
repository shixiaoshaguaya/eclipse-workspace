package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sort;
import service.SortService;

public class EditSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String sort_id = request.getParameter("sort_id");
		Sort sort = null;
		if (sort_id == null) {
			response.getWriter().print("请选择要修改的类别！<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}else{
			SortService sortService  = new SortService();
			sort = sortService.getById(sort_id);
		}
		request.setAttribute("sort", sort);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/sort/EditSort.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String sort_id = request.getParameter("sort_id");
		String sort_name = request.getParameter("sort_name");
		Sort sort = new Sort(sort_id, sort_name);
		SortService sortService = new SortService();
		if(sortService.update(sort)) {
			response.getWriter().print("<script>alert('修改成功'); window.location.href='" + request.getContextPath() + "/GetSortServlet'</script>");
		} else {
			response.getWriter().print("类别修改失败：" + "<INPUT type='button' onclick='history.go(-1)' value='返回' />");
		}
	}

}
