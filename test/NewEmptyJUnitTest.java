/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import chatbotp2.OrtYöntemSecimi;
import chatbotp2.TweetSayGoreOrt;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author hilal
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
        @Test
        public void testKutupDeger(){
            OrtYöntemSecimi yöntem = new  OrtYöntemSecimi(new TweetSayGoreOrt());
            String çıktı= yöntem.strategy.BilgSırala();
            Assert.assertEquals("#Asus-N580VD-DM160T",çıktı);
        }
          @Test
        public void testKutupDeger2(){
            TweetSayGoreOrt test = new TweetSayGoreOrt();
            String çıktı= test.bilgTweetList.get(0).getHashtag();
            Assert.assertEquals("#Asus-N580VD-DM160T",çıktı);
        }
     @Test
      public void testKutupDeger3(){
            TweetSayGoreOrt test = new TweetSayGoreOrt();
            double çıktı= test.bilgTweetList.get(0).getKutupDegeri();
            Assert.assertEquals(0.882300000000001, çıktı);
        }
        
       
        
 
 
    }

