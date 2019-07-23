package com.sumerge.program.managers;

import com.sumerge.program.entities.Address;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;

@Stateless
public class AddressManager {

    @PersistenceContext(unitName = "programdb-pu")
    private EntityManager entityManager;

    public Address createAddress(Address address){
         return entityManager.merge(address);
    }

    public Collection<Address> readAllAddresses() {
        return entityManager.createQuery("SELECT x FROM Address x", Address.class).
                getResultList();
    }

    public Address readAddress(Integer addressID){
        Address address = entityManager.find( Address.class, addressID);
        return address;
    }

    public Address updateAddress(Address addressNew){
        Address addressDB = entityManager.find( Address.class, addressNew.getAddressID());
        addressDB.setEmployee(addressNew.getEmployee());
        addressDB.setAddLine1(addressNew.getAddLine1());
        addressDB.setAddLine2(addressNew.getAddLine2());
        addressDB.setCity(addressNew.getCity());
        addressDB.setRegion(addressNew.getRegion());
        addressDB.setCountry(addressNew.getCountry());
        addressDB.setPostcode(addressNew.getPostcode());
        return entityManager.merge(addressDB);
    }

    public String deleteAddress(Integer addressID){
        Address address = entityManager.find( Address.class, addressID);
        entityManager.remove(address);

        return "Address Deleted Successfully.";
    }

}
