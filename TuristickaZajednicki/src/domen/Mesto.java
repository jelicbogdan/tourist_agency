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
public class Mesto implements OpstiDomenskiObjekat{
    
    private int sifraMesta;
    private String nazivMesta;
    private String postanskiBroj;

    public Mesto() {
    }

    public Mesto(int sifraMesta, String nazivMesta, String postanskiBroj) {
        this.sifraMesta = sifraMesta;
        this.nazivMesta = nazivMesta;
        this.postanskiBroj = postanskiBroj;
    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public int getSifraMesta() {
        return sifraMesta;
    }

    public void setSifraMesta(int sifraMesta) {
        this.sifraMesta = sifraMesta;
    }

    public String getNazivMesta() {
        return nazivMesta;
    }

    public void setNazivMesta(String nazivMesta) {
        this.nazivMesta = nazivMesta;
    }

    @Override
    public String toString() {
        return nazivMesta;
    }

    @Override
    public String tabela() {
        return "mesto m ";
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
            lista.add(new Mesto(rs.getInt("sifraMesta"), rs.getString("nazivMesta"), rs.getString("postanskiBroj")));
        }
        
        return lista;
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        if (this.sifraMesta != other.sifraMesta) {
            return false;
        }
        return true;
    }
}
