/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author angga
 */
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
 
/**
 *
 * @author imam-pc
 */
public class loginController extends GenericForwardComposer {
 
    private Textbox username, password;
    private Label message;
 
    public void onClick$login() {
        if (!username.getValue().trim().equals("") && !password.getValue().trim().equals("")
                && username.getValue().equals("admin") && password.getValue().equals("admin")) {
            //set session to browser
            Session sess = Sessions.getCurrent();
            sess.setAttribute("userCredential", "user");
 
            Executions.sendRedirect("/admin/index.zul");
        } else {
            message.setValue("Login Incorrect");
        }
    }
 
    public void onOK$username() {
        onClick$login();
    }
 
    public void onOK$password() {
        onClick$login();
    }
 
}