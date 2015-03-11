/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.util.Random;

/**
 *
 * @author Lovely
 */
public class cars {
private int quan;
    private String chat;

public cars(){
this.chat="co";
this.quan=1;
}
public cars(int q,String c){
this.quan=q;
this.chat=c;

}

public String sosanh(cars c1,cars c2){
    System.out.println(i2s(c1.quan));
     System.out.println(i2s(c2.quan));
if(c1.equals(c2)){
    return "bang";
    }
 else
 {
 if(i2s(c1.getQuan()).equalsIgnoreCase(i2s(c2.getQuan())))
 {
 return "giong";
 }
 else{
 return "khac";
 }

        }
    }
//public boolean chkint(int i,int j){
// if(i==j)return true;
// else return false;
//}
public String i2s(int i){
return i+"";
}
    @Override
public String toString(){
String sr ="";
if(this.quan==11){sr="J";}else{
    if(this.quan==12){sr="Q";}else{
        if(this.quan==13){sr="K";}else{
            if(this.quan==1){sr="A";}else{
                sr=this.quan+"";
            }
        }
    }
}
sr=sr+" "+ this.chat;
    return sr;
}

    /**
     * @return the quan
     */
    public int getQuan() {
        return quan;
    }

    /**
     * @param quan the quan to set
     */
    public void setQuan(int quan) {
        this.quan = quan;
    }

    /**
     * @return the chat
     */
    public String getChat() {
        return chat;
    }

    /**
     * @param chat the chat to set
     */
    public void setChat(String chat) {
        this.chat = chat;
    }


}

