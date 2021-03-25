package com.registration.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration.dao.UserDAO;
import com.registration.model.User;

@WebServlet("/")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO =null;
	
    public UserController() {
       	userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String path = request.getServletPath();
			switch(path) {
			case "/newUser":
				showUserForm(request, response);
				break;
			case "/editUser":
				showEditUserForm(request, response);
				break;
			case "/deleteUser":
				showDeleteUser(request, response);
				break;
			case "/insertUser":
				insertUserData(request, response);
				break;
			case "/updateUser":
				updateUserData(request, response);
				break;
			default:
				listOfUsers(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateUserData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String emailId = request.getParameter("emailId");
		String country = request.getParameter("country");
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = new User();
		user.setName(name);
		user.setEmailId(emailId);
		user.setCountry(country);
		user.setId(id);
		
		boolean isUpdated = userDAO.updateUser(user);
		if(isUpdated) {
			response.sendRedirect("/WebApplicationDemo/");
		}else {
			System.out.println("Error");
		}
		
		
	}

	private void insertUserData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String emailId = request.getParameter("emailId");
		String country = request.getParameter("country");
		
		User user = new User();
		user.setName(name);
		user.setEmailId(emailId);
		user.setCountry(country);
		
		int count = userDAO.insertUser(user);
		if(count>0) {
			response.sendRedirect("/WebApplicationDemo/");
		}else {
			System.out.println("Error");
		}
		
		
	}

	private void showDeleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean isDeleted = userDAO.deleteUser(id);
		if(isDeleted) {
			response.sendRedirect("/WebApplicationDemo/");
		}else {
			System.out.println("Error");
		}
		
	}

	private void showEditUserForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userDAO.getUser(id);
		RequestDispatcher rd = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", user);
		rd.forward(request, response);
	}

	private void showUserForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("user-form.jsp");
		rd.forward(request, response);
	}

	private void listOfUsers(HttpServletRequest request, HttpServletResponse response)
			throws Exception, ServletException, IOException {
		List<User> listOfUsers = userDAO.getAllUsers();
		request.setAttribute("listOfUsers", listOfUsers);
		RequestDispatcher rd = request.getRequestDispatcher("user-list.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
