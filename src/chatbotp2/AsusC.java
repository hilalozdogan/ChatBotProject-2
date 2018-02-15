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
public class AsusC extends CellPhoneFabrika {
    
    @Override
    public void createTel()
    {
        getCellPhoneList().add(new Zenphone3(123,16,"3GB"));
    }
    
}
