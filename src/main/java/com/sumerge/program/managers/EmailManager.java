package com.sumerge.program.managers;

import com.sumerge.program.entities.Email;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;

@Stateless
public class EmailManager {

    @PersistenceContext(unitName = "programdb-pu")
    private EntityManager entityManager;

    public Email createEmail(Email email){
        return entityManager.merge(email);
    }

    public Collection<Email> readAllEmails() {
        return entityManager.createQuery("SELECT x FROM Email x", Email.class).
                getResultList();
    }

    public Email readEmail(Integer emailId){
        Email email = entityManager.find( Email.class, emailId);
        return email;
    }

    public Email updateEmail(Email emailNew){
        Email emailDB = entityManager.find( Email.class, emailNew.getEmailId());
        emailDB.setEmployee(emailNew.getEmployee());
        emailDB.setEmailAddress(emailNew.getEmailAddress());
        emailDB.setEmailType(emailNew.getEmailType());
        return entityManager.merge(emailDB);
    }

    public String deleteEmail(Integer emailId){
        Email email = entityManager.find( Email.class, emailId);
        entityManager.remove(email);

        return "Email Deleted Successfully.";
    }

}
