package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.ProjectDao;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

  private Connection con;

  public ProjectDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public boolean insert(Project project) throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement()) {

      // insert 문 전달
      stmt.executeUpdate(String.format(
          "insert into myapp_users(title, description, start_date, end_date, members)"
              + " values ('%s', '%s', '%s, '%s', '%s')",
          project.getTitle(),
          project.getDescription(),
          project.getStartDate(),
          project.getEndDate(),
          project.getMembers()));

      return true;
    }
  }

  @Override
  public List<Project> list() throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement();

        // select 문 실행을 요청한다.
        ResultSet rs = stmt.executeQuery("select * from myapp_projects order by project_id asc")) {

      ArrayList<Project> list = new ArrayList<>();
      ArrayList<User> list2 = new ArrayList<>();

      while (rs.next()) { // select 실행 결과에서 1 개의 레코드를 가져온다.
        Project project = new Project();
        project.setNo(rs.getInt("project_id"));
        project.setTitle(rs.getString("title"));
        project.setDescription(rs.getString("description"));
        project.setStartDate(rs.getString("start_date"));
        project.setEndDate(rs.getString("end_date"));

        list.add(project);
        list2.add(new User());

      }

      return list;
    }
  }

  @Override
  public Project findBy(int no) throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement();

        // select 문 실행을 요청한다.
        ResultSet rs = stmt.executeQuery("select * from myapp_projects where user_id=" + no)) {

      if (rs.next()) { // select 실행 결과에서 1 개의 레코드를 가져온다.
        Project project = new Project();
        project.setNo(rs.getInt("project_id"));
        project.setTitle(rs.getString("title"));
        project.setDescription(rs.getString("description"));
        project.setStartDate(rs.getString("start_date"));
        project.setEndDate(rs.getString("end_date"));

        return project;
      }

      return null;
    }
  }

  @Override
  public boolean update(Project project) throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement()) {

      // update 문 전달
      int count = stmt.executeUpdate(String.format(
          "update myapp_projects set"
              + " title='%s',"
              + " description='%s',"
              + " start_date='%s',"
              + " end_date='%s'"
              + " where user_id=%d",
          project.getTitle(),
          project.getDescription(),
          project.getEndDate(),
          project.getStartDate(),
          project.getNo()));

      return count > 0;
    }
  }

  @Override
  public boolean delete(int no) throws Exception {
    try (// SQL을 서버에 전달할 객체 준비
        Statement stmt = con.createStatement()) {

      // delete 문 전달
      int count = stmt.executeUpdate(
          String.format("delete from myapp_projects where user_id=%d", no));

      return count > 0;
    }
  }
}
