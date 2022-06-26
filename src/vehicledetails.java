



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class vehicledetails {

		public static boolean checkavailability(String v_id){
			boolean status=false;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from vehicle_details where v_id=?");
				ps.setString(1,v_id);
			    ResultSet rs=ps.executeQuery();
				status=rs.next();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
		public static int insertvehicle(String v_id,String vname,float meter_reading,String availability,int costpermile){
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into vehicle_details(v_id,v_name,meter_reading,availability,costpermile) values(?,?,?,?,?)");
				ps.setString(1,v_id);
				ps.setString(2,vname);
				ps.setFloat(3,meter_reading);
				ps.setString(4,availability);
				ps.setInt(5,costpermile);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
		public static int deletevehicle(String id){
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from vehicle_details where v_id=?");
				ps.setString(1,id);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
		}
	}

