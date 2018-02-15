/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotp2;

/**
 *
 * @author hilal
 */
public class SamsungT extends TelevizyonFabrika{
    
    public void createTv()
    {
        getTelevizyonList().add((new T24D310ES(323,"72 cm", "LED", "HD")));
    }
}
