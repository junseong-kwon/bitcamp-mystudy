package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.UserDao;
import bitcamp.myapp.vo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

  private Connection con;

  public UserDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public boolean insert(User user) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into myapp_users(name, email, pwd, tel)"
            + " values (?, ?, sha1(?), ? )")) {

      stmt.setString(1, user.getName());
      stmt.setString(2, user.getEmail());
      stmt.setString(3, user.getPassword());
      stmt.setString(4, user.getTel());
      stmt.executeUpdate();
      return true;
    }
  }

  @Override
  public List<User> list() throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from myapp_users order by user_id asc");

        ResultSet rs = stmt.executeQuery()) {

      ArrayList<User> list = new ArrayList<>();

      while (rs.next()) { // select 실행 결과에서 1 개의 레코드를 가져온다.
        User user = new User();
        user.setNo(rs.getInt("user_id")); // 서버에서 가져온 레코드에서 user_id 컬럼 값을 꺼내 User 객체에 담는다.
        user.setName(rs.getString("name")); // 서버에서 가져온 레코드에서 name 컬럼 값을 꺼내 User 객체에 담는다.
        user.setEmail(rs.getString("email")); // 서버에서 가져온 레코드에서 email 컬럼 값을 꺼내 User 객체에 담는다.

        list.add(user);
      }

      return list;
    }
  }

  @Override
  public User findBy(int no) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from myapp_users where user_id=?")) {
      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) { // select 실행 결과에서 1 개의 레코드를 가져온다.
          User user = new User();
          user.setNo(rs.getInt("user_id")); // 서버에서 가져온 레코드에서 user_id 컬럼 값을 꺼내 User 객체에 담는다.
          user.setName(rs.getString("name")); // 서버에서 가져온 레코드에서 name 컬럼 값을 꺼내 User 객체에 담는다.
          user.setEmail(rs.getString("email")); // 서버에서 가져온 레코드에서 email 컬럼 값을 꺼내 User 객체에 담는다.
          user.setTel(rs.getString("tel")); // 서버에서 가져온 레코드에서 tel 컬럼 값을 꺼내 User 객체에 담는다.
          return user;
        }
        return null;
      }
    }
  }

  @Override
  public User findByEmailAndPassword(String email, String password) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select * from myapp_users where email=? and pwd=sha1(?)")) {
      stmt.setString(1, email);
      stmt.setString(2, password);

      try (ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
          User user = new User();
          user.setNo(rs.getInt("user_id"));
          user.setName(rs.getString("name"));
          user.setEmail(rs.getString("email"));
          user.setTel(rs.getString("tel"));
          return user;
        }
        return null;
      }
    }
  }

  @Override
  public boolean update(User user) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement("update myapp_users set"
        + " name=?,"
        + " email=?,"
        + " pwd=sha1(?),"
        + " tel=?"
        + " where user_id=?")) {

      stmt.setString(1, user.getName());
      stmt.setString(2, user.getEmail());
      stmt.setString(3, user.getPassword());
      stmt.setString(4, user.getTel());
      stmt.setInt(5, user.getNo());

      return stmt.executeUpdate() > 0;
    }
  }

  @Override
  public boolean delete(int no) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement("delete from myapp_users where user_id=?")) {
      stmt.setInt(1, no);
      return stmt.executeUpdate() > 0;
    }
  }
}