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
public class Lenovo extends BilgisayarFabrika {
    
    
    @Override
    public void createBilg()
    {
        getBilgisayarList().add((new LegionY520(224,"Intel i5", "8GB", "1 TB", "15.6")));
    }
    
}
