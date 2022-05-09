package marine.etrs.model_Metier.facade;

import marine.etrs.dao.AbstractContactDao;
import marine.etrs.dao.DaoFactory;
import marine.etrs.dao.excpetions.DaoException;
import marine.etrs.model_Metier.entities_Class_Factory.Contact;
import marine.etrs.model_Metier.entities_Class_Factory.exception.ContactException;
import marine.etrs.model_Metier.facade.exceptions_business.BusinessException;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade {

    //IL PEUT Y AVOIR PLUSIEURS OBJETS ! :
    private AbstractContactDao daoContact = DaoFactory.fabriquerContactDao();


    protected ContactFacadeImpl() {}


    @Override
    public List<Contact> listerContacts() {
        return this.daoContact.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws ContactException {
        try {
            this.daoContact.update(contact);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void supprimerContact(Contact contact) throws ContactException {

        try {
            this.daoContact.delete(contact);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void mettreAJourContact(Contact contact) throws ContactException {

        try {
            this.daoContact.update(contact);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void init() {
       daoContact.init();
    }

//    @Override
//    public void initialiserApplication() throws BusinessException {
//        //EXEMPLE
//       materielInformatiqueDao.init();
///       batimentDao.init();
//    }


//    DAO
//    EXEMPLE LE FAIRE POUR TOUTE ! :

//    @Override
//    public void creerLogement(Logement logement) throws BusinessException {
//
//        try {
//            this.logementDao.create(logement);
//        } catch (DaoException e) {
//            throw new BusinessException(e.getMessage());
//        }
//    }


//    EXEMPLE DE LISTER MATERIELs INFORMATIQUE:
//    public List<MaterielInformatique> listerMaterielInformatique() {
//        return this.materielInformatiqueDao.readAll();
//    }


//    EXEMPLE DE LISTER BATIMENT :
//    public List<Batiment> listerBatiment() {
//        return this.batimentDao.readAll();
//    }


//    public List<Commande> recupererListeCommandes() {
//        return this.daoCommande.readAll();
//    }

//    public List<Article> recupererListeArticles() {
//        return this.daoArticle.readAll();
//    }

    //    EXEMPLE DE LISTER MATERIELs INFORMATIQUE:
//    public List<MaterielInformatique> listerMaterielInformatique() {
//        return this.materielInformatiqueDao.readAll();
//    }

}