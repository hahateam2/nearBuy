package com.serviceImpl;

import com.dao.BaseDao;
import com.dao.CollectionMapper;
import com.model.Collection;
import com.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollectionServiceImpl extends BaseServiceImpl<Collection> implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    private BaseDao<Collection> baseDao;

    @Override
    public void setBaseDao(Object object) {
        this.collectionMapper=(CollectionMapper)object;
        super.setBaseDao(this.collectionMapper);
    }
}
