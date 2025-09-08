package com.edcg.simple.springboot.webapp.controller;

import com.edcg.simple.springboot.webapp.model.Student;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("request")
public class StudentController {

    @RequestMapping(value="/students", method=RequestMethod.GET)
    public String studentsPage(Model model){
        List<Student> students = getPredefinedStudents();
        model.addAttribute("students", students);
        model.addAttribute("totalStudents", students.size());
        return "students";
    }

    private List<Student> getPredefinedStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1L, "Emma", "Johnson", "emma.johnson@university.edu",
                "Computer Science", 20));

        students.add(new Student(2L, "Michael", "Chen", "michael.chen@university.edu",
                "Engineering", 22));

        students.add(new Student(3L, "Sofia", "Martinez", "sofia.martinez@university.edu",
                "Business Administration", 21));

        students.add(new Student(4L, "James", "Wilson", "james.wilson@university.edu",
                "Mathematics", 23));

        students.add(new Student(5L, "Olivia", "Brown", "olivia.brown@university.edu",
                "Psychology", 19));

        students.add(new Student(6L, "David", "Garcia", "david.garcia@university.edu",
                "Physics", 24));

        students.add(new Student(7L, "Isabella", "Lee", "isabella.lee@university.edu",
                "Art & Design", 20));

        students.add(new Student(8L, "Alexander", "Taylor", "alexander.taylor@university.edu",
                "History", 22));

        return students;
    }
}