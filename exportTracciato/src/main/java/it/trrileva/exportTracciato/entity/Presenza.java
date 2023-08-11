/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.trrileva.exportTracciato.entity;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author francesco
 */
public class Presenza {
    @CsvBindByPosition(position = 0)
    private String ditta;
    
    @CsvBindByPosition(position = 1)
    private String codiceDipendente;
    
    @CsvBindByPosition(position = 2)
    private String giorno;
    
    @CsvBindByPosition(position = 3)
    private String mese;
    
    @CsvBindByPosition(position = 4)
    private String anno;

    @CsvBindByPosition(position = 5)
    private String causale;
    
    @CsvBindByPosition(position = 6)
    private String ore;
    
    @CsvBindByPosition(position = 7)
    private String minuti;

    public String getDitta() {
        return ditta;
    }

    public void setDitta(String ditta) {
        this.ditta = ditta;
    }

    public String getCodiceDipendente() {
        return codiceDipendente;
    }

    public void setCodiceDipendente(String codiceDipendente) {
        this.codiceDipendente = codiceDipendente;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getMese() {
        return mese;
    }

    public void setMese(String mese) {
        this.mese = mese;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getCausale() {
        return causale;
    }

    public void setCausale(String causale) {
        this.causale = causale;
    }

    public String getOre() {
        return ore;
    }

    public void setOre(String ore) {
        this.ore = ore;
    }

    public String getMinuti() {
        return minuti;
    }

    public void setMinuti(String minuti) {
        this.minuti = minuti;
    }

    @Override
    public String toString() {
        return "Presenza{" + "ditta=" + ditta + ", codiceDipendente=" + codiceDipendente + ", giorno=" + giorno + ", mese=" + mese + ", anno=" + anno + ", causale=" + causale + ", ore=" + ore + ", minuti=" + minuti + '}';
    }
    
}
