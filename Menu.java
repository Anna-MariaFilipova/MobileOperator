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
			Register.setUserInDatabase(nameUser, emailUser, passwordUser);
			break;

		case 4:
			Scanner inAdmin = new Scanner(System.in);
			System.out.println("Enter name, email and password:");
			String nameAdmin = inAdmin.nextLine();
			String emailAdmin = inAdmin.nextLine();
			String passwordAdmin = inAdmin.nextLine();
			Register.setAdminInDatabase(nameAdmin, emailAdmin, passwordAdmin);
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
		System.out.println("4.Search service by email");
		System.out.println("5.Search user by type of service");
		System.out.println("6.Back to main menu");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			Scanner inUser = new Scanner(System.in);
			System.out.println("Enter name, email and password:");
			String name = inUser.nextLine();
			String email = inUser.nextLine();
			String password = inUser.nextLine();
			Register.setUserInDatabase(name, email, password);
			mainMenu();
			break;
		case 2:
			Scanner inService = new Scanner(System.in);
			System.out.println(
					"Enter typeService,end of service,last payment date,count minutes,count sms,count megabytes, price,userId and isActivated:");
			String typeService = inService.nextLine();
			String endServiceStr = inService.nextLine();
			String lastPaymentDateStr = inService.nextLine();
			int countMinutes = inService.nextInt();
			int countSMS = inService.nextInt();
			int countMegabytes = inService.nextInt();
			double price = inService.nextDouble();
			int userId = inService.nextInt();
			boolean isActivated = inService.nextBoolean();
			ServiceStorage.setServiceInDatabase(ServiceStorage.createService(typeService, endServiceStr,
					lastPaymentDateStr, countMinutes, countSMS, countMegabytes, price, userId, isActivated));
			menuForAdmin();

			break;
		case 3:
			AdminOperations.showUnpaidServices();
			;
			menuForAdmin();

			break;
		case 4:
			Scanner search = new Scanner(System.in);
			System.out.println("Enter email:");
			String searchedEmail = search.nextLine();
			AdminOperations.searchServiceByEmail(searchedEmail);
			menuForAdmin();
			break;
		case 5:
			Scanner inType = new Scanner(System.in);
			System.out.println("Enter type ofservice:");
			String searchedTypeService = inType.nextLine();
			AdminOperations.searchUserByService(searchedTypeService);
			menuForAdmin();
			break;
		case 6:
			mainMenu();
		default:
			System.out.println("Please choose another option!");
		}
		scanner.close();
	}

}
