/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class ModelTabeleKlijenti extends AbstractTableModel{
    
    List<OpstiDomenskiObjekat> lista;

    public ModelTabeleKlijenti() {
        lista = new ArrayList<>();
    }
    
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent klijent = (Klijent) lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return klijent.getImeKlijenta();
            case 1: return klijent.getPrezimeKlijenta();
            case 2: return klijent.getAdresa();
            case 3: return klijent.getBrojTelefona();
            
            case 4: return klijent.getMesto();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Ime";
            case 1: return "Prezime";
            case 2: return "Adresa";
            case 3: return "Broj telefona";
            case 4: return "Mesto";
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
