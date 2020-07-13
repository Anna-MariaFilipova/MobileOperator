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
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter email and password:");
			Scanner userScanner = new Scanner(System.in);
            String searchedEmailUser = userScanner.nextLine();
			String searchedPasswordUser = userScanner.nextLine();
			Checks.checkForUser(searchedEmailUser, searchedPasswordUser);
			break;
			
		case 2:
			System.out.println("Enter email and password:");
			Scanner admin = new Scanner(System.in);
			String searchedEmailAdmin = admin.nextLine();
			String searchedPasswordAdmin = admin.nextLine();
			Checks.checkForAdmin(searchedEmailAdmin, searchedPasswordAdmin);
			break;
			
		case 3:
			Scanner inUser = new Scanner(System.in);
			System.out.println("Enter name, email and password:");
			String nameUser = inUser.nextLine();
			String emailUser = inUser.nextLine();
			String passwordUser = inUser.nextLine();
			Register.setUserInDatabase(Register.createUser(nameUser, emailUser, passwordUser));
			break;
			
		case 4:
			Scanner inAdmin = new Scanner(System.in);
			System.out.println("Enter name, email and password:");
			String nameAdmin = inAdmin.nextLine();
			String emailAdmin = inAdmin.nextLine();
			String passwordAdmin = inAdmin.nextLine();
			Register.setAdminInDatabase(Register.createAdmin(nameAdmin, emailAdmin, passwordAdmin));
			break;
			
		case 5:
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
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			Scanner inUser = new Scanner(System.in);
			System.out.println("Enter name, email and password:");
			String name = inUser.nextLine();
			String email = inUser.nextLine();
			String password = inUser.nextLine();
			Register.setUserInDatabase(Register.createUser(name, email, password));

			break;
		case 2:
			ServiceStorage.setServiceInDatabase(ServiceStorage.createService());
			break;
		case 3:
			AdminOperations.unpaidServices();
			break;
		case 4:
			Scanner search = new Scanner(System.in);
			 System.out.println("Enter name:");
			 String searchedname=search.nextLine();
			AdminOperations.showServiceByUserName(searchedname);
			break;
		case 5:
			 Scanner inType = new Scanner(System.in);
			 System.out.println("Enter service:");
			 String searchedTypeService=inType.nextLine();
			AdminOperations.showUserNameByTypeOfService(searchedTypeService);
			break;
		case 6:
			System.exit(0);
		default:
			System.out.println("Please choose another option!");
		}
		scanner.close();
	}

}
