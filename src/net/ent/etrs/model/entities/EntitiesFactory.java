package net.ent.etrs.model.entities;

import java.time.LocalDate;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.references.TypeNumero;


/**
 * Regroupe l'ensemble des fabriques des entités métiers, selon le design pattern
 * Factory.
 * @author christophe.cerqueira
 *
 */
public final class EntitiesFactory {

	private EntitiesFactory() {
	}

	/*----------------------
	 * Méthodes techniques Fabriques d'objets
	 */
	/**
	 * Fabrique un {@link Contact contact}
	 * @param nom nom du contact
	 * @param prenom prenom du contact
	 * @param dateNaissance date de naissance du contact
	 * @return le {@link Contact contact} créé
	 * @throws ContactException
	 */
	public static Contact fabriquerContact(String nom, String prenom, LocalDate dateNaissance) throws ContactException {
		return new Contact(nom, prenom, dateNaissance);
	}
	
	
	public static Coordonnee fabriquerTelephone(Contact contact, String numero, TypeNumero typeNumero) throws CoordonneeException {
		return new Telephone(contact, numero, typeNumero);
	}
	
	public static Coordonnee fabriquerMail(Contact contact, String adresseMail, TypeMail typeMail) throws CoordonneeException {
		return new Mail(contact, adresseMail, typeMail);
	}

	
//	/**
//	 * Fabrique une {@link Formation formation}
//	 * @param nom nom de la formation
//	 * @param type type de la formation
//	 * @param dateDebut date de début de la formation
//	 * @param dateFin date de fin de la formation
//	 * @return la {@link Formateur formation} créée 
//	 * @throws FormationDateDebutNullException 
//	 * @throws FormationDateFinInvalideException 
//	 * @throws FormationDateFinNullException 
//	 * @throws FormationDateDebutInvalideException 
//	 */
//	public static Formation fabriquerFormation(String nom, TypeFormation type, LocalDate dateDebut,LocalDate dateFin) throws FormationDateDebutNullException, FormationDateDebutInvalideException, FormationDateFinNullException, FormationDateFinInvalideException {
//		return new Formation(nom, dateDebut, dateFin, type);
//	}
//	
//	/**
//	 * Fabrique une {@link Formation formation}
//	 * @param nom nom de la formation
//	 * @param type type de la formation
//	 * @return la {@link Formation formation} créée 
//	 */
//	public static Formation fabriquerFormation(String nom, TypeFormation type) {
//		return new Formation(nom, type);
//	}
//	
//	/**
//	 * Fabrique un {@link Etudiant etudiant}
//	 * @param nom nom de l'étudiant
//	 * @param prenom prenom de l'étudiant
//	 * @param mail mail de l'étudiant
//	 * @return l' {@link Etudiant etudiant} créé
//	 * @throws MailException 
//	 */
//	public static Etudiant fabriquerEtudiant(String nom,String prenom,String mail) throws MailException  {
//		Etudiant e = new Etudiant(nom, prenom);
//		e.setMail(mail); // contrôle de la syntaxe d'un email
//		return e;
//	}
//	
//	/**
//	 * Fabrique un {@link Etudiant etudiant}
//	 * @param nom nom de l'étudiant
//	 * @param prenom prenom de l'étudiant
//	 * @return l' {@link Etudiant etudiant} créé
//	 */
//	public static Etudiant fabriquerEtudiant(String nom,String prenom) {
//		Etudiant e = new Etudiant(nom, prenom);
//		return e;
//	}
//	
//	/**
//	 * Fabrique un {@link Formateur formateur}
//	 * @param nom nom de l'étudiant
//	 * @param prenom prenom de l'étudiant
//	 * @param mail mail de l'étudiant
//	 * @return le {@link Formateur formateur} créé
//	 */
//	public static Formateur fabriquerFormateur(String nom,String prenom,String mail) {
//		return new Formateur(nom, prenom, mail);
//	}
	
}
