package com.eazyschool.service;

import com.eazyschool.constant.EazySchoolConstant;
import com.eazyschool.model.Contact;
import com.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Contact> findMessagesWithOpenStatus(int pageNum, String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sortDir.equals("asc") ? Sort.by(sortField).ascending()
                            : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus("Open", pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int id) {
        boolean isUpdated;
        int rowsUpdated = contactRepository.updateContactById(EazySchoolConstant.CLOSE.toString(),id);
        isUpdated = rowsUpdated > 0;
        return isUpdated;
    }
}
