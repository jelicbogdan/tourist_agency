/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeOperacije;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
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
public class UlogujProdavcaSO extends OpstaSistemskaOperacija{

    @Override
    public ServerskiOdgovor operacija(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<OpstiDomenskiObjekat> lista = odo.napraviListu(DBBroker.getInstance().vratiSve(odo));
            
            if(lista.isEmpty()){
                throw new Exception("Sistem nije pronasao prodavca po zadatim kriterijumima pretrage");
            }
            
            so.setOdgovor(lista.get(0));
            so.setUspesno(true);
            so.setPoruka("Sistem je pronasao prodavca po zadatim kriterijumima pretrage");
        } catch (SQLException ex) {
            Logger.getLogger(UlogujProdavcaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Sistem nije pronasao prodavca po zadatim kriterijumima pretrage");
        }
        return so;
    }

    @Override
    public void preduslov(OpstiDomenskiObjekat odo) throws Exception {
    }
    
}
