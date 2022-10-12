/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import properties.CitacPropertiFajla;

/**
 *
 * @author Lenovo
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection konekcija;
    
    private DBBroker() {
    }

    public static DBBroker getInstance() {
        if(instance == null)
            instance = new DBBroker();
        return instance;
    }
    public void ucitajDrajver() throws ClassNotFoundException{
        Class.forName(CitacPropertiFajla.getInstance().vratiVrednost("driver"));

    }
    
    public void otvoriKonekciju() throws SQLException{
      
        konekcija = DriverManager.getConnection(CitacPropertiFajla.getInstance().vratiVrednost("url"), CitacPropertiFajla.getInstance().vratiVrednost("user"), CitacPropertiFajla.getInstance().vratiVrednost("pass"));
        konekcija.setAutoCommit(false);
      
    }
    public void zatvoriKonekciju() throws SQLException{
        konekcija.close();
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void unesi(OpstiDomenskiObjekat odo) throws SQLException{
        String sql = "INSERT INTO "+odo.tabela()+"("+odo.koloneUnos()+")"+" VALUES ("+odo.vrednostiUnos()+")";
        System.out.println(sql);
        Statement s = konekcija.createStatement();
        s.executeUpdate(sql);
        s.close();
    }
    
    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException{
        String sql = "UPDATE "+odo.tabela()+" SET "+odo.vrednostiUpdate()+" WHERE "+odo.wherePrimarniKljuc();
        System.out.println(sql);
        Statement s = konekcija.createStatement();
        s.executeUpdate(sql);
        s.close();
    }
    
    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException{
        String sql = "DELETE FROM "+odo.tabela()+" WHERE "+odo.wherePrimarniKljuc();
        System.out.println(sql);
        Statement s = konekcija.createStatement();
        s.executeUpdate(sql);
        s.close();
    }
    
    public ResultSet vratiSve(OpstiDomenskiObjekat odo) throws SQLException{
        String sql = "SELECT * FROM "+odo.tabela()
                +odo.joinUslov()+odo.whereSelect();
        System.out.println(sql);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(sql);
        return rs;
    }

    public int vratiID(OpstiDomenskiObjekat odo) throws SQLException{
        int maks = 0;
        String sql = "SELECT max("+odo.maxKljuc()+") as maksKljuc FROM "+odo.tabela();
        System.out.println(sql);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while(rs.next())
            maks = rs.getInt("maksKljuc");
        
        return maks;
    }
}
