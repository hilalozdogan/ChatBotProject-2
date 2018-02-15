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
public class Asus extends BilgisayarFabrika {
    
    @Override
    public void createBilg()
    {
        getBilgisayarList().add((new N580VDDM160T(225,"Intel i7", "16GB", "1 TB", "15.6")));
    }
    
}

