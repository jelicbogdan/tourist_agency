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
public class HotelAranzman implements OpstiDomenskiObjekat{
    private Aranzman aranzman;
    private Hotel hotel;
    private Date datumOd;
    private Date datumDo;

    public HotelAranzman() {
    }

    public HotelAranzman(Aranzman aranzman, Hotel hotel, Date datumOd, Date datumDo) {
        this.aranzman = aranzman;
        this.hotel = hotel;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Aranzman getAranzman() {
        return aranzman;
    }

    public void setAranzman(Aranzman aranzman) {
        this.aranzman = aranzman;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    @Override
    public String tabela() {
        return " hotelaranzman ";
    }

    @Override
    public String koloneUnos() {
        return "sifraAranzmana,sifraHotela,datumOd,datumDo";
    }
    
    @Override
    public String vrednostiUnos() {
        return aranzman.getSifraAranzmana() +"," + hotel.getSifraHotela() + ",'" + new java.sql.Date(datumOd.getTime()) + "','" + new java.sql.Date(datumDo.getTime()) + "'";
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
        return " ha join hotel h on ha.sifraHotela = h.sifraHotela";
    }

    @Override
    public String whereSelect() {
        return " WHERE ha.sifraAranzmana = " + aranzman.getSifraAranzmana();
    }

    @Override
    public List<OpstiDomenskiObjekat> napraviListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Hotel h = new Hotel(rs.getInt("sifraHotela"), rs.getString("nazivHotela"));
            lista.add(new HotelAranzman(null, h, new Date(rs.getDate("datumOd").getTime()), new Date(rs.getDate("datumDo").getTime())));
        }
        
        return lista;
    }

    @Override
    public String maxKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
