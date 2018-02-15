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
public class SamsungC extends CellPhoneFabrika{
     @Override
    public void createTel()
    {
        getCellPhoneList().add(new GalaxyNote8(125, 13, "4GB"));
    }
}
