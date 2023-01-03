package ud4.practices.models;

/**
 *
 *Aquesta classe representa un Artista.
 * @author Rubén Gómez Castellano 1SDAM
 * @version 1.0
 */
public class Artista {
    /**
     *  Nom del artista
     */
    private final String nom;
    /**
     *  Cognom del artista
     */
    private final String cognom;
    /**
     * Pais de proceencia del artista
     */
    private final String pais;

    /**
     * Crea un Artista especificant tots els atributs definits anteriorment
     *
     * @param nom nom de l'artista creat
     * @param cognom cognom del artista creat
     * @param pais pais de procedència de l'artista creat
     */
    public Artista(String nom, String cognom, String pais) {
        this.nom = nom;
        this.cognom = cognom;
        this.pais = pais;
    }

    /**
     * Nom d'artista creat
     * @return retorna el nom d'un artista creat.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Cognom d'artista creat.
     * @return retorna el cognom d'un artista creat.
     */
    public String getCognom() {
        return cognom;
    }

    /**
     * Pais de procedència d'artista creat
     * @return retorna el pais de procedència d'un artista creat.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Nom i Cognom d'un artista creat
     * @return retorna en un String el nom i cognom d'un artista creat.
     */
    @Override
    public String toString() {
        return String.format("%s %s", nom, cognom);
    }
}
