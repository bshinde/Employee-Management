package employeeManagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import employeeManagement.dao.employeedao;
import employeeManagement.model.employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private employeedao employeedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		employeedao = new employeedao();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		this.doGet(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	   {
		
		String action = request.getServletPath();
			switch (action) {
			case "/new":
				try {
					showNewForm(request, response);
					
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;

			case "/insert":
				try {
					insertEmployee(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;
				
			case "/edit":
				try {
					showEditForm(request, response);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			case "/delete":
				try {
					deleteEmployee(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;

			case "/update":
				
				try {
					updateEmployee(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default: 
				
				try {
					listEmployee(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;
			}
		}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Employee-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		employee existingemployee = employeedao.selectEmployee(employeeId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Employee-form.jsp");
		request.setAttribute("employee", existingemployee);
		dispatcher.forward(request, response);

	}
	
	
	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String Name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String Gender = request.getParameter("Gender");
		int Salary = request.getIntHeader("Salary");
		String BirthDate = request.getParameter("BirthDate");
		employee newemployee = new employee(Name, Address, Gender, Salary, BirthDate );
		employeedao.insertEmployee(newemployee);
		response.sendRedirect("list");
	}
	
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String Name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String Gender = request.getParameter("Gender");
		int Salary = request.getIntHeader("Salary");
		String BirthDate = request.getParameter("BirthDate");
		
		employee employee = new employee(employeeId, Name, Address, Gender, Salary, BirthDate );
		employeedao.updateEmployee(employee);
		response.sendRedirect("list");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		employeedao.deleteEmployee(employeeId);
		response.sendRedirect("list");

	}
	
	
	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<employee> listemployee = employeedao.selectAllEmployee();
		request.setAttribute("listemployee", listemployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Employee-list.jsp");
		dispatcher.forward(request, response);
	}
	

	
}
		
		
		
		
		
