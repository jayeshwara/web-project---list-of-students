package fgd;

import java.io.IOException;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Servlet implementation class Tm
 */
@WebServlet("/Tm") 
public class Tm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tm() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("Name");
		String dept = request.getParameter("Department");
		String section = request.getParameter("Section");
		String rollno = request.getParameter("Roll.no");
		String address = request.getParameter("Address");
		String phoneno = request.getParameter("Phone.no");
		Connection con = null;
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datas","root","1210");
    		PreparedStatement pstmt = con.prepareStatement
			("insert into Student(name,dept,section,rollno,address,phoneno)" + "valeus(?,?,?,?,?,?)");
    		pstmt.setString(1,name);
    		pstmt.setString(2,dept);
    		pstmt.setString(3,section);
    		pstmt.setString(4,rollno);
    		pstmt.setString(5,address);
    		pstmt.setString(6,phoneno);
    		
    		int rowcount = pstmt.executeUpdate(); 
    		if(rowcount > 0) 
    			request.setAttribute("status","success"); 
    		}
    		else 
    		{
    			request.setAttribute("status","failed");
    		}
    		
    		request.getRequestDispatcher("NewFile3.jsp").forward(request,response);
    	}
    		
    		catch (Exception e) 
    		{
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		finally
    		{
    			try {
    				con.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}

    	}
    }

