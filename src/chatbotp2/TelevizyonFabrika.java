/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotp2;

import java.util.ArrayList;

/**
 *
 * @author rumeysa
 */
public abstract class TelevizyonFabrika {
     private  ArrayList<Televizyon> televizyonList = new ArrayList<Televizyon>();

   
   
   public TelevizyonFabrika()
   {
       this.createTv();
   }
   
   public abstract void createTv();

    public ArrayList<Televizyon> getTelevizyonList() {
        return televizyonList;
    }

    public void setTelevizyonList(ArrayList<Televizyon> televizyonList) {
        this.televizyonList = televizyonList;
    }
   
   
  
}
