package net.ent.etrs.vue.facades;

import net.ent.etrs.vue.ihm.ModeAffichage;

public interface IFacadeVue {

    /**
     * Méthode permettant de définir quelle affcihage prendra l'application.
     * @param modeAffichage ModeAffichage Enumération donnant le choix d'affichage
     */
    void definirModeAffichage(ModeAffichage modeAffichage);

    /**
     * Méthode permettant de définir quelle affcihage prendra l'application.
     *
     * Si le programme doit tourner en mode panel, l'utilisateur doit renseinger le paramètre
     * à PANEL
     * 
     * @param modeAffichage String donnant le choix d'affichage
     */
    void definirModeAffichage(String modeAffichage);


    /**
     * Méthode permettant d'afficher le menu principal de l'application.
     */
    void afficherMenuPrincipal();
} // fin d'Interface
