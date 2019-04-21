package com.serviceImpl;

import com.dao.BaseDao;
import com.dao.PraiseMapper;
import com.model.Praise;
import com.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PraiseServiceImpl  extends BaseServiceImpl<Praise> implements PraiseService {

    @Autowired
    private PraiseMapper praiseMapper;
    private BaseDao<Praise> baseDao;

    @Override
    public void setBaseDao(Object object) {
        this.praiseMapper=(PraiseMapper)object;
        super.setBaseDao(this.praiseMapper);
    }
}
