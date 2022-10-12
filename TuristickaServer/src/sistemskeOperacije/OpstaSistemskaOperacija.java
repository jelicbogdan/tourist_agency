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
import transfer.ServerskiOdgovor;

/**
 *
 * @author Lenovo
 */
public abstract class OpstaSistemskaOperacija {
    
    public ServerskiOdgovor transakcija(OpstiDomenskiObjekat odo) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            DBBroker.getInstance().ucitajDrajver();
            DBBroker.getInstance().otvoriKonekciju();
            preduslov(odo);
            so = operacija(odo);
            DBBroker.getInstance().commit();
        } catch (Exception ex) {
            Logger.getLogger(OpstaSistemskaOperacija.class.getName()).log(Level.SEVERE, null, ex);
            DBBroker.getInstance().rollback();
            so.setUspesno(false);
            so.setPoruka(ex.getMessage());
        }finally {
            try {
                DBBroker.getInstance().zatvoriKonekciju();
            } catch (SQLException ex) {
                so.setUspesno(false);
                so.setPoruka(ex.getMessage());
            }
        }
        
        return so;
    }

    public abstract ServerskiOdgovor operacija(OpstiDomenskiObjekat odo) throws Exception;
    public abstract void preduslov(OpstiDomenskiObjekat odo) throws Exception;
}
