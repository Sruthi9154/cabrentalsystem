
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class updatebooking extends JFrame {

    private static final long serialVersionUID = 1L;
    static updatebooking frame;
    private JPanel contentPane;
    private JTextField TextField;
    private JLabel lblcid;
    private JTextField TextField1;
    private JLabel lblcustomername;
    private JTextField TextField2;
    private JLabel lblRecustomername;
    private JTextField TextField3;
    private JLabel lbladdress;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new updatebooking();
					frame.setTitle("Modify customer Info.");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    /**
     * Create the frame.
     */
    public updatebooking() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 95, 650, 380);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        TextField = new JTextField();
        TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField.setBounds(290, 37, 326, 40);
        contentPane.add(TextField);
        TextField.setColumns(10);

        TextField1 = new JTextField();
        TextField1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField1.setBounds(290, 87, 326, 40);
        contentPane.add(TextField1);
        TextField1.setColumns(10);
        
        TextField2 = new JTextField();
        TextField2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField2.setBounds(290, 137, 326, 40);
        contentPane.add(TextField2);
        TextField2.setColumns(10);
        
        TextField3 = new JTextField();
        TextField3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField3.setBounds(290, 187, 326, 40);
        contentPane.add(TextField3);
        TextField3.setColumns(10);
        
        TextField.setText("");
		TextField1.setText("");
		TextField3.setText("");

		 Connection con = DB.getConnection();
		 
		 JButton btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	frame.dispose();
	            	booking.main(new String[]{});
	            }});
	        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(450, 275, 130, 50);
	        contentPane.add(btnBack);
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String cid = TextField.getText();
                  String cname = TextField1.getText();	
                  int phn = Integer.parseInt(TextField3.getText());
                  String add= TextField2.getText();
                if(bookingdetails.checkbooking(cid)) {
                try {

                    PreparedStatement st = con.prepareStatement("Update booking_details set c_id = ?,v_id=  ?,no_of_days =  ? where book_id=?");

                    st.setString(1, cname);
                    st.setString(2, add);
                    st.setInt(3, phn);
                    st.setString(4, cid);
                    st.executeUpdate();
                  System.out.println("updated info for booking id : " + cid);
                    JOptionPane.showMessageDialog(btnSave, "Data Updated Successfully :)");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }}
				else{
					JOptionPane.showMessageDialog(updatebooking.this,"Booking ID is Invalid !!!");
				TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
				TextField3.setText("");
            }
 

            }
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSave.setBackground(new Color(240, 240, 240));
        btnSave.setBounds(300, 275, 130, 50);
        contentPane.add(btnSave);

        lblcid = new JLabel("Booking ID :");
        lblcid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblcid.setBounds(45, 37, 326, 40);
        contentPane.add(lblcid);
        
        lblcustomername = new JLabel("Customer ID :");
        lblcustomername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblcustomername.setBounds(45, 87, 326, 40);
        contentPane.add(lblcustomername);
        
        lblRecustomername = new JLabel("Vehicle ID :");
        lblRecustomername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblRecustomername.setBounds(45, 137, 326, 40);
        contentPane.add(lblRecustomername);
        
        lbladdress = new JLabel("No oF Days  :");
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbladdress.setBounds(45, 187, 326, 40);
        contentPane.add(lbladdress);
        
        
        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String cid = TextField.getText();
            	Connection con = DB.getConnection();
            	if(bookingdetails.checkbooking(cid)) {
            	Statement st;
				try {
					PreparedStatement stmt = con.prepareStatement("select * from booking_details where book_id=?");
					stmt.setString(1,cid);
					ResultSet rs = stmt.executeQuery();
					while(rs.next())   
					{	TextField.setText(rs.getString(1));
			TextField1.setText(rs.getString(3));
			TextField2.setText(rs.getString(4));
			TextField3.setText(Integer.toString(rs.getInt(2)));
			
			}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}else {
				JOptionPane.showMessageDialog(updatebooking.this,"Customer  ID is Invalid !!!");
				TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
				TextField3.setText("");
			}

            }});
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLoad.setBackground(new Color(240, 240, 240));
        btnLoad.setBounds(150, 275, 130, 50);
        contentPane.add(btnLoad);
        
    }
}