package tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Customerdb{

static Scanner scanner = new Scanner(System.in);

public int customerId;
public String customerName;
public String customercity;
public String customercountry;

public static Connection connect() {
try {
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost/Student Details", "root", "root");
return c;
}catch (Exception e) {
e.printStackTrace();
}
return null;

}

public void insertCustomerdetails(int cusId, String cusName, String cuscount, String cuscity) {

customerId = cusId;
customerName = cusName;
customercountry= cuscount;
customercity = cuscity;

try {
Connection connect = connect();
PreparedStatement preparestmt = connect.prepareStatement("insert into customersource values(?,?,?,?)");

do {
preparestmt.setInt(1, customerId);
preparestmt.setString(2, customerName);
preparestmt.setString(3, customercity);
preparestmt.setString(4, customercountry);
int count = preparestmt.executeUpdate();
System.out.println(count + " customers is Added ");

System.out.println("Do you want to continue: y/n");
String choice = scanner.next();

if (choice.startsWith("n")) {
break;
} else
Customerdetails.addCustomers();
} while (true);
} catch (Exception e) {
e.printStackTrace();
}
}

public void displayWholeCustomer() {
try {
Connection c = connect();
Statement s = c.createStatement();

ResultSet r = s.executeQuery("select * from customersource");
while (r.next()) {
System.out.println(r.getString("customerid") + ", " + r.getString("customername") + ", " + r.getString("customercountry")
+ ", " + r.getString("customercity"));
}

} catch (Exception e) {
e.printStackTrace();
}
}

public void displayParticularCustomer(int id) {
int cusid = id;
try {
Connection c = connect();
Statement s = c.createStatement();

ResultSet r = s.executeQuery("select * from customersource where cusid=" + cusid);
while (r.next()) {
System.out.println(r.getString("customerid") + ", " + r.getString("customername") + ", " + r.getString("customercountry")
+ ", " + r.getString("customercity"));
}

} catch (Exception e) {
e.printStackTrace();
System.out.println("Id not Fount");
}

}

public void updatecustomerName(int id, String customerName) {
try {
int cusid = id;
String cusname = customerName;
Connection c = connect();
Statement s = c.createStatement();
s.executeUpdate("update customersource set customername='" + cusname + "'where customerid=" + cusid);

System.out.println("customer  Name is Updated");
} catch (Exception e) {
e.printStackTrace();
}

}

public void updatecountry(int id, String  country) {
try {
int cusid = id;
String coun = country;

Connection c = connect();
Statement s = c.createStatement();
s.executeUpdate("update customersource set customercountry='" + coun + "'where customerid=" + cusid);
System.out.println("country is Updated");
} catch (Exception e) {
e.printStackTrace();
}

}

public void updatecustomercity(int id, String customercity) {
try {
int cusid = id;
String cust = customercity;
Connection c = connect();
Statement s = c.createStatement();
s.executeUpdate("update customersource set customercity='" + cust + "'where customerid=" + cusid);

System.out.println("customercity is Updated");
} catch (Exception e) {
e.printStackTrace();
}

}

public void delete(int id) {
try {
int cusId = id;
Connection c = connect();
PreparedStatement p = c.prepareStatement("delete from customersource where customerid=" + cusId);
int j = p.executeUpdate();
System.out.println(j + "is Deleted");
} catch (Exception e) {
e.printStackTrace();
}

}
	
}



