package uz.pdp.test.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;
import uz.pdp.test.entity.Student;
import uz.pdp.test.exception.ItemNotFoundException;
import uz.pdp.test.service.StudentService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public CollectionModel<?> getAllStudent() {
        List<Student> students = studentService.getAllStudents();
        return CollectionModel.of(
                students,
                Link.of("http://localhost:8080/students").withRel("self")
        );
    }

    @GetMapping("{id}")
    public EntityModel<?> getStudent(@PathVariable Integer id) {
        Student student = studentService.getStudent(id).orElseThrow(() -> new ItemNotFoundException("Bunday o'quvchi mavjud emas"));
        return EntityModel.of(
                student,
                Link.of("http://localhost:8080/students/" + id).withRel("self"),
                Link.of("http://localhost:8080/students").withRel("all")
        );
    }

    @PostMapping
    public EntityModel<?> addStudent(@Valid @RequestBody Student student) {
        Student result = studentService.addStudent(student);
        return EntityModel.of(
                result,
                Link.of("http://localhost:8080/students/" + student.getId()).withRel("self"),
                Link.of("http://localhost:8080/students").withRel("all")

        );
    }
}
