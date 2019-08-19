package serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.User;
import db.UserDao;
import db.UserDaoImpl;


public class Login extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("接收到请求了");
		//获取参数
		String username = req.getParameter("username");
		
		String password = req.getParameter("password");
			
		//放回json
		User user = new User(username,password,"");
		
		User user2 = new UserDaoImpl().checkUserNameAndPssword(user);
		
		String json = "";
		if (user2 !=null) {
			json =  new Gson().toJson(user2);
		}else {
			json = "账号或密码错误";
		}
		

		System.out.print(json);
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(json);
		out.flush();
		out.close();

		
		System.out.println("响应请求");
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
