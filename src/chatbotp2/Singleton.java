/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hilal
 */
public class Singleton {
    String senticWord;
    String durum;
    Double kutupDeg;
    HashMap<String, Double> map = new HashMap<String, Double>();

 
    private static Singleton instance=null;
    
    private static Object lock=new Object();
    
    private Singleton() 
    {
    
        try {
            String karakter = "\t";

            File file = new File("SenticNet.txt");
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(file));
            String satir = null;
            try {
                satir = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            while (satir != null) {

                StringTokenizer st = new StringTokenizer(satir, karakter);
                while (st.hasMoreTokens()) {
                    senticWord = st.nextToken().toLowerCase();
                    durum = st.nextToken();
                    kutupDeg = Double.parseDouble(st.nextToken());
                    map.put(senticWord, kutupDeg);
                }
                try {
                    satir = reader.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static Singleton instance() 
    {
        if(instance==null)
        {
            synchronized (lock)
            {
                
                if(instance==null)
                {   
                    instance=new Singleton();
                }          
        }
    }
        return instance;

    }
    
   public HashMap<String, Double> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Double> map) {
        this.map = map;
    }
    

   
    
    
    
}
