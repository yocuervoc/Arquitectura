package sa.course.service;

import sa.course.model.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CourseService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Course> getAllCourses(int first, int maxResult) {
        return entityManager.createNamedQuery(Course.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public Course getCourseByCode(long code){
        return entityManager.find(Course.class, code);
    }

    public void createCourse(Course course) {
        entityManager.persist(course);
    }

    public Course updateCourse(long code, Course course) {
        Course courseToUpdate = entityManager.find(Course.class, code);
        courseToUpdate.setName(course.getName());
        courseToUpdate.setLastName(course.getLastName());
        courseToUpdate.setCabin(course.getCabin());
        courseToUpdate.setCreditCard(course.getCreditCard());
        ;
        return entityManager.merge(courseToUpdate);
    }

    public void deleteCourse(long code) {
        Course course = entityManager.find(Course.class, code);
        entityManager.remove(course);
    }
}
