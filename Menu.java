package mobileOperator;

import java.util.Scanner;

public class Menu {
	public static void mainMenu() {
		System.out.println("* 1.Login as user    *");
		System.out.println("* 2.Login as admin   *");
		System.out.println("* 3.Register user    *");
		System.out.println("* 4.Register as admin*");
		System.out.println("* 5.Exit             *");
	Scanner scanner = new Scanner(System.in);
	int choice=scanner.nextInt();
	switch (choice) {
	  case 1:
	   Checks.checkForUser(); 
	break;
	  case 2:
	    Checks.checkForAdmin();
	    break;
	  case 3:
		  Register.setUserInDatabase(Register.createUser());
	    break;
	  case 4:
		  Register.setAdminInDatabase(Register.createAdmin());
	    break;
	  case 5 :
		   System.exit(0);
	  default:
	    System.out.println("Looking forward to the Weekend");
	}
scanner.close();
}
	
	
	public static void menuForAdmin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Add user");
		System.out.println("2.Add service");
		System.out.println("3.Show unpaid services");
		System.out.println("4.Show user services");
		System.out.println("5.Show username by type of service");
		System.out.println("6.Exit");
		int choice=scanner.nextInt();
		switch (choice) {
		  case 1:
			  Register.setUserInDatabase(Register.createUser());
		    break;
		  case 2:
			  ServiceStorage.setServiceInDatabase(ServiceStorage.createService());
		    break;
		  case 3:
			  AdminOperations.unpaidServices();
		    break;
		  case 4:
			  AdminOperations.showServiceByUserName();
		    break;
		  case 5 :
		    AdminOperations.showUserNameByTypeOfService();
		    break;
		  case 6 :
			   System.exit(0);
		  default:
		    System.out.println("Please choose another option!");
	}
		scanner.close();
	}
	
	


	
}
