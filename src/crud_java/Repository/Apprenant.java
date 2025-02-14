package crud_java.Repository;


public class Apprenant {
	
	private String promotion;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private Integer abscence = 0;
	private Boolean delegue = false;
	
	public Apprenant(String promotion, String nom, String prenom, String email, String telephone, Integer abscence, Boolean delegue) {
		this.promotion = promotion;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.abscence = abscence;
		this.delegue = delegue;
	}
	
	@Override
	public String toString() {
		return "\nPrénom : " + this.prenom + ", delégué : " + this.delegue + ", abscence : " + this.abscence;
	}
	
	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getAbscence() {
		return abscence;
	}

	public void setAbscence(Integer abscence) {
		this.abscence = abscence;
	}

	public Boolean getDelegue() {
		return delegue;
	}

	public void setDelegue(Boolean delegue) {
		this.delegue = delegue;
	}


}
