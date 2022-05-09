package net.ent.etrs.vue.facades;

import net.ent.etrs.vue.ihm.FabriqueIhm;
import net.ent.etrs.vue.ihm.Ihm;
import net.ent.etrs.vue.ihm.ModeAffichage;
import net.ent.etrs.vue.ihm.referencies.IhmConstantes;

public class FacadeVueImpl implements IFacadeVue {

/*----------------------
Attributs +0+1
-----------------------*/

    private Ihm ihm;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected FacadeVueImpl() {

    }

/*----------------------
AUTRES METHODES
-----------------------*/

    @Override
    public void definirModeAffichage(final ModeAffichage modeAffichage) {
        if(modeAffichage.equals(ModeAffichage.PANEL)){
            this.ihm = FabriqueIhm.creerIhmPanel();
        }else {
            this.ihm = FabriqueIhm.creerIhmConsole();
        }
    }

    @Override
    public void definirModeAffichage(final String modeAffichage) {
        if(modeAffichage.equalsIgnoreCase(ModeAffichage.PANEL.name())){
            this.ihm = FabriqueIhm.creerIhmPanel();
        }else {
            this.ihm = FabriqueIhm.creerIhmConsole();
        }
    }

    @Override
    public void afficherMenuPrincipal() {
        this.ihm.saisirChoixMenuPrincipal(IhmConstantes.TITRE_MENU_PRINCIPAL, IhmConstantes.TABLO_STR_MENU_PRINCIPAL);
    }

}  // fin de classe

