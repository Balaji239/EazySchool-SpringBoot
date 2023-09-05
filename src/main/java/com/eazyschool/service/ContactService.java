package com.eazyschool.service;

import com.eazyschool.constant.EazySchoolConstant;
import com.eazyschool.model.Contact;
import com.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstant.OPEN.toString());
//        contact.setCreatedBy(EazySchoolConstant.ANONYMOUS.toString());
//        contact.setCreatedAt(LocalDateTime.now());
        Contact savedContact = contactRepository.save(contact);
        isSaved = savedContact != null && savedContact.getContactId() > 0;
        return  isSaved;
    }

    public List<Contact> getAllOpenStatusMessages() {
        List<Contact> contacts = contactRepository.findByStatus(EazySchoolConstant.OPEN.toString());
        return contacts;
    }

    public boolean updateMsgStatus(int id, String updatedBy) {
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(id);
        contact.ifPresent( contact1 -> {
            contact1.setStatus(EazySchoolConstant.CLOSE.toString());
//            contact1.setUpdatedBy(updatedBy);
//            contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact = contactRepository.save(contact.get());
        isUpdated = updatedContact != null && updatedContact.getUpdatedAt() != null;
        return isUpdated;
    }
}
