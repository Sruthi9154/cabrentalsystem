




	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class invoicedetails {

		public static boolean checkinvoice(String billid){
			boolean status=false;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from invoice where bill_id=?");
				ps.setString(1,billid);
			    ResultSet rs=ps.executeQuery();
				status=rs.next();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
		public static int insertinvoice(String bill_id,String bill_date,int totalamount,String book_id){
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into invoice(bill_id,bill_date,totalamount,book_id) values(?,?,?,?)");
				ps.setString(1,bill_id);
				ps.setString(2,bill_date);
				ps.setInt(3,totalamount);
				ps.setString(4,book_id);
				
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
		public static int deleteinvoice(String id){
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from invoice where bill_id=?");
				ps.setString(1,id);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
	}

