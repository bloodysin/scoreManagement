package com.bloodysin.scoremanagement.impl;

import com.bloodysin.scoremanagement.model.TestTable; 
import com.bloodysin.scoremanagement.dao.ITestTableDAO; 
import com.bloodysin.scoremanagement.util.BasicSqlSupport;

public class ITestTableDAOImpl extends BasicSqlSupport implements ITestTableDAO { 
    @Override 
    public boolean add(TestTable test) throws Exception { 
        boolean flag=false; 
        int count=this.session.insert("com.bloodysin.scoremanagement.mapper.TestMapper.add",test);
        if(count>0){ 
            flag=true; 
        } 
        return flag; 
    } 
}