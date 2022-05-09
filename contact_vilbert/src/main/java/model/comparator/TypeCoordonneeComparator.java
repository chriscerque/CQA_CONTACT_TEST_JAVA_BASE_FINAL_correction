package model.comparator;

import model.entities.Coordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<Coordonnee> {

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    public TypeCoordonneeComparator() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public int compare(Coordonnee o1, Coordonnee o2) {
        return o1.getTypeCoordonnee().getLibelle().compareTo(o2.getTypeCoordonnee().getLibelle());
    }

}
