package net.etrs.pdi.mcd.view.console;




import net.etrs.pdi.mcd.commons.utils.AffichageConsole;
import net.etrs.pdi.mcd.commons.utils.LectureConsole;
import net.etrs.pdi.mcd.model.commons.entities.*;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.ContactException;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.CoordonneeException;
import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;
import net.etrs.pdi.mcd.model.commons.references.enumerated.TypeCoordonnee;
import net.etrs.pdi.mcd.model.commons.references.enumerated.TypeMail;
import net.etrs.pdi.mcd.model.commons.references.enumerated.TypeNumero;
import net.etrs.pdi.mcd.model.comparator.TypeCoordonneeComparator;
import net.etrs.pdi.mcd.model.comparator.TypeNumeroComparator;
import net.etrs.pdi.mcd.view.exceptions.ViewException;
import net.etrs.pdi.mcd.view.facades.ContactView;
import net.etrs.pdi.mcd.view.facades.MailView;
import net.etrs.pdi.mcd.view.facades.TelephoneView;

import javax.swing.text.View;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ContactViewImpl implements ContactView {

    private final TelephoneView telephoneView = ViewFactory.fabriquerTelephoneView();
    private final MailView mailView = ViewFactory.fabriquerMailView();


    /**
     *
     */
    protected ContactViewImpl() {
    }

    @Override
    public int afficherMenu() {
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(Arrays.asList(ConstantesModel.MENU), "Menu Contact");

        return LectureConsole.lectureChoixInt(0, ConstantesModel.MENU.length);
    }

    @Override
    public void afficherContact(final Contact contact) throws ViewException {
        StringBuilder builder = new StringBuilder("---------------------------------------");
        builder.append(System.lineSeparator());
        builder.append(String.format("Contact %s %s (%s)", contact.getNom(), contact.getPrenom(),
                contact.getDateNaissance().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        ));
        //		builder.append(System.lineSeparator());
        //		builder.append("\tCoordonnées : ");
        AffichageConsole.afficherMessageAvecSautLigne(builder.toString());

        afficherCoordonneesSimple(contact);

    }

    @Override
    public void afficherContacts(final List<Contact> lstContacts) throws ViewException {
        for(Contact c: lstContacts) {
            afficherContact(c);
        }
    }

    @Override
    public Contact saisirContact() throws ViewException {

        try {
            AffichageConsole.afficherMessageSansSautLigne("Saisir le nom du contact : ");
            String nom = LectureConsole.lectureChaineCaracteres();
            AffichageConsole.afficherMessageSansSautLigne("Saisir le prenom du contact : ");
            String prenom = LectureConsole.lectureChaineCaracteres();

            AffichageConsole.afficherMessageSansSautLigne("Date de début (jj/mm/aaaa) : ");
            LocalDate dateNaissance = LectureConsole.lectureLocalDate(ConstantesModel.PATTERN_DATE);

            Contact c = EntitiesFactory.fabriquerContact(nom, prenom, dateNaissance);

            return c;
        } catch (ContactException e) {
            throw new ViewException(e.getMessage());
        }
    }
    @Override
    public void afficherMessage(final String msg) {
        AffichageConsole.afficherMessageAvecSautLigne(msg);

    }

    @Override
    public Contact selectionnerContact(final List<Contact> lstContacts) {
        List<String> lst = new ArrayList<>();
        for (Contact c : lstContacts) {
            lst.add(String.format("%s %s", c.getNom(), c.getPrenom()));
        }
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner un contact :");
        AffichageConsole.afficherMenuSimple(lst);
        int choix = LectureConsole.lectureChoixInt(1, lst.size());

        return lstContacts.get(choix - 1);
    }

    @Override
    public void afficherCoordonnees(final Contact contact) throws ViewException {
        afficherCoordonneesSimple(contact);

    }

    private List<Coordonnee> classerCoordonnee(Contact contact) {
        List<Coordonnee> coordonneesTriee = new ArrayList<>(contact.getCoordonnees());
        Collections.sort(coordonneesTriee, new TypeCoordonneeComparator());
        Collections.sort(coordonneesTriee, new TypeNumeroComparator());
        return Collections.unmodifiableList(coordonneesTriee);
    }

    private void afficherCoordonneesSimple(final Contact contact) throws ViewException {
        AffichageConsole.afficherMessageAvecSautLigne("\tCoordonnées : ");
        if (contact.getCoordonnees().size() == 0) {
            AffichageConsole.afficherMessageAvecSautLigne("\t\tAucune coordonnées.");
        }
        try {
            for (Coordonnee coordonnee : this.classerCoordonnee(contact)) {
                switch (coordonnee.getTypeCoordonnee()) {
                    case TELEPHONE:
                        telephoneView.afficherCoordonnee((Telephone) coordonnee);
                        break;
                    case MAIL:
                        mailView.afficherCoordonnee((Mail) coordonnee);
                        break;

                    default:
                        break;
                }
            }
        } catch (CoordonneeException e) {
            throw new ViewException(e.getMessage());
        }
    }


    private void afficherContactSimple(final Contact contact) {
        StringBuilder builder = new StringBuilder("---------------------------------------");
        builder.append(System.lineSeparator());
        builder.append(String.format("Contact %s %s (%s)", contact.getNom(), contact.getPrenom(),
                contact.getDateNaissance().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        ));
        builder.append(System.lineSeparator());
        AffichageConsole.afficherMessageSansSautLigne(builder.toString());
    }

    @Override
    public Contact saisirCoordonneesContact(final Contact contact) throws ViewException {
        try {
            TypeCoordonnee typeCoordonnee = selectionnerTypeCoordonnee();
            Coordonnee co = null;
            switch (typeCoordonnee) {
                case TELEPHONE:
                    co = saisirCoordonneesContactTelephone(contact);
                    break;
                case MAIL:
                    co = saisirCoordonneesContactMail(contact);
                    break;

                default:
                    break;
            }
            contact.ajouterCoordonnees(co);
            return contact;
        } catch (CoordonneeException e) {
            throw new ViewException(e.getMessage());
        }
    }

    private Coordonnee saisirCoordonneesContactMail(final Contact contact) throws CoordonneeException {
        TypeMail typeMail = selectionnerTypeMail();
        AffichageConsole.afficherMessageAvecSautLigne("Saisir l'adresse mail : ");
        String adresseMail = LectureConsole.lectureChaineCaracteres();

        return EntitiesFactory.fabriquerMail(contact, adresseMail, typeMail);
    }

    private TypeMail selectionnerTypeMail() {
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner le type de mail :");
        List<String> lst = new ArrayList<>();
        for (TypeMail typeMail : TypeMail.values()) {
            lst.add(typeMail.name());
        }
        AffichageConsole.afficherMenuSimple(lst);
        int choix = LectureConsole.lectureChoixInt(1, lst.size());

        return TypeMail.values()[choix - 1];
    }

    private Coordonnee saisirCoordonneesContactTelephone(final Contact contact) throws CoordonneeException {
        TypeNumero typeNumero = selectionnerTypeNumero();
        AffichageConsole.afficherMessageAvecSautLigne("Saisir le numéro de télephone : ");
        String numero = LectureConsole.lectureChaineCaracteres();

        return EntitiesFactory.fabriquerTelephone(contact, numero, typeNumero);
    }

    private TypeNumero selectionnerTypeNumero() {
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner le type de numéro :");
        List<String> lst = new ArrayList<>();
        for (TypeNumero typeNumero : TypeNumero.values()) {
            lst.add(typeNumero.name());
        }
        AffichageConsole.afficherMenuSimple(lst);
        int choix = LectureConsole.lectureChoixInt(1, lst.size());

        return TypeNumero.values()[choix - 1];
    }

    private TypeCoordonnee selectionnerTypeCoordonnee() {
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner le type de coordonnée :");
        List<String> lst = new ArrayList<>();
        for (TypeCoordonnee typeCoordonnee : TypeCoordonnee.values()) {
            lst.add(typeCoordonnee.getLibelle());
        }
        AffichageConsole.afficherMenuSimple(lst);
        int choix = LectureConsole.lectureChoixInt(1, lst.size());

        return TypeCoordonnee.values()[choix - 1];
    }

    @Override
    public Contact supprimerCoordonneesContact(final Contact contact) throws ViewException {
        try {
            Coordonnee coordonnee = selectionnerCoordonneesContact(contact);
            contact.supprimerCoordonnees(coordonnee);
            return contact;
        } catch (CoordonneeException e) {
            throw new ViewException(e.getMessage());
        }

    }

    private Coordonnee selectionnerCoordonneesContact(final Contact contact) throws CoordonneeException {
        if (contact.getCoordonnees().size() <= 0) {
            throw new CoordonneeException(ConstantesModel.MSG_AUCUNE_COORDONNEE);
        }
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner la coordonnée à supprimer : ");
        List<String> lst = new ArrayList<>();
        for (Coordonnee coordonnee : this.classerCoordonnee(contact)) {
            switch (coordonnee.getTypeCoordonnee()) {
                case TELEPHONE:
                    Telephone t = (Telephone) coordonnee;
                    lst.add(String.format(" Telephone : %-15s %s",
                            t.getNumero(), t.getTypeNumero()));
                    break;
                case MAIL:
                    Mail m = (Mail) coordonnee;
                    lst.add(String.format(" Mail(%s) : %s",
                            m.getTypeMail(), m.getAdresseMail()));
                    break;

                default:
                    break;
            }
        }
        AffichageConsole.afficherMenuSimple(lst);
        int choix = LectureConsole.lectureChoixInt(0, lst.size());
        return this.classerCoordonnee(contact).get(choix - 1);
    }
}
