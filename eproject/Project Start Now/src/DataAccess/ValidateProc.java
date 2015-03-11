/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Lovely
 */
public class ValidateProc {
 public static boolean validateEmail(String mail)
    {
        return mail.matches("[_.a-zA-Z0-9]*@[a-zA-Z0-9]*.[a-zA-Z]*");
    }
    public static boolean validatePhone(String phone)
    {
        return phone.matches("\\d+");
    }



private boolean checkDate(String d)
    {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            sdf.setLenient(false);
            Date date = new Date(sdf.parse(d).getTime());

           
            Date now=new Date(System.currentTimeMillis());
            if(date.compareTo(now)>0)
                return false;
            else
                return true;
        } catch (ParseException ex) {
            return false;
        }

    }

}
