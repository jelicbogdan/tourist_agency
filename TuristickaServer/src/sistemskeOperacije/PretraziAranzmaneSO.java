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
import java.awt.Transparency;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemskeOperacije.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Lenovo
 */
public class PretraziAranzmaneSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor operacija(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<OpstiDomenskiObjekat> lista = odo.napraviListu(DBBroker.getInstance().vratiSve(odo));
            List<OpstiDomenskiObjekat> listaZaSlanje = new ArrayList<>();
            
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista) {
                Aranzman a = (Aranzman) opstiDomenskiObjekat;
                
                HotelAranzman ha = new HotelAranzman();
                ha.setAranzman(a);
                List<OpstiDomenskiObjekat> listaHa = ha.napraviListu(DBBroker.getInstance().vratiSve(ha));
                
                TransportAranzman ta = new TransportAranzman();
                ta.setAranzman(a);
                List<OpstiDomenskiObjekat> listaTa = ta.napraviListu(DBBroker.getInstance().vratiSve(ta));
                
                a.setListaHotelAranzmana(listaHa);
                a.setListaTransportAranzmana(listaTa);
                
                listaZaSlanje.add(a);
            }
            
            
            so.setOdgovor(listaZaSlanje);
            so.setUspesno(true);
            so.setPoruka("Sistem je pronasao aranzmane po zadatim kriterijumima pretrage");
        } catch (SQLException ex) {
            Logger.getLogger(PretraziAranzmaneSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem nije pronasao aranzmane po zadatim kriterijumima pretrage");
        }
        return so;
    }

    @Override
    public void preduslov(OpstiDomenskiObjekat odo) throws Exception {
    }
    
}
