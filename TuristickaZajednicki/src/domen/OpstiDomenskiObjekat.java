/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface OpstiDomenskiObjekat extends Serializable{

    public String tabela();

    public String koloneUnos();

    public String vrednostiUnos();

    public String vrednostiUpdate();

    public String wherePrimarniKljuc();

    public String joinUslov();

    public String whereSelect();
    
    public List<OpstiDomenskiObjekat> napraviListu(ResultSet rs) throws SQLException;

    public String maxKljuc();
    
}
