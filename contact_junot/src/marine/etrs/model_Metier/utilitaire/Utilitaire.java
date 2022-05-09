package marine.etrs.model_Metier.utilitaire;

import marine.etrs.model_Metier.entities_Class_Factory.exception.CoordonneeException;
import marine.etrs.model_Metier.references_Constante_Enum.C;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utilitaire {

	public static void controlerMail(String mail) throws CoordonneeException {
//		if(mail == null || !Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail)) 
		if(mail == null || !C.PATTERN_EMAIL_VALIDE4.matcher(mail).find()) {
			throw new CoordonneeException(String.format("%s : syntaxe mail erronée",mail));
		}
	}
	public static void controlerTelephone(String telephone) throws CoordonneeException {
		if(telephone == null || !C.PATTERN_NUMERO_VALIDE.matcher(telephone).matches())
			throw new CoordonneeException(String.format("%s : syntaxe téléphone erronée",telephone));
	}


}
