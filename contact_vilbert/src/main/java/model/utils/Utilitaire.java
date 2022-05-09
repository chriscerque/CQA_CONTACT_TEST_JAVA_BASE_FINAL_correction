package model.utils;

import model.exceptions.CoordonneeException;
import model.references.C;

public class Utilitaire {

	public static void controlerMail(String mail) throws CoordonneeException {
		if(mail == null || !C.PATTERN_EMAIL_VALIDE4.matcher(mail).find()) {
			throw new CoordonneeException(String.format("%s : syntaxe mail erronée",mail));
		}
	}
	public static void controlerTelephone(String telephone) throws CoordonneeException {
		if(telephone == null || !C.PATTERN_NUMERO_VALIDE.matcher(telephone).matches()) 
			throw new CoordonneeException(String.format("%s : syntaxe téléphone erronée",telephone));
	}

}
