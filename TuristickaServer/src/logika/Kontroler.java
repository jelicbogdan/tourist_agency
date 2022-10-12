/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.OpstiDomenskiObjekat;
import sistemskeOperacije.IzmeniKlijentaSO;
import sistemskeOperacije.PretraziAranzmaneSO;
import sistemskeOperacije.PretraziKlijenteSO;
import sistemskeOperacije.SacuvajAranzmanSO;
import sistemskeOperacije.SacuvajKlijentaSO;
import sistemskeOperacije.SacuvajProdavcaSO;
import sistemskeOperacije.SacuvajRacun;
import sistemskeOperacije.UlogujProdavcaSO;
import sistemskeOperacije.VratiHoteleSO;
import sistemskeOperacije.VratiListuMestaSO;
import sistemskeOperacije.VratiTransporteSO;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Lenovo
 */
public class Kontroler {
    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if(null == instanca)
            instanca = new Kontroler();
        
        return instanca;
    }

    public ServerskiOdgovor vratiMesta(OpstiDomenskiObjekat odo) {
        return new VratiListuMestaSO().transakcija(odo);
    }

    public ServerskiOdgovor uloguj(OpstiDomenskiObjekat odo) {
        return new UlogujProdavcaSO().transakcija(odo);
    }

    public ServerskiOdgovor unesiKlijenta(OpstiDomenskiObjekat odo) {
        return new SacuvajKlijentaSO().transakcija(odo);
    }

    public ServerskiOdgovor unesiProdavca(OpstiDomenskiObjekat odo) {
        return new SacuvajProdavcaSO().transakcija(odo);
    }

    public ServerskiOdgovor pretraziKlijente(OpstiDomenskiObjekat odo) {
        return new PretraziKlijenteSO().transakcija(odo);
    }

    public ServerskiOdgovor izmeniKlijenta(OpstiDomenskiObjekat odo) {
        return new IzmeniKlijentaSO().transakcija(odo);
    }

    public ServerskiOdgovor sacuvajAranzman(OpstiDomenskiObjekat odo) {
        return new SacuvajAranzmanSO().transakcija(odo);
    }

    public ServerskiOdgovor pretraziAranzmane(OpstiDomenskiObjekat odo) {
        return new PretraziAranzmaneSO().transakcija(odo);
    }

    public ServerskiOdgovor vratiHotele(OpstiDomenskiObjekat odo) {
        return new VratiHoteleSO().transakcija(odo);
    }

    public ServerskiOdgovor vratiTransporte(OpstiDomenskiObjekat odo) {
        return new VratiTransporteSO().transakcija(odo);
    }
    public ServerskiOdgovor sacuvajRacun(OpstiDomenskiObjekat odo) {
        return new SacuvajRacun().transakcija(odo);
    }
    
    
}
