/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.HotelAranzman;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.TransportAranzman;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class ModelTabeleTransportAranzman extends AbstractTableModel{
    
    List<OpstiDomenskiObjekat> lista;
    SimpleDateFormat sdf;

    public ModelTabeleTransportAranzman() {
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
        TransportAranzman ha = (TransportAranzman) lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return ha.getTransport();
            case 1: return sdf.format(ha.getDatumPolaska());
            case 2: return sdf.format(ha.getDatumOdlaska());
            
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Transport";
            case 1: return "Datum polaska";
            case 2: return "Datum odlaska";
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
