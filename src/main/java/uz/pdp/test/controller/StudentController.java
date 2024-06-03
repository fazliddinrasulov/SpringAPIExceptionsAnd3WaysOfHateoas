package uz.pdp.test.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        Link self = linkTo(methodOn(StudentController.class).getAllStudent()).withRel("self");
        return CollectionModel.of(students, self);
    }

    @GetMapping("{id}")
    public EntityModel<?> getStudent(@PathVariable Integer id) {
        Link self = linkTo(methodOn(StudentController.class).getStudent(id)).withRel("self");
        Link all= linkTo(methodOn(StudentController.class).getAllStudent()).withRel("all");
        Student student = studentService.getStudent(id).orElseThrow(() -> new ItemNotFoundException("Bunday o'quvchi mavjud emas"));
        return EntityModel.of(student,self, all);
    }

    @PostMapping
    public EntityModel<?> addStudent(@Valid @RequestBody Student student) {
        Link self = linkTo(methodOn(StudentController.class).getStudent(student.getId())).withRel("self");
        Student result = studentService.addStudent(student);
        return EntityModel.of(result, self);
    }
}
