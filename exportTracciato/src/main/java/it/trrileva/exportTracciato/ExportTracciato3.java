package it.trrileva.exportTracciato;

import com.opencsv.bean.CsvToBeanBuilder;
import it.trrileva.exportTracciato.entity.Giustificativo2;
import it.trrileva.exportTracciato.entity.Presenza;
import it.trrileva.exportTracciato.entity.Soggetto;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExportTracciato3 {

    static Map<Integer, Soggetto> soggettiMap = new HashMap<>();
    static Map<Integer, Giustificativo2> giustificativiMap = new HashMap<>();
        
    public static void execute(String meseIn, String annoIn, String dittaIn, String filePathGiustificativi, String filePathSoggetti, String filePathPresenze) throws Exception {
        
        
        List<Object> soggetti;
        List<Object> giustificativi;
        List<Object> presenze;
        
        ArrayList<Riga> righe = new ArrayList<>();
        
        /* lettura del file soggetti csv */
        soggetti = new CsvToBeanBuilder<>(new FileReader(filePathSoggetti))
            .withType(Soggetto.class)
            .withSeparator(';')
            .build()
            .parse();
        
        /* filtro e pulizia del file soggetti */
        for(int i = 0; i < soggetti.size(); i++) {
            Soggetto soggetto = (Soggetto) soggetti.get(i);
            if(i == 0) {
                soggetti.remove(i);
            } else if(soggetto.getSoggetto().equals("")) {
                soggetti.remove(soggetto);
            }
        }
        
        /* stampa di controllo */
        //soggetti.forEach(System.out::println);
        
        /* inserimento soggetti nella mappa */
        for (Object object : soggetti) {
            Soggetto soggetto = (Soggetto) object;
            if(!soggetto.getSoggetto().trim().equals("")){
            soggettiMap.put(Integer.parseInt(soggetto.getSoggetto()), soggetto);
            }
        }
        
         /* lettura del file giustificativi csv */
        giustificativi = new CsvToBeanBuilder<>(new FileReader(filePathGiustificativi))
            .withType(Giustificativo2.class)
            .withSeparator(';')
            .build()
            .parse();
        
         /* filtro e pulizia del file giustificativi */
        for(int i = 0; i < giustificativi.size(); i++) {
            Giustificativo2 giustificativo = (Giustificativo2) giustificativi.get(i);
            if(i == 0) {
                giustificativi.remove(i);
            } else if(giustificativo.getCodice().trim().equals("") || giustificativo.getDescrizione() == null) {
                giustificativi.remove(giustificativo);
            }
        }
        
        /* stampa di controllo */
        //giustificativi.forEach(System.out::println);
        
        /* inserimento soggetti nella mappa */
        giustificativi.stream().map(object -> (Giustificativo2) object).forEachOrdered(giustificativo -> {
            if(!giustificativo.getCodice().trim().equals("")){
            giustificativiMap.put(Integer.parseInt(giustificativo.getCodice()), giustificativo);
            }
        });
        
        /* lettura del file presenze csv */
        presenze = new CsvToBeanBuilder<>(new FileReader(filePathPresenze))
            .withType(Presenza.class)
            .withSeparator(';')
            .build()
            .parse();
        
        /* filtro e pulizia del file soggetti */
        for(int i = 0; i < presenze.size(); i++) {
            Presenza presenza = (Presenza) presenze.get(i);
            if(i == 0) {
                presenze.remove(i);
            } else if(presenza.getDitta().equals("")) {
                presenze.remove(presenza);
            }
        }
        
        /* stampa di controllo */
        //presenze.forEach(System.out::println);
        
        try {
            for (Object object : presenze) {
            Presenza presenza = (Presenza) object;
                if(!presenza.getDitta().trim().equals("") && presenza.getAnno().equals(annoIn) && Integer.parseInt(presenza.getMese()) == Integer.parseInt(meseIn)
                        && (Integer.parseInt(presenza.getOre()) != 0 || Integer.parseInt(presenza.getMinuti()) != 0) 
                        && giustificativiMap.containsKey(Integer.parseInt(presenza.getCausale())) && soggettiMap.containsKey(Integer.parseInt(presenza.getCodiceDipendente()))){
                    Riga riga = new Riga();
                    riga.anno = Integer.parseInt(presenza.getAnno());
                    riga.mese = Integer.parseInt(presenza.getMese());
                    riga.giorno = Integer.parseInt(presenza.getGiorno());
                    riga.ore = Double.parseDouble(presenza.getOre());
                    riga.minuti = Double.parseDouble(presenza.getMinuti());
                    riga.cf = soggettiMap.get(Integer.parseInt(presenza.getCodiceDipendente())).getCodiceFiscale();
                    riga.cognome = soggettiMap.get(Integer.parseInt(presenza.getCodiceDipendente())).getCognome();
                    riga.matricola = soggettiMap.get(Integer.parseInt(presenza.getCodiceDipendente())).getSoggetto();
                    riga.nome = soggettiMap.get(Integer.parseInt(presenza.getCodiceDipendente())).getNome();
                    riga.nominativo = soggettiMap.get(Integer.parseInt(presenza.getCodiceDipendente())).getNomeCompleto();
                    riga.task = giustificativiMap.get(Integer.parseInt(presenza.getCausale())).getDescrizione();
                
                    righe.add(riga);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Collections.sort(righe);
        
	List<Tracciato> lista = GeneraTracciato.preparaDipendenti(righe, Integer.parseInt(meseIn), dittaIn);
        
        /* stampa di prova */
        lista.forEach(System.out::println);
    }
}
