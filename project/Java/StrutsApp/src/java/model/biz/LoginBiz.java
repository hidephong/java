/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.biz;

import model.entity.User;

/**
 *
 * @author haohao
 */
public class LoginBiz {

    public boolean checkLogin(User u) {
        if (u.getUsername().equals("admin") && u.getPassword().equals("123")) {
            return true;
        }
        return false;
    }
}
