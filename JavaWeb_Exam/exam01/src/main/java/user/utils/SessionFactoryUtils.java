package user.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 会话工厂工具类 */
public class SessionFactoryUtils {
    private static SqlSessionFactory factory;

    static {
        //实例化工厂建造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //读取核心配置文件
        try (InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml")) {
            //创建工厂对象
            factory = builder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     得到会话对象
     @return 会话对象
     */
    public static SqlSession getSession() {
        return factory.openSession();
    }

    /**
     得到工厂对象
     @return 会话工厂对象
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }
}