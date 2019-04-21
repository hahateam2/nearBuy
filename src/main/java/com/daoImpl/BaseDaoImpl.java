package com.daoImpl;

import com.dao.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;

@SuppressWarnings("unchecked")
public  class BaseDaoImpl<T> extends SqlSessionDaoSupport {

    private String namespace;

    public static final String SQLID_INSERT = "insertSelective";
    public static final String SQLID_UPDATE = "updateByPrimaryKeySelective";
    public static final String SQLID_DELETE = "deleteByPrimaryKey";
    public static final String SQLID_SELECT_PK = "selectByPrimaryKey";

    @Resource(name = "sqlSessionTemplate")
    public void setSuperSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }


//    @Override
//    public T selectByPrimaryKey(String id) {
//        return getSqlSession().selectOne(namespace+"."+SQLID_SELECT_PK,id);
//    }
//
//    @Override
//    public int insertSelective(Object t) {
//        return getSqlSession().insert(namespace+"."+SQLID_INSERT,t);
//    }
//
//    @Override
//    public int deleteByPrimaryKey(String id) {
//        return getSqlSession().delete(namespace+"."+SQLID_DELETE,id);
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(Object t) {
//        return getSqlSession().update(namespace+"."+SQLID_UPDATE,t);
//    }


}
