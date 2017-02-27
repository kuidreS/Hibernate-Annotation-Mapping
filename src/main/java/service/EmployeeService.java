package service;

import bl.SessionUtil;
import dao.EmployeeDAO;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vserdiuk on 2/12/17.
 */
public class EmployeeService extends SessionUtil implements EmployeeDAO {

    public void add(Employee employee) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public List<Employee> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM EMPLOYEE";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employeeList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return employeeList;
    }

    public Employee getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM EMPLOYEE WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);

        Employee employee = (Employee) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return employee;
    }

    public void update(Employee employee) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public void remove(Employee employee) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(employee);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
