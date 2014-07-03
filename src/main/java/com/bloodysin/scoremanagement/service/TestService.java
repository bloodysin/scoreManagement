package com.bloodysin.scoremanagement.service;

import java.util.Date;
//import javax.annotation.Resource;
//import org.springframework.transaction.annotation.Transactional;

import com.bloodysin.scoremanagement.model.TestTable; 
import com.bloodysin.scoremanagement.dao.ITestTableDAO;

public class TestService { 
    private ITestTableDAO testDAO=null; 
    public ITestTableDAO getTestDAO() { 
        return testDAO; 
    } 
    public void setTestDAO(ITestTableDAO testDAO) { 
        this.testDAO = testDAO; 
    } 
    public void add() throws Exception{ 
        TestTable test=new TestTable(); 
        test.setName("yuanmomo6"); 
        test.setBirthday(new Date()); 
        try { 
            testDAO.add(test); 
        } catch (Exception e) { 
            // TODO Auto-generated catch block 
            throw e; 
        } 
    } 
}