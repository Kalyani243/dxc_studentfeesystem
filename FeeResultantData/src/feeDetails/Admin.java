package feeDetails;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

import java.sql.*;

public class Admin {

	String url="jdbc:mysql://localhost:3306?user=Hostroot&password=Kalyani@1234";
		public void insert(BufferedReader buf)
		{
			String query="insert into feedue.admin values(?,?)";
			try
			{
				
				Connection conn=DriverManager.getConnection(url);
				System.out.println("step1");
				PreparedStatement preparedStatement=conn.prepareStatement(query);
				System.out.println("step2");
				
				System.out.println("Enter username");
				String username=buf.readLine();
				preparedStatement.setString(1,username);
				System.out.println("Enter password");
				String password=buf.readLine();
				
				 preparedStatement.setString(2,password );
				 preparedStatement.executeUpdate();
				 System.out.println("step3");
				 conn.close();
				 System.out.println("step5");
				 
			}
			catch(IOException e)
			 {
				 e.printStackTrace();
			 }
			
			catch(SQLException s)
			{
				s.printStackTrace();
			}
		}
				public void select(BufferedReader buf) 
				{
					String query="select username from feedue.admin where password=?";
					try
					{
						Connection conn=DriverManager.getConnection(url);
						System.out.println("step1");
						PreparedStatement preparedStatement=conn.prepareStatement(query);
						System.out.println("step2");
						System.out.println("Enter password");
						String password=buf.readLine();
						preparedStatement.setString(1, password);
						ResultSet resultSet=preparedStatement.executeQuery();
						while(resultSet.next())
						{
							String username=resultSet.getString("username");
							System.out.println("login successfully"+username);
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
				public void addaccountant(BufferedReader buf)
				{
					String query="insert into feedue.accdetails values(?,?,?,?)";
					try
					{
						
						Connection conn=DriverManager.getConnection(url);
						System.out.println("step1");
						PreparedStatement preparedStatement=conn.prepareStatement(query);
						System.out.println("step2");
						
						
						System.out.println("Enter account id");
						int accid=Integer.parseInt(buf.readLine());
						preparedStatement.setInt(1, accid);
						
						
						System.out.println("Enter account password");
						int accpwd=Integer.parseInt(buf.readLine());
						preparedStatement.setInt(2,accpwd);
						
						
						System.out.println("Enter account email");
						String accemail=buf.readLine();
						preparedStatement.setString(3, accemail);
						
						
						System.out.println("Enter account phno");
		               String accphno=(buf.readLine());
						preparedStatement.setString(4, accphno);
						
						 
						 preparedStatement.executeUpdate();
						 System.out.println("step3");
						 conn.close();
						 System.out.println("step5");
					}
					catch(IOException e)
					 {
						 e.printStackTrace();
					 }
					catch(SQLException s)
					{
						s.printStackTrace();
					}
				}
				public void viewaccountant(BufferedReader buf) 
				{
					String query="select accid from feedue.accdetails where accphno=?";
					try
					{
						Connection conn=DriverManager.getConnection(url);
						System.out.println("step1");
						PreparedStatement preparedStatement=conn.prepareStatement(query);
						System.out.println("step2");
						System.out.println("Enter account phnum");
						String accphno=(buf.readLine());
						preparedStatement.setString(1, accphno);
						ResultSet resultSet=preparedStatement.executeQuery();
						while(resultSet.next())
						{
							int accid=resultSet.getInt("accid");
							System.out.println("login successfully"+accid);
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
						
					
				
				
				
				
    
	


