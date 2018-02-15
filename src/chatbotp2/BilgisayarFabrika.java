/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotp2;

import java.util.ArrayList;

/**
 *
 * @author hilal
 */
public abstract class BilgisayarFabrika {
    
   private  ArrayList<Bilgisayar> bilgisayarList = new ArrayList<Bilgisayar>();

   
   
   public BilgisayarFabrika()
   {
       this.createBilg();
   }
   
   public abstract void createBilg();
   
   public ArrayList<Bilgisayar> getBilgisayarList() {
        return bilgisayarList;
    }

    public void setBilgisayarList(ArrayList<Bilgisayar> bilgisayarList) {
        this.bilgisayarList = bilgisayarList;
    }
     
    
}
