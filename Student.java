/*
Andrew Grosskurth
CIST 2372
Lab # 5
*/

import java.sql.*;

class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private String email;
	private double gpa;
	
	public Student()
	{
		id = 0;
		firstName = "";
		lastName = "";
		street = "";
		city = "";
		state = "";
		zipcode = 0;
		email = "";
		gpa = 0;
	}
	
	public Student(int uid, String ufn, String uln, String ustr, String ucity, String usta, int uzip, String uem, double ugpa)
	{
		id = uid;
		firstName = ufn;
		lastName = uln;
		street = ustr;
		city = ucity;
		state = usta;
		zipcode = uzip;
		email = uem;
		gpa = ugpa;
	}
	
	public void setFirstName(String fn)
	{
		firstName = fn;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setLastName(String ln)
	{
		lastName = ln;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setID(int nid)
	{
		id = nid;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setStreet(String str)
	{
		street = str;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public void setCity(String cit)
	{
		city = cit;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setState(String sta)
	{
		state = sta;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setZipcode(int zip)
	{
		zipcode = zip;
	}
	
	public int getZipcode()
	{
		return zipcode;
	}
	
	public void setEMail(String em)
	{
		email = em;
	}
	
	public String getEMail()
	{
		return email;
	}
	
	public void setGPA(double ngpa)
	{
		gpa = ngpa;
	}
	
	public double getGPA()
	{
		return gpa;
	}
	
	public void display()
	{
		System.out.println("ID: " + id);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Street: " + street);
		System.out.println("City: " + city);
		System.out.println("State: " + state);
		System.out.println("Zipcode: " + zipcode);
		System.out.println("EMail: " + email);
		System.out.println("GPA: " + gpa);
	}

	public void selectDB(int sid)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:JavaDB1");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Students WHERE ID=" + sid);
			while(rs.next())
			{
				id = rs.getInt(1);
				firstName = rs.getString(2);
				lastName = rs.getString(3);
				street = rs.getString(4);
				city = rs.getString(5);
				state = rs.getString(6);
				zipcode = rs.getInt(7);
				email = rs.getString(8);
				gpa = rs.getDouble(9);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void insertDB(int dbID, String dbFN, String dbLN, String dbSTR, String dbCITY, String dbSTA, int dbZIP, String dbEM, double dbGPA)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:JavaDB1");
			PreparedStatement prep = con.prepareStatement("INSERT INTO Students(ID, FirstName, LastName, Street, City, State, Zip, EMail, GPA) VALUES(?,?,?,?,?,?,?,?,?)");
			prep.setInt(1, dbID);
			prep.setString(2, dbFN);
			prep.setString(3, dbLN);
			prep.setString(4, dbSTR);
			prep.setString(5, dbCITY);
			prep.setString(6, dbSTA);
			prep.setInt(7, dbZIP);
			prep.setString(8, dbEM);
			prep.setDouble(9, dbGPA);
			prep.executeUpdate();
			con.close();
			
			id = dbID;
			firstName = dbFN;
			lastName = dbLN;
			street = dbSTR;
			city = dbCITY;
			state = dbSTA;
			zipcode = dbZIP;
			email = dbEM;
			gpa = dbGPA;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void updateDB()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:JavaDB1");
			PreparedStatement prep = con.prepareStatement("UPDATE Students SET FirstName = ?, LastName = ?, Street = ?, City = ?, State = ?, Zip = ?, EMail = ?, GPA = ? WHERE ID = ?");
			prep.setString(1, firstName);
			prep.setString(2, lastName);
			prep.setString(3, street);
			prep.setString(4, city);
			prep.setString(5, state);
			prep.setInt(6, zipcode);
			prep.setString(7, email);
			prep.setDouble(8, gpa);
			prep.setInt(9, id);
			prep.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void deleteDB()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:JavaDB1");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM Students WHERE ID=" + id);
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String args[])
	{
		Student s3 = new Student();
		s3.selectDB(6);
		s3.deleteDB();
	}
}