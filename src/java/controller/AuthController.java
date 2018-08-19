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
import java.util.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Initiator;
 
/**
 *
 * @author imam-pc
 */
public class AuthController implements Initiator {
 
    @Override
    public void doInit(Page page, Map<String, Object> args) throws Exception {
        String name = (String) args.get("name");
        String cre = (String) Sessions.getCurrent().getAttribute("userCredential");
        if (cre == null) {
            if (!name.equals("login")) {
                Executions.sendRedirect("/login/index" + ".zul");
            }
        } else {
            if (!name.equals("index")) {
                Executions.sendRedirect("/admin/index" + ".zul");
            
        }
    }
            }
}
