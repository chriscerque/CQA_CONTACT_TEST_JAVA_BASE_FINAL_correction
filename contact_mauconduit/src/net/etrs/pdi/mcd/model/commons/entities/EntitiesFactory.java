package net.etrs.pdi.mcd.model.commons.entities;

import net.etrs.pdi.mcd.model.commons.entities.exceptions.ContactException;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.CoordonneeException;
import net.etrs.pdi.mcd.model.commons.references.enumerated.TypeMail;
import net.etrs.pdi.mcd.model.commons.references.enumerated.TypeNumero;

import java.time.LocalDate;

public final class EntitiesFactory {

	// ***** CONSTRUCTEUR ***** \\
	private EntitiesFactory() {

	}

	// ***** METHODES ***** \\

	/**
	 * Cette fonction permet de creer une nouvelle instance de type Contact.
	 * @param nom: String.
	 * @param prenom: String.
	 * @param dateNaissance: LocalDate.
	 * @return Contact.
	 * @throws ContactException
	 */
	public static Contact fabriquerContact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
		return new Contact(nom, prenom, dateNaissance);
	}


	/**
	 * Cette fonction permet de creer une nouvelle instance de type Mail.
	 * @param contact: Contact.
	 * @param adresseMail: String.
	 * @param typeMail: TypeMail.
	 * @return Mail.
	 * @throws CoordonneeException
	 */
	public static Coordonnee fabriquerMail(final Contact contact, final String adresseMail, final TypeMail typeMail) throws CoordonneeException {

		return new Mail(contact, adresseMail, typeMail);
	}


	/**
	 * Cette fonction permet de creer une nouvelle instance de type Mail.
	 * @param contact: Contact.
	 * @param adresseMail: String.
	 * @param typeNumero: TypeNumero.
	 * @return Telephone.
	 * @throws CoordonneeException
	 */
	public static Coordonnee fabriquerTelephone(final Contact contact, final String adresseMail, final TypeNumero typeNumero) throws CoordonneeException {
		return new Telephone(contact, adresseMail, typeNumero);
	}





}
