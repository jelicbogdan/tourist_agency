/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeOperacije;

import db.DBBroker;
import domen.Aranzman;
import domen.HotelAranzman;
import domen.OpstiDomenskiObjekat;
import domen.Racun;
import domen.StavkaRacuna;
import domen.TransportAranzman;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemskeOperacije.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Lenovo
 */
public class SacuvajRacun extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor operacija(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor transferObjekat = new ServerskiOdgovor();
        try {
            DBBroker.getInstance().unesi(odo);
            
            int sifraRacuna = DBBroker.getInstance().vratiID(odo);
            
            Racun racun = (Racun) odo;
            racun.setSifraRacuna(sifraRacuna);
            
            List<OpstiDomenskiObjekat> listaHotelAranzman = racun.getLista();
            
            for (OpstiDomenskiObjekat stavka : listaHotelAranzman) {
                StavkaRacuna s = (StavkaRacuna) stavka;
                s.setRacun(racun);
                DBBroker.getInstance().unesi(s);
            }
            
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Sistem je sacuvao racun");
        } catch (SQLException ex) {
            Logger.getLogger(SacuvajRacun.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem nije sacuvao racun");
        }
        return transferObjekat;
    }

    @Override
    public void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        
    }
    
}
