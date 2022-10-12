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
public class Klijent implements OpstiDomenskiObjekat{
    private int sifraKlijenta;
    private String imeKlijenta;
    private String prezimeKlijenta;
    private String brojTelefona;
    private String adresa;
    private Mesto mesto;

    public Klijent() {
    }

    public Klijent(int sifraKlijenta, String imeKlijenta, String prezimeKlijenta, String brojTelefona, String adresa, Mesto mesto) {
        this.sifraKlijenta = sifraKlijenta;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.brojTelefona = brojTelefona;
        this.adresa = adresa;
        this.mesto = mesto;
    }

    
    
    public int getSifraKlijenta() {
        return sifraKlijenta;
    }

    public void setSifraKlijenta(int sifraKlijenta) {
        this.sifraKlijenta = sifraKlijenta;
    }

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public String getPrezimeKlijenta() {
        return prezimeKlijenta;
    }

    public void setPrezimeKlijenta(String prezimeKlijenta) {
        this.prezimeKlijenta = prezimeKlijenta;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return imeKlijenta + " " + prezimeKlijenta;
    }

    @Override
    public String tabela() {
        return "klijent ";
    }

    @Override
    public String koloneUnos() {
        return "imeKlijenta,prezimeKlijenta,brojTelefona,adresa,sifraMesta";
    }

    @Override
    public String vrednostiUnos() {
        return "'" + imeKlijenta + "','" + prezimeKlijenta+ "','" + brojTelefona + "','" + adresa + "'," + mesto.getSifraMesta();
    }

    @Override
    public String vrednostiUpdate() {
        return "imeKlijenta = '" + imeKlijenta + "',prezimeKlijenta = '" + prezimeKlijenta+ "',brojTelefona = '" + brojTelefona + "',adresa='" + adresa + "',sifraMesta=" + mesto.getSifraMesta();
    }

    @Override
    public String wherePrimarniKljuc() {
        return " sifraKlijenta = " + sifraKlijenta;
    }

    @Override
    public String joinUslov() {
        return " k join mesto m on k.sifraMesta=m.sifraMesta";
    }

    @Override
    public String whereSelect() {
        if(imeKlijenta.isEmpty()){
            return "";
        }
        
        return " WHERE CONCAT(k.imeKlijenta,' ', k.prezimeKlijenta) LIKE '%" + imeKlijenta + "%'";
    }

    @Override
    public List<OpstiDomenskiObjekat> napraviListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            lista.add(new Klijent(rs.getInt("sifraKlijenta"), rs.getString("imeKlijenta"), rs.getString("prezimeKlijenta"), rs.getString("brojTelefona"), rs.getString("adresa"), new Mesto(rs.getInt("sifraMesta"), rs.getString("nazivMesta"), rs.getString("postanskiBroj"))));
        }
        
        return lista;
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
