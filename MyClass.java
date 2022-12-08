import java.util.*;

public class MyClass{
	
	// La méthode pour lancer l'application est tout en bas
	
	// inscription
	public static String signInName(Scanner sc, String name){

		System.out.print("\n");
		System.out.println("**** Inscription ****");

		System.out.print("\nEntrer un nom : ");
		name = sc.nextLine();
		
		return name;
	}
	
	public static String signInPswd(Scanner sc, String pswd){

		System.out.print("\nEntrer un mot de passe : ");
		pswd = sc.nextLine();
		
		return pswd;
	}
	
	// connexion
	public static String logInName(Scanner sc, String isValidName){

		System.out.print("\n");
		System.out.println("**** Connexion ****");

		System.out.print("\nEntrer un nom : ");
		isValidName = sc.nextLine();
		
		return isValidName;
	}
	
	public static String logInPswd(Scanner sc, String isValidPswd){

		System.out.print("\nEntrer un mot de passe : ");
		isValidPswd = sc.nextLine();
		System.out.print("\n");
		
		return isValidPswd;
	}
	
	// booleenne comparant les valeurs de données
	public static String checkName(Scanner sc, String name, String validValue){
		
		boolean logInNotValid = true;

		while(logInNotValid){	
		
			validValue = logInName(sc, validValue);
			
			if( !(name.equals(validValue)) ){
				System.out.print(" nom invalide \n");
			} else {
				logInNotValid = false;
			}
		} return validValue;
	}
	
	public static String checkPswd(Scanner sc, String pswd, String validValue){
		boolean logInNotValid = true;

		while(logInNotValid){	
		
			validValue = logInPswd(sc, validValue);
			
			if( !(pswd.equals(validValue)) ){
				System.out.print(" mdp invalide \n");
			} else {
				logInNotValid = false;
			}
		} return validValue;
	}
		
	// methode créant un tableau de 20	
	public static int[] createArray(int[] rooms){
		int rangeRooms = 20;

		rooms = new int[rangeRooms];
		return rooms;
	}
	
	// méthode d'affiche d'un tableau
	public static void displayArray(int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			System.out.print(" " + elements[i] + " ");
		}
		System.out.println();
	}
	
	// methode pour generer les disponibilités des chambres
	public static int[] generateRoomsAvailability(int []rooms){
		Random ran = new Random();
		int isAvailableRoom;
		int min = 0;
		int max = 1;
		int range = (max - min) + 1; 

		for(int i=0;i<rooms.length;i++){
			isAvailableRoom = ran.nextInt(range) + min;
			rooms[i] = isAvailableRoom;
			System.out.print(" " + rooms[i] + " ");
		}
		return rooms;
	}

	// affichage chambres disponibles
	public static void getAvailableRooms(int []rooms){
		int availableRooms = 0;
		for(int i=0;i<rooms.length;i++){
			if(rooms[i] == 0){
				availableRooms = availableRooms + 1;
			}
		} System.out.println("\n-Chambres libres : " + availableRooms);
	}
	
	// affichage chambres indisponibles
	public static void getUnavailableRooms(int []rooms){
		int unavailableRooms = 0;
		for(int i=0;i<rooms.length;i++){
			if(rooms[i] == 1){
				unavailableRooms = unavailableRooms + 1;
			}
		} System.out.println("-Chambres reservees : " + unavailableRooms);
	}

	// afficher la 1ere chambre de libre partant du debut
	public static void displayFirstAvailableRoom(int []rooms){
		for(int i=0;i<rooms.length;i++){
			if(rooms[i] == 0){
				System.out.println("\n-Chambre de libre en partant du debut : " + (i+1));
				break;
			} 
		}	
	}
	
	// afficher la 1ere chambre de libre partant de la fin
	public static void displayFirstAvailableRoomByTheEnd(int []rooms){
		for(int i=rooms.length-1;i>0;i--){
			if(rooms[i] == 0){
				System.out.println("-Chambre de libre en partant du debut : " + (i+1));
				break;
			} 
		}	
	}
	
	// liberer une chambre
	public static void freeRoom(int []rooms){
		for(int i=rooms.length-1;i>0;i--){
			if(rooms[i] == 1){
				rooms[i] = 0;
				System.out.println("\n-Chambre numero " + (i+1) + " liberee");
				break;
			}
		}
	}
	
	// reserver une chambre
	public static void rentRoom(Scanner sc, int []rooms, String name, String userValue, String notValidPrompt){
		String yesValidPrompt = "o";

		System.out.println("\n**** Voulez vous reserver une chambre "+ name +" ? **** ");
		System.out.println("(o: reserver) ou (autre touche: ignorer)");
		userValue = sc.nextLine();
		
		if(userValue.equals(yesValidPrompt)){
			for(int i=0;i<rooms.length;i++){
				if(rooms[i] == 0){
					rooms[i] = 1;
					System.out.println("\n\n\n{**** Chambre numero " + (i+1) + " reservee pour "+ name +" ****}\n\n\n");
					break;
				}			
			} 
		}
	}
	
	// méthode de lancement du programme
	public static void programLauncher(){
		
		Scanner sc = new Scanner(System.in);
		int []rooms = new int[0];
		String name = "";
		String validValue = "";
		String pswd = "";
		String userValue = "";		
		String notValidPrompt = "n";
		boolean startProgram = true;		

		//  methodes sign in
		name = signInName(sc, name);
		pswd = signInPswd(sc, pswd);
		
		System.out.print("\nname : " + name);
		System.out.print("\npswd : " + pswd);

		// methodes pour verifier si les données sont les memes entre celles du signin et login
		checkName(sc, name, validValue);
		checkPswd(sc, pswd, validValue);

		rooms = createArray(rooms);

		while(startProgram){
			
			System.out.print("\n");
			System.out.print("\n");

			System.out.print("{--------------------------");
			System.out.print("**** HOTEL 4 ETOILES ****");
			System.out.print("--------------------------}");
			
			System.out.print("\n");
			System.out.print("\n");
			
			System.out.print("\n");
			System.out.print("\n");
			System.out.print("**** Bienvenue  "+ name +" ! ****");
			System.out.print("\n");
			System.out.print("\n");
			
			System.out.println("\n-DISPONIBILITE DES CHAMBRES-");
			System.out.print("\n");
			// appeler methode pour afficher le nombre de chambres disponibiles et indisponibles
			generateRoomsAvailability(rooms);
			
			System.out.print("\n");
			
			// affichage de chambres libres
			getAvailableRooms(rooms);
			
			// affichage de chambres louées
			getUnavailableRooms(rooms);
			
			System.out.print("\n");
			
			// afficher la 1ere chambre de libre partant du debut
			displayFirstAvailableRoom(rooms);			
			// afficher la 1ere chambre de libre partant de la fin
			displayFirstAvailableRoomByTheEnd(rooms);
			// methode pour liberer une chambre
			freeRoom(rooms);
			
			System.out.print("\n");		
			System.out.print("{--------------------------");
			System.out.print("**** HOTEL 4 ETOILES ****");
			System.out.print("--------------------------}");
			System.out.print("\n");
			
			// methode de reservation d'une chambre			
			rentRoom(sc, rooms, name, userValue, notValidPrompt);

			// demande d'arret du programme
			System.out.println("\n**** Cher "+ name +" Voulez vous poursuivre ? ****\n(autre touche: valider) ou (n: arret du programme) ");
			userValue = sc.nextLine();
			
			if(userValue.equals(notValidPrompt)){
				System.out.println("\n**** A bientot "+ name +" ! ****");
				startProgram = false;
			}
		}
	}
}