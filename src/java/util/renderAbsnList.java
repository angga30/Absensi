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
import mapping.Absensi;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

public class renderAbsnList implements ListitemRenderer {

    public void render(Listitem lstm, Object t, final int i) throws Exception {
        final Absensi data = (Absensi) t;
        
        Listcell cell = new Listcell(String.valueOf(data.getAbsId()));
        cell.setParent(lstm);
        cell = new Listcell(String.valueOf(data.getTgl()));
        cell.setParent(lstm);
        cell = new Listcell(String.valueOf(data.getTableUser().getUserName()));
        cell.setParent(lstm);
        cell = new Listcell(String.valueOf(data.getJamIn()));
        cell.setParent(lstm);
        cell = new Listcell(String.valueOf(data.getJamOut()));
        cell.setParent(lstm);
        cell = new Listcell(String.valueOf(data.getLemburIn()));
        cell.setParent(lstm);
        cell = new Listcell(String.valueOf(data.getLemburOut()));
        cell.setParent(lstm);

    }
}
