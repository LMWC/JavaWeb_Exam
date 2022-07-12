package user.dao;


import org.apache.ibatis.annotations.Select;
import user.bean.Manager;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/6/2 22:18
 * @description:
 */
public interface ManagerMapper {
    Manager findUserByNameAndPassword(Manager manager);
   // @Select("SELECT * FROM tb_manager WHERE username = #{username}")
    Manager findUserByNameAndPassword1(String username);
}
