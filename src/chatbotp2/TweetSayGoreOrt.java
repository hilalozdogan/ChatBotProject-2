/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbotp2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hilal
 */
public class TweetSayGoreOrt implements Strategy{
   
   public  ArrayList<String> tweetYorum = new ArrayList<String>();
   public  ArrayList<Tweet> cepTweetList = new ArrayList<Tweet>();
   public  ArrayList<Tweet> bilgTweetList = new ArrayList<Tweet>();
   public ArrayList<Tweet> tvTweetList = new ArrayList<Tweet>();


  
   @Override
    public double TweetDegerHesapla() {
           
          
            Scanner scanner2 = null;
            String kategori;
            String hashtag;
            double polarity = 0;
            double topPol = 0;
            double ortPol = 0;

            try {
                scanner2 = new Scanner(new FileReader("tweetBilgileri.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BotHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (scanner2.hasNext()) {
                String[] linePiece = scanner2.nextLine().split("_"); //breaks lines in file by '_'.
                kategori = linePiece[0];
                hashtag = linePiece[1];
                for (int i = 2; i < linePiece.length; i++) { 
                    tweetYorum.add(linePiece[i]);
                    String[] tweetWord = linePiece[i].split(" "); //breaks linePieces in tweetYorum by " ".

                    for (int j = 0; j < tweetWord.length; j++) {
                        if (Singleton.instance().getMap().containsKey(tweetWord[j].toLowerCase())) { // Are the words on the tweet in the hashmap
                            polarity = Singleton.instance().getMap().get(tweetWord[j].toLowerCase()); 
                            topPol += polarity;
                        }

                    }

                }

                ortPol = topPol / (linePiece.length - 2); //topPolarity is divided by the number of tweets in the file.
                Tweet yeniTweet = new Tweet(hashtag, tweetYorum, ortPol);

                switch (kategori) {
                    case "Cep Telefonu":
                        cepTweetList.add(yeniTweet);
                        break;
                    case "Bilgisayar":
                        bilgTweetList.add(yeniTweet);
                        break;
                    case "Televizyon":
                        tvTweetList.add(yeniTweet);
                        break;
                    default:
                        break;
                }

                tweetYorum.clear();
                polarity = 0;
                topPol = 0;
                ortPol = 0;

            }
            return ortPol;
     
        }
    
    public String TelSırala() { //Use collections.sort then reverse to find most popular product
         
        System.out.println("TweetSayGoreOrt Yöntemine Göre Sezgi Değerleri Ortalaması");
        System.out.println("----------------------------------------------------------\n");
   
        System.out.println("Cep Telefonları"); 
        Collections.sort(cepTweetList);
        Collections.reverse(cepTweetList);
        for (Tweet tweet3 : cepTweetList) {
             System.out.println(tweet3.hashtag);
             System.out.println(tweet3.kutupDegeri);
        }
        
        System.out.println("En çok begenilen :"+cepTweetList.get(0).getHashtag());
        System.out.println("------------------------------");
        return cepTweetList.get(0).getHashtag();
        }
    public String TvSırala()
    {
       
         System.out.println("Televizyonlar");
                     Collections.sort(tvTweetList);
                     Collections.reverse(tvTweetList);
         for (Tweet tweet2 : tvTweetList) {
                    System.out.println(tweet2.hashtag);
                    System.out.println(tweet2.kutupDegeri);
         }
        System.out.println("En çok begenilen :"+tvTweetList.get(0).getHashtag());
        System.out.println("------------------------------");    
       
        return tvTweetList.get(0).getHashtag();
        
       
}
    public String BilgSırala()
    {
        System.out.println("Bilgisayarlar"); 
        Collections.sort(bilgTweetList);
        Collections.reverse(bilgTweetList);
         
         for (Tweet tweet : bilgTweetList) {
                    System.out.println(tweet.hashtag);
                    System.out.println(tweet.kutupDegeri);
         }
         System.out.println("En çok begenilen :"+bilgTweetList.get(0).getHashtag());
         System.out.println("\n");
         return bilgTweetList.get(0).getHashtag();
         
    }
    
    }
    


    
    

