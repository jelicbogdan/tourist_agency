/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forme.GlavnaServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class PokretanjeServera extends Thread{
    GlavnaServerskaForma sf;

    public PokretanjeServera(GlavnaServerskaForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut");
            sf.pokrenutServer();
            while (true) {    
                Socket soket = ss.accept();
                System.out.println("Klijent se povezao");
                NitKlijent nk = new NitKlijent(soket);
                nk.start();   
            }
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
            sf.nijePokrenutServer();
        }
    }
    
    
            
            
}
