/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author angga
 */
import mapping.TableUser;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

public class inRender implements ListitemRenderer {

    public void render(Listitem lstm, Object t, final int i) throws Exception {
        final TableUser data = (TableUser) t;
        
        Listcell cell = new Listcell(String.valueOf(data.getUserId()));
        cell.setParent(lstm);
        cell = new Listcell(String.valueOf(data.getUserName()));
        cell.setParent(lstm);

    }
}
