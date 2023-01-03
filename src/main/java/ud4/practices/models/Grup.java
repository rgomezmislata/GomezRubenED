package ud4.practices.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Aquesta classe representa un Grup de Música
 * @author Rubén Gómez Castellano 1SDAM
 * @version  1.0
 */

public class Grup {
    /**
     * Nom del grup.
     */
    private final String nom;
    /**
     * Data de fundació del grup
     */
    private final LocalDate dataFundacio;
    /**
     * Pais d'on pertany el grup
     */
    private final String pais;
    /**
     * Artistes que pertanyen al grup
     */
    private final List<Artista> artistes;

    /**
     * Crea un grup especificant tots els atributs definits anteriorment
     * @param nom nom del grup creat
     * @param dataFundacio  Data de fundació del grup creat
     * @param pais Pais d'on pertany el grup creat
     */
    public Grup(String nom, LocalDate dataFundacio, String pais) {
        this.nom = nom;
        this.dataFundacio = dataFundacio;
        this.pais = pais;
        this.artistes = new ArrayList<>();
    }

    /**
     * Crea un grup amb els atributs seguits en tres String
     * @param nom nom del grup creat
     * @param dataFundacio Data de fundacio del grup creat amb format "yyyy-MM-dd"
     * @param pais Pais de pertenencia del grup creat
     */
    public Grup(String nom, String dataFundacio, String pais) {
        this(nom, LocalDate.parse(dataFundacio, DateTimeFormatter.ofPattern("yyyy-MM-dd")), pais);
    }

    /**
     *  nom d'un grup creat
     * @return retorna el nom d'un grup creat
     */
    public String getNom() {
        return nom;
    }

    /**
     * data de fundació d'un grup creat
     * @return retorna la data de fundació d'un grup creat
     */
    public LocalDate getDataFundacio() {
        return dataFundacio;
    }

    /**
     * Pais d'on pertany el grup creat
     * @return retorna el pais de procedència d'un grup creat
     */
    public String getPais() {
        return pais;
    }

    /**
     *  llistat d'artistes que pertanyen a un grup creat
     * @return retorna el llistat d'artistes que pertanyen a un grup creat
     */
    public List<Artista> getArtistes() {
        return artistes;
    }

    /**
     *  Afegeix un artista a un grup
     * @param artista l'artista que es va afegir al grup creat
     * @return Comprova si l'artista ja pertany al grup, si ja ho estava torna el valor False, si no estava encara retorna el valor True
     */
    public boolean addArtista(Artista artista){
        if (artistes.contains(artista))
            return false;
        artistes.add(artista);
        return true;
    }

    /**
     * Representació d'un Grup com a String
     * @return retorna un String amb el nom del grup i la data de fundació del grup.
     */
    @Override
    public String toString() {
        return String.format("%s (%d)", nom, dataFundacio.getYear());
    }
}
