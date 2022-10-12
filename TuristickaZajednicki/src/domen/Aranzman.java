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
public class Aranzman implements OpstiDomenskiObjekat{
    private int sifraAranzmana;
    private String destinacija;
    private Prodavac prodavac;
    
    List<OpstiDomenskiObjekat> listaHotelAranzmana;
    List<OpstiDomenskiObjekat> listaTransportAranzmana;

    public Aranzman() {
        listaHotelAranzmana = new ArrayList<>();
        listaTransportAranzmana = new ArrayList<>();
    }

    public Aranzman(int sifraAranzmana, String destinacija, Prodavac prodavac, List<OpstiDomenskiObjekat> listaHotelAranzmana, List<OpstiDomenskiObjekat> listaTransportAranzmana) {
        this.sifraAranzmana = sifraAranzmana;
        this.destinacija = destinacija;
        this.prodavac = prodavac;
        this.listaHotelAranzmana = listaHotelAranzmana;
        this.listaTransportAranzmana = listaTransportAranzmana;
    }
    
    

    public int getSifraAranzmana() {
        return sifraAranzmana;
    }

    public void setSifraAranzmana(int sifraAranzmana) {
        this.sifraAranzmana = sifraAranzmana;
    }

    public String getDestinacija() {
        return destinacija;
    }

    public void setDestinacija(String destinacija) {
        this.destinacija = destinacija;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public List<OpstiDomenskiObjekat> getListaHotelAranzmana() {
        return listaHotelAranzmana;
    }

    public void setListaHotelAranzmana(List<OpstiDomenskiObjekat> listaHotelAranzmana) {
        this.listaHotelAranzmana = listaHotelAranzmana;
    }

    public List<OpstiDomenskiObjekat> getListaTransportAranzmana() {
        return listaTransportAranzmana;
    }

    public void setListaTransportAranzmana(List<OpstiDomenskiObjekat> listaTransportAranzmana) {
        this.listaTransportAranzmana = listaTransportAranzmana;
    }

    @Override
    public String tabela() {
        return " aranzman ";
    }

    @Override
    public String koloneUnos() {
        return "destinacija, sifraProdavca";
    }

    @Override
    public String vrednostiUnos() {
        return "'" + destinacija + "'," + prodavac.getSifraProdavca();
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
        return " a join prodavac p on a.sifraProdavca = p.sifraProdavca";
    }

    @Override
    public String whereSelect() {
        return " WHERE a.destinacija LIKE '%" + destinacija +"%'";
    }

    @Override
    public List<OpstiDomenskiObjekat> napraviListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Prodavac p = new Prodavac(rs.getInt("sifraProdavca"), rs.getString("imeProdavca"), rs.getString("prezimeProdavca"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
            lista.add(new Aranzman(rs.getInt("sifraAranzmana"), rs.getString("destinacija"), p, null, null));
        }
        
        return lista;
    }

    @Override
    public String maxKljuc() {
        return "sifraAranzmana";
    }

    @Override
    public String toString() {
        return destinacija;
    }

    
}
