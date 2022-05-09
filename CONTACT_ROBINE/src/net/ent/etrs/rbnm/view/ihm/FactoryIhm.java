package net.ent.etrs.rbnm.view.ihm;



public final class FactoryIhm {

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    private FactoryIhm(){}

    //Permet la création d'une vue en JPANEL
    public static Ihm fabriquerJPanelIhm(){ return new JPanelIhmImpl(); }

    //Permet la création d'une vue en CONSOLE
    public static Ihm fabriquerIhmConsole(){ return new ConsoleIhmImpl(); }



}
