package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.DBUserMapper;
import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.DBUser;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private Logger log = Logger.getLogger(UserServiceImpl.class);
    
    @Resource
    private UserDao userDao;

    @Resource
    private DBUserMapper dbUserMapper;

    public User getUserById(Long userId) {
        return userDao.selectUserById(userId);
    }

    public void createUser(DBUser dbUser) {
        log.info(dbUser.toString());
        dbUserMapper.insert(dbUser);
    }

    public User getUserByPhoneOrEmail(String emailOrPhone, Short state) {
        return userDao.selectUserByPhoneOrEmail(emailOrPhone,state);
    }

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public DBUser getAllDBUser(Long id) {
        return dbUserMapper.selectByPrimaryKey(id);
    }
}
