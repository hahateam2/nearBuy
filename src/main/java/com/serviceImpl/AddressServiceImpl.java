package com.serviceImpl;

import com.dao.AddressMapper;
import com.dao.BaseDao;
import com.model.Address;
import com.model.User;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl extends BaseServiceImpl<Address> implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    private BaseDao<User> baseDao;

    @Override
    public void setBaseDao(Object object) {
        this.addressMapper=(AddressMapper)object;
        super.setBaseDao(this.addressMapper);
    }
}
