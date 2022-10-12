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
public class Transport implements OpstiDomenskiObjekat{
    
    private int sifraTransporta;
    private String nazivTransporta;

    public Transport() {
    }

    public Transport(int sifraTransporta, String nazivTransporta) {
        this.sifraTransporta = sifraTransporta;
        this.nazivTransporta = nazivTransporta;
    }

    public String getNazivTransporta() {
        return nazivTransporta;
    }

    public void setNazivTransporta(String nazivTransporta) {
        this.nazivTransporta = nazivTransporta;
    }

    public int getSifraTransporta() {
        return sifraTransporta;
    }

    public void setSifraTransporta(int sifraTransporta) {
        this.sifraTransporta = sifraTransporta;
    }

    @Override
    public String toString() {
        return nazivTransporta;
    }

    @Override
    public String tabela() {
        return " transport ";
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
            lista.add(new Transport(rs.getInt("sifraTransporta"), rs.getString("nazivTransporta")));
        }
        
        return lista;
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
