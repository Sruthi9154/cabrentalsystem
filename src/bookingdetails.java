

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class bookingdetails {

		public static boolean checkbooking(String b_id){
			boolean status=false;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from booking_details where book_id=?");
				ps.setString(1,b_id);
			    ResultSet rs=ps.executeQuery();
				status=rs.next();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
		public static int insertbooking(String book_id,String c_id,String v_id,int no_ofdays){
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into booking_details(book_id,c_id,v_id,no_of_days) values(?,?,?,?)");
				ps.setString(1,book_id);
				ps.setString(2,c_id);
				ps.setString(3,v_id);
				ps.setInt(4,no_ofdays);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
		public static int deletebooking(String id){
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from booking_details where book_id=?");
				ps.setString(1,id);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
	
}
