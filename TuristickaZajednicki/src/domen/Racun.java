/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Racun implements OpstiDomenskiObjekat{
    private int sifraRacuna;
    private Klijent klijent;
    private Prodavac prodavac;
    private Date datumIzdavanja;
    private double ukupnaVrednost;
    
    private List<OpstiDomenskiObjekat> lista;

    public Racun() {
        lista = new ArrayList<>();
    }

    public Racun(int sifraRacuna, Klijent klijent, Prodavac prodavac, Date datumIzdavanja, double ukupnaVrednost, List<OpstiDomenskiObjekat> lista) {
        this.sifraRacuna = sifraRacuna;
        this.klijent = klijent;
        this.prodavac = prodavac;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupnaVrednost = ukupnaVrednost;
        this.lista = lista;
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }

    public int getSifraRacuna() {
        return sifraRacuna;
    }

    public void setSifraRacuna(int sifraRacuna) {
        this.sifraRacuna = sifraRacuna;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public double getUkupnaVrednost() {
        return ukupnaVrednost;
    }

    public void setUkupnaVrednost(double ukupnaVrednost) {
        this.ukupnaVrednost = ukupnaVrednost;
    }

    @Override
    public String tabela() {
        return " racun ";
    }

    @Override
    public String koloneUnos() {
        return "datumIzdavanja, ukupnaVrednost, sifraKlijenta, sifraProdavca";
    }

    @Override
    public String vrednostiUnos() {
        return "NOW()," + ukupnaVrednost + "," + klijent.getSifraKlijenta() + "," + prodavac.getSifraProdavca();
    }

    @Override
    public String vrednostiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String wherePrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String joinUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String whereSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> napraviListu(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String maxKljuc() {
        return " sifraRacuna ";
    }
    
    
}
