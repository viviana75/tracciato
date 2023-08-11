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
public class Soggetto {
    
    @CsvBindByPosition(position = 0)
    private String soggetto;
    
    @CsvBindByPosition(position = 1)
    private String cognome;
    
    @CsvBindByPosition(position = 2)
    private String nome;
    
    @CsvBindByPosition(position = 4)
    private String qualifica;
        
    @CsvBindByPosition(position = 6)
    private String dataAssunzione;
    
    @CsvBindByPosition(position = 10)
    private String codiceFiscale;
    
    @CsvBindByPosition(position = 13)
    private String nomeCompleto;

    public String getSoggetto() {
        return soggetto;
    }

    public void setSoggetto(String soggetto) {
        this.soggetto = soggetto;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQualifica() {
        return qualifica;
    }

    public void setQualifica(String qualifica) {
        this.qualifica = qualifica;
    }

    public String getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(String dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    
    @Override
    public String toString() {
        return "Soggetto{" + "soggetto=" + soggetto + ", cognome=" + cognome + ", nome=" + nome + ", qualifica=" + qualifica + ", dataAssunzione=" + dataAssunzione + ", codiceFiscale=" + codiceFiscale + ", nomeCompleto=" + nomeCompleto + '}';
    }
    
}
