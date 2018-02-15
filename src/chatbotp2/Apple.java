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
public class Apple extends BilgisayarFabrika  {
    
    @Override
    public void createBilg()
    {
        getBilgisayarList().add((new MacbookAir(223,"Intel i5","16GB","750GB","13.3")));
    }
}