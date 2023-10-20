package subsistema1.crm;

public class CrmService {
    private CrmService(){
        super();
    }

    public static void gravarCliente(String nome, String cep, String cidade, String estado) {
        System.out.println(nome+" "+cep+" "+cidade+" "+estado+" ");
        System.out.println("Cliente salvo no Sistema de CRM!");
    }
}
