package csc.lzp.xmlspring.service.Impl;

import csc.lzp.xmlspring.dao.UserDao;
import csc.lzp.xmlspring.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/5/25
 **/
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {

    }
}
