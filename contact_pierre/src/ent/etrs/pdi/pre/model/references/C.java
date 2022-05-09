/**
 * 
 */
package ent.etrs.pdi.pre.model.references;

import java.util.regex.Pattern;

/**
 * @author christophe.cerqueira
 *
 */
public class C {
	/**
	 * 
	 */
	private C() {
	}
	/**
	 * Options du menu de l'application.
	 */
	public static final String[] MENU = {
			"Lister les contacts",
			"Créer un nouveau contact",
			"Supprimer un contact",
			"Lister les coordonnées d'un contact",
			"Ajouter une coordonnée à un contact",
			"Supprimer une coordonnée à un contact"

	};

	public static final String PATTERN_DATE = "dd/MM/yyyy";

	public static final String MSG_NUMERO_INVALIDE_EXCEPTION = "le numéro n'est pas valide.";
	public static final Pattern PATTERN_NUMERO_VALIDE = Pattern.compile("[0-9]{10}",Pattern.CASE_INSENSITIVE);
	//	public static final Pattern PATTERN_EMAIL_VALIDE = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$",Pattern.CASE_INSENSITIVE);
	//	public static final Pattern PATTERN_EMAIL_VALIDE2 = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
	//	public static final Pattern PATTERN_EMAIL_VALIDE3 = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",Pattern.CASE_INSENSITIVE);
	public static final Pattern PATTERN_EMAIL_VALIDE4 = Pattern.compile("^(.+)@(.+)$",Pattern.CASE_INSENSITIVE);


	public static final String MSG_CONTACT_EXCEPTION = "Erreur sur le contact.";
	public static final String MSG_CONTACT_NOM_EXCEPTION = "Le nom est non renseigné.";
	public static final String MSG_CONTACT_PRENOM_EXCEPTION = "Le prenom est non renseigné.";
	public static final String MSG_CONTACT_DATE_NAISSANCE_EXCEPTION = "La date est non renseignée.";
	public static final String MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION = "La date de naissance ne peut être postérieure à la date actuelle.";

	public static final String MSG_CONTACT_CREATION = "Le contact %s %s a été créé.";
	public static final String MSG_CONTACT_SUPPRESSION = "Le contact %s %s a été supprimé.";
	public static final String MSG_CONTACT_MISE_A_JOUR = "Le contact %s %s a été mis à jour.";

	public static final String MSG_COORDONNEE_EXCEPTION = "Erreur sur la coordonnée.";
	public static final String MSG_COORDONNEE_CONTACT_NULL_EXCEPTION = "Le contact est non renseigné.";


	public static final String MSG_TELEPHONE_EXCEPTION = "Erreur sur le telephone.";
	public static final String MSG_TELEPHONE_NUMERO_INEXISTANT_EXCEPTION = "Le téléphone %s est inexistant";
	public static final String MSG_TELEPHONE_NUMERO_EXISTANT_EXCEPTION = "Le téléphone %s existe déjà";

	public static final String MSG_MAIL_EXCEPTION = "Erreur sur le mail.";
	public static final String MSG_EMAIL_INVALIDE = "L'adresse mail %s n'est pas valide";
	public static final String MSG_MAIL_EXISTANT_EXCEPTION = "L'adresse mail %s existe déjà";
	public static final String MSG_MAIL_INEXISTANT_EXCEPTION = "L'adresse mail %s est inexistante";

	//DAO
	public static final String MSG_CONTACT_CREATION_EXCEPTION = "La sauvegarde du contact %s %s n'a pas pu être effectuée.";
	public static final String MSG_CONTACT_SUPPRESSION_EXCEPTION = "La suppression du contact %s %s n'a pas pu être effectuée.";
	public static final String MSG_CONTACT_MISE_A_JOUR_EXCEPTION = "La mise à jour du contact %s %s n'a pas pu être effectuée.";

	public static final String MSG_DAO_PERSITANCE_CONTACT_NULL = "Dao : tentative de persistance d'un contact à null";
	public static final String MSG_DAO_PERSITANCE_CONTACT_EXISTANT = "Dao : tentative de création d'un contact déjà existant";
	public static final String MSG_DAO_SUPPRESSION_CONTACT_NULL = "Dao : tentative de suppression d'un contact à null";
	public static final String MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT = "Dao : tentative de suppression d'un contact inexistant";
	public static final String MSG_DAO_MISE_A_JOUR_CONTACT_NULL = "Dao : tentative de modification d'un contact à null";
	public static final String MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT = "Dao : tentative de modification d'un contact inexistant";

	public static final String MSG_DAO_PERSITANCE_CONTACT = "Dao : persistance d'un contact";
	public static final String MSG_DAO_SUPPRESSION_CONTACT = "Dao : suppression d'un contact";
	public static final String MSG_DAO_MISE_A_JOUR_CONTACT = "Dao : mise à jour d'un contact";

	public static final String MSG_AUCUN_CONTACT = "Aucun contact disponible.";
	public static final String MSG_AUCUNE_COORDONNEE = "Aucune coordonnées.";
	
}
