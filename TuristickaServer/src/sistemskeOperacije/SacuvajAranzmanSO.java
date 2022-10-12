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
public class SacuvajAranzmanSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor operacija(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor transferObjekat = new ServerskiOdgovor();
        try {
            DBBroker.getInstance().unesi(odo);
            
            int sifraAranzmana = DBBroker.getInstance().vratiID(odo);
            
            Aranzman aranzman = (Aranzman) odo;
            aranzman.setSifraAranzmana(sifraAranzmana);
            
            List<OpstiDomenskiObjekat> listaHotelAranzman = aranzman.getListaHotelAranzmana();
            
            for (OpstiDomenskiObjekat ha : listaHotelAranzman) {
                HotelAranzman hotelAranzman = (HotelAranzman) ha;
                hotelAranzman.setAranzman(aranzman);
                DBBroker.getInstance().unesi(hotelAranzman);
            }
            
            
            List<OpstiDomenskiObjekat> listaTransportAranzman = aranzman.getListaTransportAranzmana();
            
            for (OpstiDomenskiObjekat ta : listaTransportAranzman) {
                TransportAranzman transportAranzman = (TransportAranzman) ta;
                transportAranzman.setAranzman(aranzman);
                DBBroker.getInstance().unesi(transportAranzman);
            }
            
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Sistem je sacuvao aranzman");
        } catch (SQLException ex) {
            Logger.getLogger(SacuvajAranzmanSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem nije sacuvao aranzman");
        }
        return transferObjekat;
    }

    @Override
    public void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        
    }
    
}
