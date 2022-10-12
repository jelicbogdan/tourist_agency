/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.HotelAranzman;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class ModelTabeleHotelAranzman extends AbstractTableModel{
    
    List<OpstiDomenskiObjekat> lista;
    SimpleDateFormat sdf;

    public ModelTabeleHotelAranzman() {
        lista = new ArrayList<>();
        sdf = new SimpleDateFormat("dd.MM.yyyy");
    }
    
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HotelAranzman ha = (HotelAranzman) lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return ha.getHotel();
            case 1: return sdf.format(ha.getDatumOd());
            case 2: return sdf.format(ha.getDatumDo());
            
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Hotel";
            case 1: return "Datum od";
            case 2: return "Datum do";
            default: return "";
        }
    }

    public void dodaj(OpstiDomenskiObjekat odo){
        lista.add(odo);
        fireTableDataChanged();
    }
    
    public void obrisi(int red){
        lista.remove(red);
        fireTableDataChanged();
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    
    
}
