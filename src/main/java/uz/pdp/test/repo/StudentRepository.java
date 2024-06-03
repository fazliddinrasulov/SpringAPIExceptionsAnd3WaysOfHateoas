package uz.pdp.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.test.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}