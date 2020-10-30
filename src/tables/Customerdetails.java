package tables;
import java.util.Scanner;

public class Customerdetails {

static Scanner scanner = new Scanner(System.in);

static Customerdb  dbcustomer = new Customerdb();

public static void main(String[] args) {
adminLogin();

}

private static void adminLogin() {

scanner = new Scanner(System.in);
System.out.println(" WELCOME TO ADMIN LOGIN \n Login Name : ");
String adminName = scanner.nextLine();
System.out.println("Enter Password");
String apassword = scanner.nextLine();
if (adminName.equals("admin") && apassword.equals("admin")) {
adminSection();
} else {
System.out.println("Incorrect Name or Password");
adminLogin();
}
}

private static void adminSection() {
System.out.println(" ADMIN SECTIONS \n 1.Add Customers \n 2.View Customers \n 3.Delete Customers \n 4.Update Customers \n 5.Log out \n Enter your choice ");
int choice = scanner.nextInt();
do {
switch (choice) {
case 1:
addCustomers();
break;
case 2:
viewCustomers();
break;
case 3:
deleteCustomers();
break;
case 4:
updateCustomerDetails();
break;
case 5:
System.exit(0);
}
} while (choice > 0 && choice <= 4);

}

public static void addCustomers() {
System.out.println(" Add A New Customer \n Enter the Customer Id  ");
scanner = new Scanner(System.in);
int customerId = scanner.nextInt();
System.out.println("Enter the CustomerName");
String customerName = scanner.next();
System.out.println("Enter the Customercity");
String customercity = scanner.next();
System.out.println("Enter the Customercountry");
String customercountry = scanner.next();

dbcustomer.insertCustomerdetails(customerId, customerName, customercity, customercountry);
adminSection();
}

private static void viewCustomers() {

System.out.println(" DISPLAY Customer DETAILS \n1.View Full Customer Details \n 2.View Paticular Customer Details \n 3.Go TO Admin Section \n Enter Your Choice");
int viewChoice = scanner.nextInt();
switch (viewChoice) {
case 1:
System.out.println("Display the whole Employee Details");
dbcustomer.displayWholeCustomer();
break;
case 2:
System.out.println("Display the Distinct Customer Details");
System.out.println("Enter the Customer Id");
int viewId = scanner.nextInt();
dbcustomer.displayParticularCustomer(viewId);
break;
case 3:
adminSection();
break;
}
viewCustomers();
}

private static void deleteCustomers() {
System.out.println("DELETING PARTICULAR  DETAILS");
System.out.println("Enter the Customer Id");
int deleteId =  scanner.nextInt();
dbcustomer.delete(deleteId);
adminSection();
}

private static void updateCustomerDetails() {
System.out.println("UPDATE THE Customer DETAILS \n 1.Update Customer Name \n 2.Update Customercountry \n 3.Update Customercity \n 4.Go to Admin Section \n Enter your Choice ");
int updateChoice = scanner.nextInt();
switch (updateChoice) {
case 1:
System.out.println("Update Customer Name \n Enter the Customer  Id");
int updateCustomerId = scanner.nextInt();
System.out.println("Enter the modifying Customer Name");
String updateCustomerName = scanner.next();
dbcustomer.updatecustomerName(updateCustomerId, updateCustomerName);
break;
case 2:
System.out.println("Update customer country \n Enter the customerId ");
int updatecustomerid =scanner.nextInt();
System.out.println("Enter the modifying country");
String updatecountry= scanner.next();
dbcustomer.updatecountry(updatecustomerid, updatecountry);
break;
case 3:
System.out.println("Update customers \n Enter the customer Id ");
updatecustomerid =scanner.nextInt();
System.out.println("Enter the modifying customercity");
String updatecustomercity= scanner.next();
dbcustomer.updatecustomercity(updatecustomerid, updatecustomercity);
break;
case 4:
adminSection();
break;
}
updateCustomerDetails();
}
}


