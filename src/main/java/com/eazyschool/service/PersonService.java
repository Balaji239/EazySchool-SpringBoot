package com.eazyschool.service;

import com.eazyschool.constant.EazySchoolConstant;
import com.eazyschool.model.Person;
import com.eazyschool.model.Role;
import com.eazyschool.repository.PersonRepository;
import com.eazyschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Role role = rolesRepository.getByRoleName(EazySchoolConstant.STUDENT.toString());
        person.setRole(role);
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person = personRepository.save(person);
        isSaved = person != null && person.getPersonId() > 0;
        return  isSaved;
    }
}
