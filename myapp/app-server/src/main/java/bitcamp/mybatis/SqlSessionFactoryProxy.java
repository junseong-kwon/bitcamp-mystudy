package bitcamp.mybatis;

import org.apache.ibatis.session.*;

import java.sql.Connection;

public class SqlSessionFactoryProxy implements SqlSessionFactory {

    ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();
    private SqlSessionFactory original;

    public SqlSessionFactoryProxy(SqlSessionFactory original) {
        this.original = original;
    }


    @Override
    public SqlSession openSession() {
        return original.openSession();
    }

    @Override
    public SqlSession openSession(boolean autoCommit) {
        SqlSession sqlSession = sqlSessionThreadLocal.get();

        if (sqlSession == null) {

            sqlSession = original.openSession(autoCommit);

            sqlSessionThreadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    @Override
    public SqlSession openSession(Connection connection) {
        return null;
    }

    @Override
    public SqlSession openSession(TransactionIsolationLevel level) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, Connection connection) {
        return null;
    }

    @Override
    public Configuration getConfiguration() {
        return null;
    }
}
