/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotp2;

/**
 *
 * @author rumeysa
 */
public class Philips extends TelevizyonFabrika{
     
    public void createTv()
    {
        getTelevizyonList().add((new P24PFS4022(323,"81 cm", "LED", "FULL HD")));
    }



   
 
}
