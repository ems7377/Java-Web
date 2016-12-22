package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.CompanyDao;
import com.hibernate.HibernateSessionFactory;
import com.model.*;

/**
 * class CompanyDaoImp extends CompanyDao
 * @author 
 */

public class CompanyDaoImp extends CompanyDao {

	Session session=HibernateSessionFactory.getSession();
	Transaction tr=session.beginTransaction();
	

    public List<Company> queryAllCompany() {
		//��ѯȫ����˾����Ϣ
    List<Company> list =  session.createQuery("from Company").list();
    session.flush();
	tr.commit();//�ύ����
	return list;
	}
    
    public void deleteCompany(int id) {
    	Company company = (Company) session.load(Company.class, id);
    	session.delete(company);//ɾ������
    	session.flush();
    	tr.commit();//�ύ����

 	}
    
    public boolean insertCompanyJob(Company company) {
	
    	// TODO Auto-generated method stub
		session.save(company);
		tr.commit();
		return true;
	}   

}
	
	

