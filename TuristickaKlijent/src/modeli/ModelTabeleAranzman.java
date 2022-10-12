/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Aranzman;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class ModelTabeleAranzman extends AbstractTableModel{
    
    List<OpstiDomenskiObjekat> lista;

    public ModelTabeleAranzman() {
        lista = new ArrayList<>();
    }
    
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aranzman a = (Aranzman) lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return a.getDestinacija();
            case 1: return a.getProdavac();
            case 2: return a.getListaHotelAranzmana().size();
            case 3: return a.getListaTransportAranzmana().size();
            
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Destinacija";
            case 1: return "Prodavac";
            case 2: return "Broj aranzmana hotela";
            case 3: return "Broj aranzmana transporta";
            default: return "";
        }
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    public OpstiDomenskiObjekat vratiObjekat(int red){
        return lista.get(red);
    }
    
    
    
    
}
