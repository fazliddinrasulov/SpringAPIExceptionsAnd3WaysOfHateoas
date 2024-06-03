package uz.pdp.test.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import uz.pdp.test.entity.Student;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StudentModelAssembler implements RepresentationModelAssembler<Student, EntityModel<Student>> {
    @Override
    public EntityModel<Student> toModel(Student student) {
        Link self = linkTo(methodOn(StudentController.class).getStudent(student.getId())).withRel("self");
        Link all= linkTo(methodOn(StudentController.class).getAllStudent()).withRel("all");
        return EntityModel.of(student,self, all);
    }
}
