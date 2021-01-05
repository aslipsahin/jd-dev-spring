package com.cyber.repositories;

import com.cyber.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /*
    Derived Queries --> the ready ones.
    JPQL Queries --> By using @Query("..."), they run in entity
    Native Queries --> Pure SQL queries. By using @Query(nativequery=true), they run in DB
    Named Queries --> Can be defined by using properties file, annotations in the entity classes or XML file

    ------

    For update, insert and delete --> @Modify & @Transactional & @Query

    ------

    Parameters:
        1. Positional(bind) parameter
        2. Named parameter
     */


//    -------------JPQL------------
//    JPQL run data through Entity. So i need to use class name. Employee below stands for Entity name, e stands for object

    @Query("SELECT e FROM Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Integer getEmployeeSalary();


//    If there is no object returning from the method, the system returns NullPointerException.
//    To prevent it, use Optional<Employee>. It will return a message like "Optional.empty"

//    Positional parameter: "e.email = ?1" in the query means the first parameter of the method will be email.

    //    Single bind parameter
    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Optional<Employee> getEmployeeByEmail(String email);


    //  Multiple bind parameter
    @Query("SELECT e FROM Employee e WHERE e.email = ?1 and e.salary = ?2")
    Employee getEmployeeByEmailAndSalary(String email, int salary);


//    Named parameter: "e.email =:salary" in the query looks in the method param "@Param("email") String email)

    //    Single named parameter
    @Query("SELECT e FROM Employee e WHERE e.salary=:salary")
    Employee getEmployeeBySalary(@Param("salary") int salary);

    //    Multiple named parameter
    @Query("SELECT e FROM Employee e WHERE e.firstName=:name OR e.salary=:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name") String name, @Param("salary") int salary);

    //    Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> getEmployeeBySalaryNotEqual(int salary);

    //    Like / Contains / StartsWith / EndsWith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmmployeeByFirstNameLike(String patter);

    //    Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    //    Greater Than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(int salary);

    //    Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1, int salary2);

    //Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //Null
    @Query("SELECT e FROM Employee e WHERE e.email is null")
    List<Employee> getEmployeeByEmailIsNull();

    //Not Null
    @Query("SELECT e FROM Employee e WHERE e.email is not null")
    List<Employee> getEmployeeByEmailIsNotNull();

    //Sort Salary in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeBySalaryOrderByAsc();

    //Sort Salary in ascending order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeeBySalaryOrderByDesc();

//    -------------Native Query (PURE SQL)------------
//Native query runs in DB. So i need to use table name.
//    I can use both position parameter or named parameter

    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> readEmployeeBySalary(int salary);

//    --------------INSERT, UPDATE, DELETE ACTIONS--------------
//    I need to use @Modifying and @Transactional annotations with @Query for these functions
//    If i do not add @Transactional annotation, it will throw error.

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'admin@email.com' WHERE e.id=:id")
    void updateEmployeeJPQL(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email = 'admin@email.com' WHERE id=:id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Integer id);


    //    ----------Named Query : i have added the query into jpa-name-queries.properties file-------

//    Derived and @Query approaches are good for small to medium apps but for bigger apps, it is better to use Named
//    Queries. Named Queries can be defined by using properties file, annotations in the entity classes or XML file.
    List<Employee> retrieveEmployeeSalaryGreaterThan(Integer salary);

}
