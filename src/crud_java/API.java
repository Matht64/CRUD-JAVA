package crud_java;

import java.util.ArrayList;
import java.util.List;

public class API {
	
	private List<Apprenant> apprenants = new ArrayList<Apprenant>();
	
	
	public API() {}
	
	
	public Apprenant getApprenantByNom(String nom){
		for (Apprenant apprenant : apprenants) {
            if (apprenant.getNom() == nom) {
            	return apprenant;
            }
        }
		return null;
	}
	
	
	public List<Apprenant> getAllApprenant(){
		return apprenants;
	}
	
	
	public Apprenant addApprenant(String promotion, String nom, String prenom, String adresse, String email, String telephone, Integer abscence, Boolean delegue) {
		for (Apprenant apprenant : apprenants) {
            if ((apprenant.getNom() == nom) & (apprenant.getPrenom() == prenom) | apprenant.getEmail() == email) {
            	return null;
            }
        }
		Apprenant new_apprenant = new Apprenant(promotion, nom, prenom, adresse, email, telephone, abscence, delegue);
		this.apprenants.add(new_apprenant);
		return new_apprenant;
	}
	

	public Apprenant updateAbscence(Integer new_abscence, String prenom, String nom) {
		for (Apprenant apprenant : apprenants) {
            if ((apprenant.getNom() == nom) & (apprenant.getPrenom() == prenom)) {
            	apprenant.setAbscence(new_abscence);
            	return apprenant;
            }
        }
		return null;
	}
	
	public String deleteApprenant(String prenom, String nom) {
		for (Apprenant apprenant : apprenants) {
            if ((apprenant.getNom() == nom) & (apprenant.getPrenom() == prenom) & apprenant.getDelegue()) {
            	apprenants.remove(apprenant);
            	return prenom + " " + nom + " supprimé";
            } else {
            	return prenom + " " + nom + "est délégué, veuillez d'abord changer son statut";
            }
		}
		return prenom + " " + nom + " introuvable";
	}
}








