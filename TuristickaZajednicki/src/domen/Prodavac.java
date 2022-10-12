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
public class Prodavac implements OpstiDomenskiObjekat{
    private int sifraProdavca;
    private String imeProdavca;
    private String prezimeProdavca;
    private String korisnickoIme;
    private String lozinka;

    public Prodavac() {
    }

    public Prodavac(int sifraProdavca, String imeProdavca, String prezimeProdavca, String korisnickoIme, String lozinka) {
        this.sifraProdavca = sifraProdavca;
        this.imeProdavca = imeProdavca;
        this.prezimeProdavca = prezimeProdavca;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getSifraProdavca() {
        return sifraProdavca;
    }

    public void setSifraProdavca(int sifraProdavca) {
        this.sifraProdavca = sifraProdavca;
    }

    public String getImeProdavca() {
        return imeProdavca;
    }

    public void setImeProdavca(String imeProdavca) {
        this.imeProdavca = imeProdavca;
    }

    public String getPrezimeProdavca() {
        return prezimeProdavca;
    }

    public void setPrezimeProdavca(String prezimeProdavca) {
        this.prezimeProdavca = prezimeProdavca;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String toString() {
        return imeProdavca + " " + prezimeProdavca;
    }

    @Override
    public String tabela() {
        return " prodavac ";
    }

    @Override
    public String koloneUnos() {
        return "imeProdavca,prezimeProdavca,korisnickoIme,lozinka";
    }

    @Override
    public String vrednostiUnos() {
        return "'" + imeProdavca +"','" + prezimeProdavca +"','" + korisnickoIme +"','" + lozinka +"'";
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
        if(!korisnickoIme.isEmpty() && !lozinka.isEmpty()){
            return " WHERE korisnickoIme = '" + korisnickoIme +"' AND lozinka='" + lozinka +"'";
        }
        
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> napraviListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            lista.add(new Prodavac(rs.getInt("sifraProdavca"), rs.getString("imeProdavca"), rs.getString("prezimeProdavca"), rs.getString("korisnickoIme"), rs.getString("lozinka")));
        }
        
        return lista;
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
