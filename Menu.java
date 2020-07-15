package mobileOperator;

import java.util.Scanner;

public class Menu {

	public static void mainMenu()  {
		Scanner scanner = new Scanner(System.in);
		AdminOperations operation=new AdminOperations();
		Register registration=new Register();
		Checks checkIsExist=new Checks();
		operation.isActive();
		System.out.println("* 1.Login as user    *");
		System.out.println("* 2.Login as admin   *");
		System.out.println("* 3.Register user    *");
		System.out.println("* 4.Register as admin*");
		System.out.println("* 5.Exit             *");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:

			Scanner inUser = new Scanner(System.in);
			System.out.println("Enter email and password, password cannot be less than 8 characters:");
			String email = inUser.nextLine();
			String password = inUser.nextLine();
			try {
				checkIsExist.checkForUser(email, password);
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			}

			mainMenu();

		case 2:
			System.out.println("Enter email and password, password cannot be less than 8 characters:");
			Scanner admin = new Scanner(System.in);
			String searchedEmailAdmin = admin.nextLine();
			String searchedPasswordAdmin = admin.nextLine();
			try {
				checkIsExist.checkForAdmin(searchedEmailAdmin, searchedPasswordAdmin);
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			} finally {
				mainMenu();
			}
			break;

		case 3:
			Scanner inUser1 = new Scanner(System.in);
			System.out.println("Enter name, email and password, password cannot be less than 8 characters:");
			String nameUser = inUser1.nextLine();
			String emailUser = inUser1.nextLine();
			String passwordUser = inUser1.nextLine();
			try {
				registration.setUserInDatabase(nameUser, emailUser, passwordUser);
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			} finally {
				mainMenu();
			}
			mainMenu();
			break;

		case 4:
			Scanner inAdmin = new Scanner(System.in);
			System.out.println("Enter name, email and password, password cannot be less than 8 characters:");
			String nameAdmin = inAdmin.nextLine();
			String emailAdmin = inAdmin.nextLine();
			String passwordAdmin = inAdmin.nextLine();
			try {
				registration.setAdminInDatabase(nameAdmin, emailAdmin, passwordAdmin);
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			} finally {
				mainMenu();
			}
			break;

		case 5:
			System.exit(0);

		default:
			System.out.println("Invalid option!");
		}
		scanner.close();
	}

	public static void menuForAdmin() throws PasswordException {
		Scanner scanner = new Scanner(System.in);
		ServiceStorage storage=new ServiceStorage();
		AdminOperations operation=new AdminOperations();
		Register registration=new Register();
		System.out.println("1.Add user");
		System.out.println("2.Add service");
		System.out.println("3.Show unpaid services");
		System.out.println("4.Search service by email");
		System.out.println("5.Search user by name of service");
		System.out.println("6.Back to main menu");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			Scanner inUser = new Scanner(System.in);
			System.out.println("Enter name, email and password, password cannot be less than 8 characters:");
			String name = inUser.nextLine();
			String email = inUser.nextLine();
			String password = inUser.nextLine();
			try {
				registration.setUserInDatabase(name, email, password);
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			} finally {
				menuForAdmin();
			}
			break;
		case 2:
			Scanner inService = new Scanner(System.in);
			System.out.println(
					"Enter name of service ,end of service,last payment date,count minutes,count sms,count megabytes, price,userId and isActivated:");
			String typeService = inService.nextLine();
			String endServiceStr = inService.nextLine();
			String lastPaymentDateStr = inService.nextLine();
			int countMinutes = inService.nextInt();
			int countSMS = inService.nextInt();
			int countMegabytes = inService.nextInt();
			double price = inService.nextDouble();
			int userId = inService.nextInt();
			boolean isActivated = inService.nextBoolean();
			
			try {
				storage.setServiceInDatabase(ServiceStorage.createService(typeService, endServiceStr,
						lastPaymentDateStr, countMinutes, countSMS, countMegabytes, price, userId, isActivated));
			} catch (PriceException e) {
				System.out.println(e.getMessage());
			}
			menuForAdmin();

			break;
		case 3:
			operation.showUnpaidServices();
			menuForAdmin();

			break;
		case 4:
			Scanner search = new Scanner(System.in);
			System.out.println("Enter email:");
			String searchedEmail = search.nextLine();
			operation.searchServiceByEmail(searchedEmail);
			menuForAdmin();
			break;
		case 5:
			Scanner inType = new Scanner(System.in);
			System.out.println("Enter type of service:");
			String searchedTypeService = inType.nextLine();
			operation.searchUserByServiceName(searchedTypeService);
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
