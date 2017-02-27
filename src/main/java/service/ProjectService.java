package service;

import bl.HibernateUtil;
import bl.SessionUtil;
import dao.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vserdiuk on 2/12/17.
 */
public class ProjectService extends SessionUtil implements ProjectDAO {

    public void add(Project project) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(project);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public List<Project> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM PROJECT";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projectList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return projectList;
    }

    public Project getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM PROJECT WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id", id);

        Project project = (Project) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return project;
    }

    public void update(Project project) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(project);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public void remove(Project project) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(project);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
