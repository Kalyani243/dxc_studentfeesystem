package feeDetails;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class Accountant {

        String url="jdbc:mysql://Localhost:3306?user=Hostroot&password=Kalyani@1234";
		public void select(BufferedReader buf)
		{
			String query="select accemail from feedue.accdetails where accid=?";
			try
			{
				Connection conn=DriverManager.getConnection(url);
				System.out.println("step1");
				PreparedStatement preparedStatement=conn.prepareStatement(query);
				System.out.println("step2");
				System.out.println("Enter your account id");
				int accid=Integer.parseInt(buf.readLine());
				preparedStatement.setInt(1,accid);
				ResultSet resultSet=preparedStatement.executeQuery();
				System.out.println("step3");
				while(resultSet.next())
				{
					String accemail=resultSet.getString("accemail");
					System.out.println("login successfully" +accemail);
					
					
				}
				System.out.println("step4");
				conn.close();
				System.out.println("step5");
				
			}
		
			catch(Exception e)
			{
				 e.printStackTrace();
			}
			
		}
		public void addstudent(BufferedReader buf) 
		{
			String query=("insert into feedue.student values(?,?,?,?,?,?,?,?,?,?)");
			
				
				try
				{
					Connection conn= DriverManager.getConnection(url);
				System.out.println("step1");
				PreparedStatement ps=conn.prepareStatement(query);
				
				System.out.println("enter the StudentName ");
				String student_name=buf.readLine();
				ps.setString(1, student_name); 
				
				System.out.println("enter the Email ");
				String student_email=buf.readLine();
				ps.setString(2, student_email);
				
				System.out.println("enter the Course");
				String student_course =buf.readLine();
				ps.setString(3, student_course);
				
				System.out.println("enter the Fee ");
				String student_fee =buf.readLine();
				ps.setString(4, student_fee);
				
				System.out.println("enter the due");
				String student_due=buf.readLine();
				ps.setString(5, student_due);
				
				System.out.println("enter the adress ");
				String student_address=buf.readLine();
				
				ps.setString(6, student_address);
				
				System.out.println("enter the city ");
				String student_city=buf.readLine();
				ps.setString(7, student_city);
				
				System.out.println("enter the state ");
				String student_state=buf.readLine();
		        ps.setString(8, student_state);
				
				System.out.println("enter the country");
				String student_country=buf.readLine();
				ps.setString(9,student_country);
				
				System.out.println("enter the phno ");
				String student_phno=buf.readLine();
				ps.setString(10,student_phno);
				
				
				ps.executeUpdate();
				conn.close();
				System.out.println("step5");
				} 
				
				
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		public void viewstudent(BufferedReader buf)
		{
			String query="select student_name from feedue.student where student_phno=?";
			try
			{
				Connection conn=DriverManager.getConnection(url);
				System.out.println("step1");
				PreparedStatement preparedStatement=conn.prepareStatement(query);
				System.out.println("step2");
				System.out.println("Enter student phno");
				String student_phno=buf.readLine();
				preparedStatement.setString(1, student_phno);
				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next())
				{
					String studentname=resultSet.getString("student_name");
					System.out.println("student data viewed successfully"+studentname);
				}
				conn.close();
			}
			catch(IOException e)
			 {
				 e.printStackTrace();
			 }
				catch(SQLException e)
				{
					e.printStackTrace();
				}
		}
		
public void editstudent(BufferedReader buf)
{
	
	String query="update student  set student_name=? where student_city=?";
	try
	{
		Connection conn=DriverManager.getConnection(url);
		System.out.println("step1");
		PreparedStatement preparedStatement=conn.prepareStatement(query);
		System.out.println("step2");
		preparedStatement.setString(1,"shiva");
		preparedStatement.setString(2,"hyderabad");
		System.out.println(preparedStatement.executeUpdate() + " No of Records Updated");
		System.out.println("step3");
		conn.close();
		
	}
		catch(SQLException e)
	{
		e.printStackTrace();
	}
}
public void viewdue(BufferedReader buf)
{
	String query="select student_due from feedue.student where student_phno=?";
	try
	{
		Connection conn=DriverManager.getConnection(url);
		System.out.println("step1");
		PreparedStatement preparedStatement=conn.prepareStatement(query);
		System.out.println("step2");
		System.out.println("Enter student phno");
		String student_phno=buf.readLine();
		preparedStatement.setString(1, student_phno);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			String studentdue=resultSet.getString("student_due");
			System.out.println("student data viewed successfully"+studentdue);
		}
		conn.close();
	}
	catch(IOException e)
	 {
		 e.printStackTrace();
	 }
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
public void logout()
{
System.out.println("logout successfully");
}	

}
	


