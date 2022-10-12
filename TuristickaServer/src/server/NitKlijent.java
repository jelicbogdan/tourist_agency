/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;



import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import operacije.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Lenovo
 */
public class NitKlijent extends Thread{
    
    Socket soket;
    boolean kraj = false;
    

    public NitKlijent(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {
        while (!kraj) {            
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            OpstiDomenskiObjekat odo = kz.getParametar();
            switch(kz.getOperacija()){
                case Operacije.VRATI_MESTA:
                    so = Kontroler.getInstanca().vratiMesta(odo);
                    break;
                case Operacije.ULOGUJ:
                    so = Kontroler.getInstanca().uloguj(odo);
                    break;
                case Operacije.UNOS_KLIJENTA:
                    so = Kontroler.getInstanca().unesiKlijenta(odo);
                    break;
                case Operacije.UNESI_PRODAVCA:
                    so = Kontroler.getInstanca().unesiProdavca(odo);
                    break;
                case Operacije.PRETRAGA_KLIJENTA:
                    so = Kontroler.getInstanca().pretraziKlijente(odo);
                    break;
                case Operacije.IZMENA_KLIJENTA:
                    so = Kontroler.getInstanca().izmeniKlijenta(odo);
                    break;
                case Operacije.SACUVAJ_ARANZMAN:
                    so = Kontroler.getInstanca().sacuvajAranzman(odo);
                    break;
                case Operacije.PRETRAZI_ARANZMAN:
                    so = Kontroler.getInstanca().pretraziAranzmane(odo);
                    break;
                case Operacije.VRATI_HOTELE:
                    so = Kontroler.getInstanca().vratiHotele(odo);
                    break;
                case Operacije.VRATI_TRANSPORTE:
                    so = Kontroler.getInstanca().vratiTransporte(odo);
                    break;
                case Operacije.SACUVAJ_RACUN:
                    so = Kontroler.getInstanca().sacuvajRacun(odo);
                    break;
                case Operacije.KRAJ:
                    kraj=true;
                    so.setPoruka("Sistem je zavrsio sa radom.");
                    break;
            }
            posalji(so);
        }
    }
    
    public void posalji(ServerskiOdgovor so){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public KlijentskiZahtev primiZahtev(){
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return kz;
    }
}
