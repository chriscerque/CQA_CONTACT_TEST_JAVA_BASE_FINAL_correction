package marine.etrs.model_Metier.entities_Class_Factory;
import marine.etrs.model_Metier.entities_Class_Factory.exception.ContactException;
import marine.etrs.model_Metier.entities_Class_Factory.exception.CoordonneeException;
import marine.etrs.model_Metier.references_Constante_Enum.TypeMail;
import marine.etrs.model_Metier.references_Constante_Enum.TypeNumero;

import java.time.LocalDate;

/* -------------- TIPS --------------

METTRE LES MEMES PARAMETRES QUE LE LA FACTORY DU DIAGRAMME :
public static MaterielInformatique fabriquerOrdinateur (String numSerie, LocalDate dateGarantie ) {

METTRE LES MEMES PARAMETRES QUE SUR LA CLASSE :
Ordinateur ordinateur = new Ordinateur(numSerie, dateGarantie);

METRE LES SETTERS SUR LES ELEMENTS QU'ILS RESTENT :
ordinateur.setTypeOrdinateur(typeOrdinateur);
return ordinateur;
}

FACTORY NORMALE :
public static Commande fabriquerCommande(final LocalDate dateCommande){
return new Commande(dateCommande);
}
 */


public final class FabriqueMetier {
    private FabriqueMetier() {}

    public static Contact fabriquerContact (final String nom, final String prenom,final LocalDate dateNaissance) throws ContactException {
        return new Contact(nom, prenom, dateNaissance);
    }

    public static Mail fabriquerMail (final Contact contact,final String adresseMail, final TypeMail typeMail) throws CoordonneeException {
        return new Mail(contact,adresseMail, typeMail);
    }

    public static Telephone fabriquerTelephone (final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
        return  new Telephone(contact,numero,typeNumero);
    }

}






