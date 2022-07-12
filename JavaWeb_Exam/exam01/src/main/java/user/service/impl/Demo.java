package user.service.impl;

import org.apache.ibatis.session.SqlSession;
import user.bean.Manager;
import user.dao.ManagerMapper;
import user.utils.SessionFactoryUtils;

public class Demo {
    public static void main(String[] args) {
//        Manager m = new Manager();
//        m.setPassword("123");
//        m.setUsername("zs");
//
//        Manager manager = new ManagerServiceImpl().login(m);
//        System.out.println(manager);

        SqlSession session = SessionFactoryUtils.getSession();
        ManagerMapper managerMapper = session.getMapper(ManagerMapper.class);
        System.out.println(managerMapper+"---------------"+session);
        Manager zs = managerMapper.findUserByNameAndPassword1("zs");
        System.out.println(zs);
    }
}
