package chatbotp2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

//Bothandler class for ChatBot
public class BotHandler extends JFrame implements KeyListener {

    /*instance variables*/
    
    String marka, model, begenilenUrun;

    /*create arrayList*/
    

    BilgisayarFabrika apple=new Apple();
    BilgisayarFabrika lenovo=new Lenovo();
    BilgisayarFabrika asus=new Asus();
    CellPhoneFabrika asusC=new AsusC();
    CellPhoneFabrika appleC=new AppleC();
    CellPhoneFabrika samsungC=new SamsungC();
    TelevizyonFabrika philips=new Philips();
    TelevizyonFabrika samsungT=new SamsungT();
    TelevizyonFabrika lg=new LG();
    
 

    


    /*create arrayList to store messages*/
    
    ArrayList<String> exceptionMessageList = new ArrayList<String>(
            Arrays.asList("maalesef anlasilmadi...", "lutfen tekrarlar misin", "???"));
    ArrayList<String> greetingMessageList = new ArrayList<String>(
            Arrays.asList("ooo selammm..", "merhabalar", "mrb"));
    ArrayList<String> state = new ArrayList<String>(
            Arrays.asList("Teşekkürle iyiyim,Siz?", "Sağolun,siz nasılsınız?"));
    ArrayList<String> farewell = new ArrayList<String>(
            Arrays.asList("Hoşçakalın...", "Güle güle...", "Görüşmek üzere..."));
    
   //create panel, text areas
    
    JPanel p = new JPanel();
    JTextArea txtChat = new JTextArea(20, 50);
    JTextArea txtEnter = new JTextArea(1, 51);
    JScrollPane scroll = new JScrollPane(
            txtChat,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
    );

    public BotHandler() {

        super("Chat Bot");
        
        //create some cellphone, computer and television
        
  
        //settings for gui
        
        setSize(600, 425);
        setResizable(false);
        txtChat.setEditable(false);
        txtEnter.addKeyListener(this);

        p.add(scroll);
        p.add(txtEnter);
        add(p);

        setVisible(true);
 

    }
   
    
   /* Handle the key-pressed event from the text field. */
    
   public void keyPressed(KeyEvent e) {


        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEnter.setEditable(false);
            
            String uText = txtEnter.getText();
            txtChat.append("You: " + uText + "\n");
            txtEnter.setText("");
            uText.trim();
            
            //chatting with user
            
            if (uText.contains("selam")) {

                decideRandom(greetingMessageList);

            } else if (uText.contains("nasilsiniz?")) {

                decideRandom(state);
            } else if (uText.contains("gule gule")) {

                decideRandom(farewell);
            } else if (uText.contains("urun sececegim")) {
               // select product
                txtChat.append("AI: " + "Lutfen urunu seciniz:" + "\n");
                txtChat.append("AI: " + "1: Cep Telefonu" + "\n");
                txtChat.append("AI: " + "2: Televizyon" + "\n");
                txtChat.append("AI: " + "3: Bilgisayar" + "\n");
                  //if the user chose 1 then show cellphone list with popular cellphone
            } else if (uText.equals("1")) {
                txtChat.append("AI: " + "Cep Telefonu secildi..." + "\n");
                txtChat.append("AI: " + "Listedeki Telefonlar:" + "\n");
   
                 for(CellPhone cellP:asusC.getCellPhoneList())
                {
                 txtChat.append("AI: " + cellP.getpBrand() + " - " + cellP.getpModel() + "\n");
                }
                   for(CellPhone cellP:appleC.getCellPhoneList())
                {
                 txtChat.append("AI: " + cellP.getpBrand() + " - " + cellP.getpModel() + "\n");
                }
                     for(CellPhone cellP:samsungC.getCellPhoneList())
                {
                 txtChat.append("AI: " + cellP.getpBrand() + " - " + cellP.getpModel() + "\n");
                }
              // txtChat.append("AI:En çok beğenilen ürün:""\n");
           
              //if the user chose 2 then show televison list with popular television
            } else if (uText.equals("2")) {
                txtChat.append("AI: " + "Televizyon secildi..." + "\n");
                txtChat.append("AI: " + "Listedeki Televizyonlar:" + "\n");
                 for(Televizyon tv:samsungT.getTelevizyonList())
                {
                 txtChat.append("AI: " + tv.getpBrand() + " - " + tv.getpModel() + "\n");
                }
                  for(Televizyon tv:philips.getTelevizyonList())
                {
                 txtChat.append("AI: " + tv.getpBrand() + " - " + tv.getpModel() + "\n");
                }
                   for(Televizyon tv:lg.getTelevizyonList())
                {
                 txtChat.append("AI: " + tv.getpBrand() + " - " + tv.getpModel() + "\n");
                }
              // txtChat.append("AI:En çok beğenilen ürün: " + tvTweetList.get(0).hashtag + "\n");
               //if the user chose 3 then show televison list with popular computer
            } else if (uText.equals("3")) {
                 
                txtChat.append("AI: " + "Bilgisayar secildi..." + "\n");
                txtChat.append("AI: " + "Listedeki Bilgisayarlar:" + "\n");
                for(Bilgisayar bilg:apple.getBilgisayarList())
               {
                txtChat.append("AI: "+bilg.getpBrand()+"-"+bilg.getpModel()+"\n");
                }
                 for(Bilgisayar bilg:lenovo.getBilgisayarList())
               {
                txtChat.append("AI: "+bilg.getpBrand()+"-"+bilg.getpModel()+"\n");
                }
                  for(Bilgisayar bilg:asus.getBilgisayarList())
               {
                txtChat.append("AI: "+bilg.getpBrand()+"-"+bilg.getpModel()+"\n");
                }
               //txtChat.append("AI:En çok beğenilen ürün: " + tOrt.BilgSırala() + "\n");

            } else {
                decideRandom(exceptionMessageList);  //call decideRandom() method
            }

            uText.trim();  //use trim() to remove leading and trailing spaces

        }

    }
    /* Handle the key-released event from the text field. 
   *It works when we remove hand from the key
   */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEnter.setEditable(true);
        }
    }
    /*Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
    }
    //generate addText() method
    public void addText(String str) {
        txtChat.setText(txtChat.getText() + str);
    }
    //show messages randomly
    private void decideRandom(ArrayList<String> messageList) {
        int decider = (int) (Math.random() * messageList.size());
        txtChat.append("AI: " + messageList.get(decider) + "\n");
    }
    //generate UrunOku() method to read products from file
   
   
}
