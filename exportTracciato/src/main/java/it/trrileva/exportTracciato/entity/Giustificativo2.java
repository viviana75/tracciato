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
public class Giustificativo2 {
 
    @CsvBindByPosition(position = 0)
    private String codice;
    
    @CsvBindByPosition(position = 1)
    private String descrizione;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Giustificativo{" + "codice=" + codice + ", descrizione=" + descrizione + '}';
    }
    
}
