package cc.concurrent.mango.support;

import cc.concurrent.mango.Alias;
import cc.concurrent.mango.DB;
import cc.concurrent.mango.ReturnGeneratedId;
import cc.concurrent.mango.SQL;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author ash
 */
@DB(table = "user")
public interface UserDao {

    @SQL("select id from user where id = :1")
    public Integer selectInteger(int id);

    @SQL("select id from user where id = :1")
    public int selectInt(int id);

    @SQL("select name from user where id = :1")
    public String selectString(int id);

    @SQL("select gender from user where id = :1")
    public Boolean selectBooleanObj(int id);

    @SQL("select gender from user where id = :1")
    public boolean selectBoolean(int id);

    @SQL("select money from user where id = :1")
    public Long selectLongObj(int id);

    @SQL("select money from user where id = :1")
    public long selectLong(int id);

    @SQL("select update_time from user where id = :1")
    public Date selectDate(int id);

    @SQL("select id, name, age, gender, money, update_time from user where id = :1")
    public User selectUser(int id);

    @SQL("select id, name, age, gender, money, update_time from user order by id")
    public List<User> selectUserList();

    @SQL("select id, name, age, gender, money, update_time from user order by id")
    public Set<User> selectUserSet();

    @SQL("select id, name, age, gender, money, update_time from user order by id")
    public User[] selectUserArray();

    @SQL("select id from user order by id")
    public Integer[] selectIntegerArray();

    @SQL("select id from user order by id")
    public int[] selectIntArray();

    @SQL("select id, name, age, gender, money, update_time from user where id in (:1)")
    public List<User> selectUserInList(List<Integer> ids);

    @SQL("select id, name, age, gender, money, update_time from user where id in (:1)")
    public List<User> selectUserInSet(Set<Integer> ids);

    @SQL("select id, name, age, gender, money, update_time from user where id in (:1)")
    public List<User> selectUserInIntegerArray(Integer[] ids);

    @SQL("select id, name, age, gender, money, update_time from user where id in (:1)")
    public List<User> selectUserInIntArray(int[] ids);

    @SQL("select id, name, age, gender, money, update_time from user where age=:1 order by id")
    public List<User> selectUserByAge(int age);

    @SQL("select max(id) from user")
    public int selectMaxInt();

/***********************************************************************/

    @ReturnGeneratedId
    @SQL("insert into user(name, age, gender, money, update_time) values(:1.name, :1.age, :1.gender, :1.money, :1.updateTime)")
    public int insertUser(User user);

    @SQL("update ${:table} set name=:u.name, age=:u.age, gender=:u.gender, money=:u.money, update_time=:u.updateTime where id=:u.id")
    public int updateUser(@Alias("u") User user);

    @SQL("delete from user where id=:1")
    public int deleteUser(int id);

    @SQL("delete from user where age=:1")
    public int deleteUserByAge(int age);

/***********************************************************************/

    @SQL("insert into user(name, age, gender, money, update_time) values(:1.name, :1.age, :1.gender, :1.money, :1.updateTime)")
    public int[] batchInsertUserList(List<User> userList);

    @SQL("insert into user(name, age, gender, money, update_time) values(:1.name, :1.age, :1.gender, :1.money, :1.updateTime)")
    public int[] batchInsertUserSet(Set<User> userSet);

    @SQL("insert into user(name, age, gender, money, update_time) values(:1.name, :1.age, :1.gender, :1.money, :1.updateTime)")
    public int[] batchInsertUserArray(User[] users);

}
