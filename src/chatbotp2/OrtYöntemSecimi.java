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
public class OrtYöntemSecimi {
    
    public Strategy strategy;
     
   
     
     public OrtYöntemSecimi(Strategy strategy)
     {
         this.strategy = strategy;
     }
    

     public void Tweetİşlemleri(){
        strategy.TweetDegerHesapla();
    
    }
     public void TelSırala()
     {
         strategy.TelSırala();
     }
     public void TvSırala()
     {
         strategy.TvSırala();
     }
     public void BilgSırala()
     {
         strategy.BilgSırala();
      
     }
}
