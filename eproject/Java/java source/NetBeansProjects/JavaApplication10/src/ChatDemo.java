import java.io.IOException;

import java.util.Vector;

import ymsg.network.AccountLockedException;

import ymsg.network.LoginRefusedException;

import ymsg.network.Session;

import ymsg.network.YahooGroup;

import ymsg.network.YahooUser;

import ymsg.network.event.SessionAdapter;

import ymsg.network.event.SessionChatEvent;

import ymsg.network.event.SessionEvent;

import ymsg.network.event.SessionListener;

public class ChatDemo{

public Session ses;



public ChatDemo() {

  ses = new Session();

  ses.addSessionListener(new CustomSessionListener());

}



public static void main(String[] args) throws InterruptedException {

  ChatDemo chat = new ChatDemo();

  try {

   chat.login("username","passs");

   chat.ses.sendMessage("myNickName", "Hi You!");

   //lay danh sach cac friend group;

   YahooGroup[] groups = chat.ses.getGroups();

   for(int i=0 ; i< groups.length ; i++) {

   //lay danh sach cac friend trong group

    Vector f = groups<img src="http://hp-aptech.edu.vn/emoticons/emotion-55.gif" alt="Idea" />.getMembers();

    System.out.println(groups<img src=""http://hp-aptech.edu.vn/emoticons/emotion-55.gif" alt="Idea" />.getName());

   }

  } catch (Exception e) {

   e.printStackTrace();

  }

  //pause

  Thread.currentThread().sleep(5000000);

}

private void login(String user, String pass) throws AccountLockedException, IllegalStateException, LoginRefusedException, IOException {

  ses.login(user, pass);

}

}

class CustomSessionListener extends SessionAdapter{

@Override

public void messageReceived(SessionEvent arg0) {

  System.out.println("*****"+arg0.getFrom() + ": "+arg0.getMessage());

}



@Override

public void chatMessageReceived(SessionChatEvent arg0) {

  System.out.println("+++++"+arg0.getFrom() + ": "+arg0.getMessage());

}

}