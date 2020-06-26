package feeDetails;
import java.io.*; 
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class EntireFeeDetail {
	InputStreamReader isr=null;
	BufferedReader buf=null;
	Admin a1=null;
	Accountant a2=null;
	

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		EntireFeeDetail e=new EntireFeeDetail();

		
		System.out.println("welcome to fees resultant system");
		e.isr=new InputStreamReader(System.in);
		 e.buf=new BufferedReader(e.isr);
		System.out.println("select your chioce\n1. Admin\n2. Accountant");
		
		String chioce=e.buf.readLine();
		if(chioce.equalsIgnoreCase("1"))
				{
		 e.a1=new Admin();
		e.a1.insert(e.buf);
		e.a1.select(e.buf);
		e.a1.addaccountant(e.buf);
		e.a1.viewaccountant(e.buf);
				}
		else if(chioce.equalsIgnoreCase("2"))
		{
			e.a2=new Accountant();
			e.a2.select(e.buf);
			e.a2.addstudent(e.buf);
			e.a2.viewstudent(e.buf);
		    e.a2.editstudent(e.buf);
		    e.a2.viewdue(e.buf);
		    e.a2.logout();
		}
		
			
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
	}


