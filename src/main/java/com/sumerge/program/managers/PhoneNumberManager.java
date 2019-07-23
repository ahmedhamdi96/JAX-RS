package com.sumerge.program.managers;

import com.sumerge.program.entities.PhoneNumber;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;

@Stateless
public class PhoneNumberManager {

    @PersistenceContext(unitName = "programdb-pu")
    private EntityManager entityManager;

    public PhoneNumber createPhoneNumber(PhoneNumber phoneNumber){
        return entityManager.merge(phoneNumber);
    }

    public Collection<PhoneNumber> readAllPhoneNumbers() {
        return entityManager.createQuery("SELECT x FROM PhoneNumber x", PhoneNumber.class).
                getResultList();
    }

    public PhoneNumber readPhoneNumber(Integer phoneId){
        PhoneNumber phoneNumber = entityManager.find( PhoneNumber.class, phoneId);
        return phoneNumber;
    }

    public PhoneNumber updatePhoneNumber(PhoneNumber phoneNumberNew){
        PhoneNumber phoneNumberDB = entityManager.find( PhoneNumber.class, phoneNumberNew.getPhoneId());
        phoneNumberDB.setEmployee(phoneNumberNew.getEmployee());
        phoneNumberDB.setLocalNum(phoneNumberNew.getLocalNum());
        phoneNumberDB.setIntlPrefix(phoneNumberNew.getIntlPrefix());
        phoneNumberDB.setPhoneType(phoneNumberNew.getPhoneType());
        return entityManager.merge(phoneNumberDB);
    }

    public String deletePhoneNumber(Integer phoneId){
        PhoneNumber phoneNumber = entityManager.find( PhoneNumber.class, phoneId);
        entityManager.remove(phoneNumber);

        return "PhoneNumber Deleted Successfully.";
    }

}
