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
public class TransportAranzman implements OpstiDomenskiObjekat{
    private Aranzman aranzman;
    private Transport transport;
    private Date datumPolaska;
    private Date datumOdlaska;

    public TransportAranzman() {
    }

    public TransportAranzman(Aranzman aranzman, Transport transport, Date datumPolaska, Date datumOdlaska) {
        this.aranzman = aranzman;
        this.transport = transport;
        this.datumPolaska = datumPolaska;
        this.datumOdlaska = datumOdlaska;
    }

    public Date getDatumOdlaska() {
        return datumOdlaska;
    }

    public void setDatumOdlaska(Date datumOdlaska) {
        this.datumOdlaska = datumOdlaska;
    }

    public Aranzman getAranzman() {
        return aranzman;
    }

    public void setAranzman(Aranzman aranzman) {
        this.aranzman = aranzman;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Date getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    @Override
    public String tabela() {
        return " transportaranzman ";
    }

    @Override
    public String koloneUnos() {
        return "sifraAranzmana,sifraTransporta,datumPolaska,datumOdlaska";
    }
    
    @Override
    public String vrednostiUnos() {
        return aranzman.getSifraAranzmana() +"," + transport.getSifraTransporta()+ ",'" + new java.sql.Date(datumPolaska.getTime()) + "','" + new java.sql.Date(datumOdlaska.getTime()) + "'";
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
        return " ta join transport t on ta.sifraTransporta = t.sifraTransporta";
    }

    @Override
    public String whereSelect() {
        return " WHERE ta.sifraAranzmana = " + aranzman.getSifraAranzmana();
    }

    @Override
    public List<OpstiDomenskiObjekat> napraviListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Transport t = new Transport(rs.getInt("sifraTransporta"), rs.getString("nazivTransporta"));
            lista.add(new TransportAranzman(null, t, new Date(rs.getDate("datumPolaska").getTime()), new Date(rs.getDate("datumOdlaska").getTime())));
        }
        
        return lista;
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
