/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Listbox;
import controller.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mapping.Absensi;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import mapping.TableUser;
import util.inRender;
import org.zkoss.zul.ListModelList;
import util.renderAbsnList;

/**
 *
 * @author angga
 */
public class admin extends GenericForwardComposer {
    private Textbox tNama,tId;
    private Listbox lb,lst;
    private List<TableUser> tbl =  new ArrayList<TableUser>();
    private List<Absensi> abs = new ArrayList<Absensi>();
    public void load(){
        
        SessionFactory Sf = HibernateUtil.getSessionFactory();
        Session ses = Sf.openSession();
        Transaction tr = ses.beginTransaction();
        Query q1;
        //q1 = ses.createQuery("FROM tableUser");
        Query q2 = ses.createQuery("FROM TableUser");
        List Res = q2.list();
        Iterator it = Res.iterator();
        while(it.hasNext()){
            int i=0;
            TableUser ts = (TableUser)it.next();
            int maxid = ts.getUserId() + 1;
            tId.setValue(String.valueOf(maxid));
            
            }
        
        //Sf.close();
        
        
        
        
    }
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        load();
        loadData();
    }
    public void onClick$btnSave() throws Exception{
        if (!tNama.getValue().trim().equals("") && !tId.getValue().trim().equals("")) {
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();

            //Integer id = ((BigInteger) sess.createSQLQuery("").uniqueResult()).intValue();

            TableUser data = new TableUser();
            
            data.setUserId(Integer.parseInt(tId.getValue()));
            data.setUserName(tNama.getValue());

            sess.save(data);
            sess.getTransaction().commit();
            sess.close();
            load();
            loadData();
            //clearField();
            alert("Added");
            
        } else {
            alert("Nama dan Nim Tidak Boleh Kosong");
        }
        
    }
    public void loadData(){
        SessionFactory Sf = HibernateUtil.getSessionFactory();
        Session ses = Sf.openSession();
        Transaction tr = ses.beginTransaction();
        Query q1;
        //q1 = ses.createQuery("FROM tableUser");
        Query q2 = ses.createQuery(" FROM TableUser");
        tbl = q2.list();
        ses.close();
        lb.setModel(new ListModelList(tbl));
        lb.setItemRenderer(new inRender());
    }
    public void onClick$btnDel(){
        if(lb.getSelectedIndex() != -1){
            Session sess = HibernateUtil.getSessionFactory().openSession();
            sess.beginTransaction();

            TableUser obj = (TableUser) sess.get(TableUser.class, tbl.get(lb.getSelectedIndex()).getUserId());
            sess.delete(obj);
            sess.getTransaction().commit();
            sess.close();
            loadData();
            alert("Deleted");
        } else {
            alert("Harus Pilih Salah Satu Data");
        }
    }
    public void onChanging$tNik(){
        alert("as");
    }
    public void onClick$B(){
            SessionFactory Sf = HibernateUtil.getSessionFactory();
        Session ses = Sf.openSession();
        //Transaction tr = ses.beginTransaction();
        Query q1;
        //q1 = ses.createQuery("FROM tableUser");
        Query q = ses.createQuery("FROM Absensi");
        abs = q.list();
        //ses.close();
        lst.setModel(new ListModelList(abs));
        lst.setItemRenderer(new renderAbsnList());
        }

    
}
