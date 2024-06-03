package uz.pdp.test.component;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.test.entity.Student;
import uz.pdp.test.service.StudentService;

@Component
@RequiredArgsConstructor
public class Runnable implements CommandLineRunner {
    private final StudentService studentService;
    @Override
    public void run(String... args){
//        studentService.save(Student.builder()
//                .name("Eshmat")
//                .build());
//
//        studentService.save(Student.builder()
//                .name("Tsohmat")
//                .build());
    }
}
