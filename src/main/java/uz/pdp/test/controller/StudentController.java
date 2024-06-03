package uz.pdp.test.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

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
    public HttpEntity<?> getAllStudent() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getStudent(@PathVariable Integer id) {
        Student student = studentService.getStudent(id).orElseThrow(() -> new ItemNotFoundException("Bunday o'quvchi mavjud emas"));
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PostMapping
    public HttpEntity<?> addStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
