package crud_java;

public class Launcher {
	public static void main(String[] args) {
		API api = new API();
		api.addApprenant("DI23", "Vias", "Mathis", "entre ici et là", "mathis.vias@viacesi.fr", "0666666666", 0, false);
		System.out.println(api.getAllApprenant());

	}
}
