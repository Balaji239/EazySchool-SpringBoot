package com.eazyschool.controller;

import com.eazyschool.model.Course;
import com.eazyschool.model.EazyClass;
import com.eazyschool.model.Person;
import com.eazyschool.repository.ClassRepository;
import com.eazyschool.repository.CoursesRepository;
import com.eazyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @RequestMapping("/displayClasses")
    public String displayClasses(Model model){
        List<EazyClass> classes = classRepository.findAll();
        model.addAttribute("eazyClass", new EazyClass());
        model.addAttribute("classes", classes);
        return "classes";
    }

    @PostMapping("/addNewClass")
    public String addNewClass(Model model, @ModelAttribute EazyClass eazyClass){
        classRepository.save(eazyClass);
        return "redirect:/admin/displayClasses";
    }

    @RequestMapping("/deleteClass")
    public String deleteClass(Model model, @RequestParam int id){
        Optional<EazyClass> eazyClass = classRepository.findById(id);
        for(Person person : eazyClass.get().getPersons()){
            person.setEazyClass(null);
            personRepository.save(person);
        }
        classRepository.deleteById(id);
        return "redirect:/admin/displayClasses";
    }

    @GetMapping("/displayStudents")
    public String displayStudents(Model model, @RequestParam int classId, @RequestParam(required = false) String error){
        Optional<EazyClass> eazyClass = classRepository.findById(classId);
        model.addAttribute("eazyClass", eazyClass.get());
        model.addAttribute("person", new Person());
        if(error!=null)
            model.addAttribute("errorMessage","Student with that email does not exist");
        return "students";
    }

    @PostMapping("/addStudent")
    public String addStudent(Model model, @ModelAttribute Person person, @RequestParam int classIdParam){
        System.out.println(classIdParam);
        Optional<EazyClass> eazyClass = classRepository.findById(classIdParam);
        Person personEntity = personRepository.getByEmail(person.getEmail());
        if(personEntity ==  null || !(personEntity.getPersonId()>0))
            return "redirect:/admin/displayStudents?classId="+classIdParam+"&error=true";

        personEntity.setEazyClass(eazyClass.get());
        personRepository.save(personEntity);
        eazyClass.get().getPersons().add(personEntity);
        classRepository.save(eazyClass.get());
        return "redirect:/admin/displayStudents?classId="+classIdParam;
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(Model model, @RequestParam int personId, HttpServletRequest request){
        String classId = request.getParameter("classId");
        EazyClass eazyClass = classRepository.findById(Integer.parseInt(classId)).get();
        Optional<Person> person = personRepository.findById(personId);
        person.get().setEazyClass(null);
        eazyClass.getPersons().remove(person.get());
        classRepository.save(eazyClass);
        return "redirect:/admin/displayStudents?classId="+classId;
    }

    @GetMapping("/displayCourses")
    public String displayCourses(Model model){
        List<Course> courses = coursesRepository.findByOrderByName();
        model.addAttribute("courses", courses);
        model.addAttribute("course", new Course());
        return "courses_secure";
    }

    @PostMapping("/addNewCourse")
    public String addNewCourse(@ModelAttribute("course") Course course) {
        coursesRepository.save(course);
        return "redirect:/admin/displayCourses";
    }

    @GetMapping("/viewStudents")
    public String viewStudents(Model model, @RequestParam int id,@RequestParam(required = false) String error) {
        Optional<Course> course = coursesRepository.findById(id);
        System.out.println("Course persons are" + course.get().getPersons());
        model.addAttribute("course",course.get());
        model.addAttribute("person",new Person());
        if(error != null) {
            model.addAttribute("errorMessage", "Student with email doesn't exist");
        }
        return "courses_students";
    }

    @PostMapping("/addStudentToCourse")
    public String addStudentToCourse(@ModelAttribute("person") Person person, @RequestParam int courseId) {
        Course course = coursesRepository.findById(courseId).get();
        Person personEntity = personRepository.getByEmail(person.getEmail());
        if(personEntity==null || !(personEntity.getPersonId()>0)){
           return "redirect:/admin/viewStudents?id="+courseId+"&error=true";
        }
        personEntity.getCourses().add(course);
        course.getPersons().add(personEntity);
        personRepository.save(personEntity);
        return "redirect:/admin/viewStudents?id="+courseId;
    }

    @GetMapping("/deleteStudentFromCourse")
    public String deleteStudentFromCourse(Model model, @RequestParam int personId, @RequestParam int courseId) {
        Course course = coursesRepository.findById(courseId).get();
        Optional<Person> person = personRepository.findById(personId);
        person.get().getCourses().remove(course);
        course.getPersons().remove(person.get());
        personRepository.save(person.get());
        return "redirect:/admin/viewStudents?id="+courseId;
    }

}
