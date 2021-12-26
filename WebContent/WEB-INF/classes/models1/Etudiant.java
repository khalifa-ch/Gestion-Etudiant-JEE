package models1;
public class Etudiant{
	private int id;
	private String nom;
	private String prenom;
	private String classe;
	
	public Etudiant(int id,String nom,String prenom,String classe) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.classe=classe;
		
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	
	}
	public String getClasse() {
		return classe;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	public void setPrenon(String prenom) {
		this.prenom=prenom;
	}
	public void SetClass(String classes) {
		this.classe = classes;
	}
}