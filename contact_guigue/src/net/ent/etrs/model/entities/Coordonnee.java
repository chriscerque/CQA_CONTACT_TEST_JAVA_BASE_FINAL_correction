package net.ent.etrs.model.entities;

import net.ent.etrs.model.references.enums.TypeCoordonnee;

import java.util.Objects;

public abstract class Coordonnee {
/*----------------------
Attributs +0+1
-----------------------*/
    private String id;
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected Coordonnee() {}

    public Coordonnee(Contact contact) {
        this.contact = contact;
    }

/*----------------------
GETTERS
-----------------------*/

    public String getId() {
        return id;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    public Contact getContact() {
        return contact;
    }
/*----------------------
SETTERS
-----------------------*/

    public void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) {
        this.typeCoordonnee = typeCoordonnee;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
/*----------------------
EQUALS & HASHCODE
-----------------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordonnee)) return false;
        Coordonnee that = (Coordonnee) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
/*----------------------
TOSTRING
-----------------------*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnées :");
        return sb.toString();
    }
/*----------------------
AUTRES METHODES
-----------------------*/


}  // fin de classe

//TODO: Création Class Coordonnee
// 1-Attributs
// 2-GETTERS
// 3-SETTERS + REGLES DE GESTION
// 4-CONSTRUCTEUR - utiliser les SETTERS
// 5-EQUALS&HASHCODE
// 6-TOSTRING() - avec StringBuilder