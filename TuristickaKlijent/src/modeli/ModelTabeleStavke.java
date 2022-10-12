/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Aranzman;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class ModelTabeleStavke extends AbstractTableModel{
    
    List<OpstiDomenskiObjekat> lista;

    public ModelTabeleStavke() {
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
        StavkaRacuna sr = (StavkaRacuna) lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return sr.getAranzman();
            case 1: return sr.getPopust();
            case 2: return sr.getIznos();
            case 3: return sr.izracuanIznosSaPopustom();
            
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Aranzman";
            case 1: return "Popust";
            case 2: return "Iznos";
            case 3: return "Iznos sa popustom";
            default: return "";
        }
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    public void dodaj(StavkaRacuna sr){
        lista.add(sr);
        fireTableDataChanged();
    }
    
    
    public void obrisi(int red){
        lista.remove(red);
        fireTableDataChanged();
    }
    
    
    
    
    
}
