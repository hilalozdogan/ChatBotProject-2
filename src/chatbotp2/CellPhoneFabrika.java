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
public abstract class CellPhoneFabrika {
    
   private  ArrayList<CellPhone> cellPhoneList = new ArrayList<CellPhone>();

    
   public CellPhoneFabrika()
   {
       this.createTel();
   }
   
   public abstract void createTel();
   
   public ArrayList<CellPhone> getCellPhoneList() {
        return cellPhoneList;
    }

    public void setCellPhoneList(ArrayList<CellPhone> CellPhoneList) {
        this.cellPhoneList = CellPhoneList;
    }

   
 
     
    
}
