

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class customerdetails {

	public static boolean checkcustomer(String bookid){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from customer where c_id=?");
			ps.setString(1,bookid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int insertcustomer(String c_id,String cname,String phn_no,String address){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into customer(c_id,cname,phn_no,address) values(?,?,?,?)");
			ps.setString(1,c_id);
			ps.setString(2,cname);
			ps.setString(3,phn_no);
			ps.setString(4,address);
			
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deletecustomer(String id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from customer where c_id=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}


