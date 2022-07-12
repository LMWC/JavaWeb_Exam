package user.service.impl;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import user.bean.Manager;
import user.dao.ManagerMapper;
import user.service.ManagerService;
import user.utils.SessionFactoryUtils;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/6/2 22:16
 * @description: 处理管理员模块业务的Service
 */
public class ManagerServiceImpl implements ManagerService {


    public Manager login(Manager loginmanager) {
        SqlSession session = SessionFactoryUtils.getSession();
        ManagerMapper managerMapper = session.getMapper(ManagerMapper.class);
        System.out.println(managerMapper+"---------------"+session);
        Manager manager = managerMapper.findUserByNameAndPassword(loginmanager);
        session.commit();
        session.close();
        return manager;
    }


}
