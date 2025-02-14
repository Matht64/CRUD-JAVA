package crud_java.Service;

import java.util.ArrayList;
import java.util.List;

import crud_java.Repository.Apprenant;

public class API {
	
	private List<Apprenant> apprenants = new ArrayList<Apprenant>();
	
	
	public API() {}
	
	
	public Apprenant getApprenantByPrenomNom(String prenom, String nom){
		// Récupère l'apprenant avec le prenom et le nom donné
		
		for (Apprenant apprenant : apprenants) {
            if ((apprenant.getNom().equals(nom)) & (apprenant.getPrenom().equals(prenom))) {
            	return apprenant;
            }
        }
		return null;
	}
	
	
	public List<Apprenant> getAllApprenant(){
		// Récupère tous les apprenants
		// requete SQL SELECT * FROM Apprenant;
		
		return apprenants;
	}
	
	
	public List<Apprenant> getAllApprenantOrderByNom(){
		// Récupère tous les apprenants triés par noms croissants
		// requete SQL SELECT * FROM Apprenant ORDER BY Apprenant.Nom;
		
		return apprenants;
	}
	
	
	public List<Apprenant> getAllApprenantOrderByAbscence(){
		// Récupère tous les apprenants triés par abscence décroissante
		// requete SQL SELECT * FROM Apprenant ORDER BY Apprenant.Abscence;
		
		return apprenants;
	}
	
	
	public Double getTauxAbscenceByPromotion(String promotion){
		// Calcule le taux d'absenteisme des apprenants de la promotion donnée
		// requete SQL SELECT * FROM Apprenant WHERE Apprenant.Promotion = promotion;
		
		Double taux = 0.0;
		int count = 0;
		for (Apprenant apprenant : apprenants) {
			if (apprenant.getPromotion().equals(promotion)) {
				count += 1 ;
				taux += apprenant.getAbscence();
			}
		}
		if (taux == 0.0){
			return taux;
		}else {
			return taux/count;
		}	
	}
	
	
	public List<Apprenant> getApprenantByPromotion(String promotion){
		// Récupère les apprenants de la promotion donnée
		// requete SQL SELECT * FROM Apprenant WHERE Apprenant.Promotion = promotion;
		
		List<Apprenant> apprenantByPromotion = new ArrayList<Apprenant>();
		for (Apprenant apprenant : apprenants) {
			if (apprenant.getPromotion().equals(promotion)) {
				apprenantByPromotion.add(apprenant);
			}
		}
		return apprenantByPromotion;
	}
	
	
	public Apprenant addApprenant(String promotion, String nom, String prenom, String email, String telephone, Integer abscence, Boolean delegue) {
		// Ajoute un apprenant à la base s'il n'est pas existant
		
		for (Apprenant apprenant : apprenants) {
            if ((apprenant.getNom().equals(nom)) & (apprenant.getPrenom().equals(prenom)) | apprenant.getEmail().equals(email)) {
            	return null;
            }
        }
		Apprenant new_apprenant = new Apprenant(promotion, nom, prenom, email, telephone, abscence, delegue);
		this.apprenants.add(new_apprenant);
		return new_apprenant;
	}
	

	public Apprenant updateAbscence(Integer new_abscence, String prenom, String nom) {
		// Met à jour l'abscence d'un apprenant donné
		for (Apprenant apprenant : apprenants) {
            if ((apprenant.getNom().equals(nom)) & (apprenant.getPrenom().equals(prenom))){
            	apprenant.setAbscence(new_abscence);
            	return apprenant;
            }
        }
		return null;
	}
	
	
	public String deleteApprenant(String prenom, String nom) {
		// Supprime un apprenant s'il est dan sla liste et s'il n'est pas délégué
		for (Apprenant apprenant : apprenants) {
            if ((apprenant.getNom().equals(nom)) & (apprenant.getPrenom().equals(prenom))) {
            	if (apprenant.getDelegue()){
            		return prenom + " " + nom + "est délégué, veuillez d'abord changer son statut";
            	}else {
            		apprenants.remove(apprenant);
            		return prenom + " " + nom + " supprimé";
            	}
            }
		}
		return prenom + " " + nom + " introuvable";
	}
}








