public class datosDelConversol {


    private String nombreDeLamoneda;

    private String dollar;

    private String pesosDominicano;

    public datosDelConversol(TituloOmd miTituloOmd) {
        this.pesosDominicano = miTituloOmd.pHP();
        this.dollar = miTituloOmd.uSD();
    }


}

