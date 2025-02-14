package crud_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import crud_java.Service.API;

public class Launcher {
	// création instance de service "API"
	public static API api = new API();
	
	// création instance d'UI-Controller "r"
	public static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		
		// création de donnée par manque de BDD
		api.addApprenant("Promotion", "Nom", "Prenom", "email", "telephone", 0, false);
		api.addApprenant("DI23", "Vias", "Mathis", "Mathis.Vias@viacesi.fr", "0666666666", 66, false);
		api.addApprenant("DI23", "Levallois", "Ewenn", "Ewenn.Levallois@viacesi.fr", "0666666667", 42, true);
		api.addApprenant("DI23", "Gyselings", "Terry", "Terry.Gyselings@viacesi.fr", "0666666668", 42, true);
		api.addApprenant("DI22", "Michel", "Michelle", "Michelle.Michel@viacesi.fr", "0666666669", 13, true);
		api.addApprenant("DI23", "Français", "François", "François.Français@viacesi.fr", "0666666660", 2, true);
		
		// Lancement du programme principal au travers d'un menu
		try {
			Menu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Menu() throws IOException {
		String promotion;
		String nom;
		String prenom;
		String email;
		String telephone;
		Integer abscence = 0;
		Boolean delegue = false;
		
		System.out.println(api.getAllApprenant());
		
		System.out.println("Que souhaitez-vous faire ?\n");
		System.out.println("1/ Ajouter un apprenant");
		System.out.println("2/ Supprimer un apprenant");
		System.out.println("3/ Modifier abscence d'un apprenant");
		System.out.println("4/ Afficher tous les apprenants par nom");
		System.out.println("5/ Afficher tous les apprenants par abscence");
		System.out.println("6/ Afficher tous les apprenants de la promotion X");
		System.out.println("7/ Afficher le taux d'absenteisme de la promotion X\n");
		String s = r.readLine();
		
		if (s.equals("1")) {
			System.out.println("promotion");
			promotion = r.readLine();
			System.out.println("nom");
			nom = r.readLine();
			System.out.println("prenom");
			prenom = r.readLine();
			System.out.println("email");
			email = r.readLine();
			System.out.println("telephone");
			telephone = r.readLine();
			api.addApprenant(promotion, nom, prenom, email, telephone, abscence, delegue);
			
		}else if (s.equals("2")) {
			System.out.println("nom");
			nom = r.readLine();
			System.out.println("prenom");
			prenom = r.readLine();
			System.out.println(api.deleteApprenant(prenom, nom));
			
		}else if (s.equals("3")) {
			System.out.println("nom");
			nom = r.readLine();
			System.out.println("prenom");
			prenom = r.readLine();
			System.out.println("abscence");
			abscence = Integer.parseInt(r.readLine());
			System.out.println(api.updateAbscence(abscence, prenom, nom));
			
		}else if (s.equals("4")) {
			System.out.println(api.getAllApprenantOrderByNom());
			
		}else if (s.equals("5")) {
			System.out.println(api.getAllApprenantOrderByAbscence());
			
		}else if (s.equals("6")) {
			System.out.println("promotion");
			promotion = r.readLine();
			System.out.println(api.getApprenantByPromotion(promotion));
			
		}else if (s.equals("7")) {
			System.out.println("promotion");
			promotion = r.readLine();
			System.out.println(api.getTauxAbscenceByPromotion(promotion));
			
		}
		System.out.println("\n\n");
		Menu();
		
	}
}
