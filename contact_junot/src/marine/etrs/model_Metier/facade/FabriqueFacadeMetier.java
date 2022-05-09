package marine.etrs.model_Metier.facade;

public class FabriqueFacadeMetier {
// TIPS :
// 
//UUID : private String id = UUID.randomUUID().toString();

    public FabriqueFacadeMetier() {}

	public static ContactFacade fabriquerFacadeMetier() {
		return new ContactFacadeImpl();
	}
}