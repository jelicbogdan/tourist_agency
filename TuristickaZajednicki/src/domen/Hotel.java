/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Hotel implements OpstiDomenskiObjekat{
    
    private int sifraHotela;
    private String nazivHotela;

    public Hotel() {
    }

    public Hotel(int sifraHotela, String nazivHotela) {
        this.sifraHotela = sifraHotela;
        this.nazivHotela = nazivHotela;
    }

    public String getNazivHotela() {
        return nazivHotela;
    }

    public void setNazivHotela(String nazivHotela) {
        this.nazivHotela = nazivHotela;
    }

    public int getSifraHotela() {
        return sifraHotela;
    }

    public void setSifraHotela(int sifraHotela) {
        this.sifraHotela = sifraHotela;
    }

    @Override
    public String toString() {
        return nazivHotela;
    }

    @Override
    public String tabela() {
        return " hotel ";
    }

    @Override
    public String koloneUnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostiUnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "";
    }

    @Override
    public String whereSelect() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> napraviListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            lista.add(new Hotel(rs.getInt("sifraHotela"), rs.getString("nazivHotela")));
        }
        
        return lista;
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
