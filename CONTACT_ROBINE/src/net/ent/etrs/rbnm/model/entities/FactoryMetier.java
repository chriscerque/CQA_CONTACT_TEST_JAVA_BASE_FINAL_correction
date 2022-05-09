package net.ent.etrs.rbnm.model.entities;

import net.ent.etrs.rbnm.model.exceptions.ContactException;
import net.ent.etrs.rbnm.model.exceptions.CoordonneeException;

import net.ent.etrs.rbnm.model.references.enumerateds.TypeCoordonnee;
import net.ent.etrs.rbnm.model.references.enumerateds.TypeMail;
import net.ent.etrs.rbnm.model.references.enumerateds.TypeNumero;

import java.time.LocalDate;

public final class FactoryMetier {


    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */

    private FactoryMetier() {
    }


    /* ******************** */
    /* ***** FABRIQUE ***** */
    public static Contact fabriquerContact(String nom, String prenom, LocalDate dateNaissance) throws ContactException {
        return new Contact(nom, dateNaissance, prenom);
    }

    public static Coordonnee fabriquerTelephone(Contact contact, String numero, TypeNumero typeNumero) throws CoordonneeException {
        Coordonnee telephone = new Telephone(contact, numero, typeNumero);
        telephone.setTypeCoordonnee(TypeCoordonnee.TELEPHONE);

        return telephone;
    }

    public static Coordonnee fabriquerMail(Contact contact, String numero, TypeMail typeMail) throws CoordonneeException {
        Coordonnee mail = new Mail(contact, numero, typeMail);
        mail.setTypeCoordonnee(TypeCoordonnee.MAIL);

        return mail;
    }

 /*
 EXEMPLES :
 public static NOM_CLASS creerNOM_ATTRIBUTS(PARAM DU CONSTRUCTEURS){

    return new NOM_CLASS(PARAM DU CONSTRUCTEURS);

 }
  */


}
