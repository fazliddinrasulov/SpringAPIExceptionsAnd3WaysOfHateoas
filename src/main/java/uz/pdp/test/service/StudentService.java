package uz.pdp.test.service;

import org.springframework.stereotype.Service;
import uz.pdp.test.entity.Student;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student addStudent(Student student);

    Student save(Student student);

    Optional<Student> getStudent(Integer id);
}
