package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.entities.Coordonnee;
import net.ent.etrs.model.entities.EntitiesFactory;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.references.TypeNumero;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConstactDao implements IContactMemoireDao{
    protected List<Contact> persistanceContact = new ArrayList<>();

    public abstract void init();
}
