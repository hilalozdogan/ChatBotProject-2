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
public class AppleC extends CellPhoneFabrika{

   @Override
    public void createTel()
    {
        getCellPhoneList().add(new Iphone7(124,64,"2GB"));
    }    
}
