/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeOperacije;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemskeOperacije.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Lenovo
 */
public class SacuvajProdavcaSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor operacija(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor transferObjekat = new ServerskiOdgovor();
        try {
            DBBroker.getInstance().unesi(odo);
            transferObjekat.setOdgovor(null);
            transferObjekat.setUspesno(true);
            transferObjekat.setPoruka("Sistem je sacuvao prodavca");
        } catch (SQLException ex) {
            Logger.getLogger(SacuvajProdavcaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem nije sacuvao prodavca");
        }
        return transferObjekat;
    }

    @Override
    public void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        
    }
    
}
