/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author nhahv
 */
public class Session {
    private static String Password;     // Dùng để change Pass.
    private static int LoginID;         // ID của người đăng nhập, vì admin và emp có thể trùng ID, nên khi check, nhớ check thêm cả điều kiện isPermission (true => admin, false => emp)
    private static boolean Session;     // The hien da Login hay Logout/
    private static boolean Permission;  // Permissoin true = admin, false = employee.
    
    
    
    public Session(){
        Password = "";
        LoginID = 1;
        Session = false;
        Permission = false;
    }

  
    /**
     * @return the Password
     */
    public static String getPassword() {
        return Password;
    }

    /**
     * @param aPassword the Password to set
     */
    public static void setPassword(String aPassword) {
        Password = aPassword;
    }

    /**
     * @return the LoginID
     */
    public static int getLoginID() {
        return LoginID;
    }

    /**
     * @param aLoginID the LoginID to set
     */
    public static void setLoginID(int aLoginID) {
        LoginID = aLoginID;
    }

    /**
     * @return the Permission
     */
    public static boolean isPermission() {
        return Permission;
    }

    /**
     * @param aPermission the Permission to set
     */
    public static void setPermission(boolean aPermission) {
        Permission = aPermission;
    }

    /**
     * @return the Session
     */
    public static boolean isSession() {
        return Session;
    }

    /**
     * @param aSession the Session to set
     */
    public static void setSession(boolean aSession) {
        Session = aSession;
    }


}
