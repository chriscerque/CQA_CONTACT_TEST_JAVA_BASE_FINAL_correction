package net.etrs.pdi.mcd.model.utils;


import net.etrs.pdi.mcd.model.commons.entities.exceptions.CoordonneeException;
import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;

public class Utilitaire {

	public static void controlerMail(String mail) throws CoordonneeException {
//		if(mail == null || !Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail)) 
		if(mail == null || !ConstantesModel.PATTERN_EMAIL_VALIDE4.matcher(mail).find()) {
			throw new CoordonneeException(String.format("%s : syntaxe mail erronée",mail));
		}
	}
	public static void controlerTelephone(String telephone) throws CoordonneeException {
		if(telephone == null || !ConstantesModel.PATTERN_NUMERO_VALIDE.matcher(telephone).matches())
			throw new CoordonneeException(String.format("%s : syntaxe téléphone erronée",telephone));
	}

}
