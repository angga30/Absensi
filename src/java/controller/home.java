/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import org.hibernate.Query;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Button;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapping.Absensi;
import mapping.TableUser;
import org.hibernate.Criteria;
import controller.HibernateUtil;
import java.sql.Time;
import java.time.LocalDateTime;
import jxl.write.DateTime;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Image;
import org.zkoss.zul.ListModelList;
import util.inRender;
import util.renderAbsnList;
/**
 *
 * @author angga
 */
public class home extends GenericForwardComposer {
    private Textbox tNik,tNama;
    private Label jam,tgl;
    private Combobox cmbJenis;
    private Button btnSave;
    private List res;
    private Image img1;
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        
        
        
    }
    
    
    
    public boolean alreadyExists() throws ParseException {
        Date dat = new Date();
        SessionFactory Sf = HibernateUtil.getSessionFactory();
        Session ses = Sf.openSession();
        Query q = ses.createQuery("from Absensi where tgl = :t AND user_id = :u");
        q.setParameter("t",new Date());
        q.setParameter("u",tNik.getValue());
        //Time a = new Time(new Date().getTime());
        //q.setParameter("ji",new Date());
        Boolean aE = q.uniqueResult()  != null;
        //Sf.close();
        
        
        return aE;
        
        
    }
    
    public void onClick$btnSave() throws ParseException{
        if(!(tNik.getValue().equals("")||cmbJenis.getSelectedIndex() == -1)){
            if(cmbJenis.getSelectedIndex() == 0){
                this.addAbsen();
            }else if(cmbJenis.getSelectedIndex() == 1){
                alert("kodok");
            }
                
            
        }else{
            alert("Data Harus di Isi!!");
        }
        
        
    }
        
   
    public void onOK$tNik(){
        SessionFactory Sf = HibernateUtil.getSessionFactory();
        Session ses = Sf.openSession();
        //Transaction tr = ses.beginTransaction();
        Query q = ses.createQuery("FROM TableUser WHERE userId = :u");
        q.setParameter("u", Integer.parseInt(tNik.getText()));
        res = q.list();
        if(!res.isEmpty()){
        Iterator it = res.iterator();
        while(it.hasNext()){
            TableUser ts = (TableUser)it.next();
            tNama.setText(String.valueOf(ts.getUserName()));
        }
        }else{
            alert("NIK Tersebut Tidak Ditemukan");
        }
    }
    public void addAbsen() throws ParseException{
        if(this.alreadyExists()){
        alert("ada");
    }else{
        Absensi a = new Absensi();
        TableUser b = new TableUser();
        SessionFactory Sf = HibernateUtil.getSessionFactory();
        Session ses = Sf.openSession();
        ses.beginTransaction();
        b.setUserId(Integer.parseInt(tNik.getValue()));
        //alert(String.valueOf(LocalDateTime.now()));
        Date d = new Date();
        a.setTgl(d);
        a.setJamIn(new Time(new Date().getTime()));
        a.setTableUser(b);
    
        ses.save(a);
        ses.getTransaction().commit();
        alert("sukses");
        ses.close();
        }
        
    }
        
       
            
        
    

}