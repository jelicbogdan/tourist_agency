/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class CitacPropertiFajla {

    private static CitacPropertiFajla instance;
    Properties prop;
    
    private CitacPropertiFajla() {
        try {
            prop = new Properties();
            InputStream inputStream = new FileInputStream("baza.properties");
            prop.load(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(CitacPropertiFajla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static CitacPropertiFajla getInstance() {
        if(instance == null)
            instance = new CitacPropertiFajla();
        return instance;
    }
    
    public String vratiVrednost(String kljuc){
        return prop.getProperty(kljuc);
    }
}
