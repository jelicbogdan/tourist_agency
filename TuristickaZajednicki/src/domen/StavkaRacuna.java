/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class StavkaRacuna implements OpstiDomenskiObjekat{
    private int redniBroj;
    private Racun racun;
    private Aranzman aranzman;
    private int popust;
    private double iznos;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int redniBroj, Racun racun, Aranzman aranzman, int popust, double iznos) {
        this.redniBroj = redniBroj;
        this.racun = racun;
        this.aranzman = aranzman;
        this.popust = popust;
        this.iznos = iznos;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public Aranzman getAranzman() {
        return aranzman;
    }

    public void setAranzman(Aranzman aranzman) {
        this.aranzman = aranzman;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    @Override
    public String tabela() {
        return " stavkaRacuna ";
    }

    @Override
    public String koloneUnos() {
        return "sifraRacuna, sifraAranzmana, popust, iznos";
    }

    @Override
    public String vrednostiUnos() {
        return racun.getSifraRacuna() + "," + aranzman.getSifraAranzmana() +"," +popust + "," + iznos;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double izracuanIznosSaPopustom() {
        return iznos * ((100.00 - popust) / 100.00);
    }
    
    
}
