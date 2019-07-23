package com.sumerge.program.managers;

import com.sumerge.program.entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddressManager {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("programdb-pu");

    public Address createAddress(Address address){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction  entityTransaction =  entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(address);
        entityTransaction.commit();

        entityManager.close();
        return address;
    }

    public Address readAddress(Integer addressID){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Address address = entityManager.find( Address.class, addressID);

        entityManager.close();
        return address;
    }

    public Address updateAddress(Address addressNew){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction  entityTransaction =  entityManager.getTransaction();

        entityTransaction.begin();
        Address addressDB = entityManager.find( Address.class, addressNew.getAddressID());
        addressDB.setEmployee(addressNew.getEmployee());
        addressDB.setAddLine1(addressNew.getAddLine1());
        addressDB.setAddLine2(addressNew.getAddLine2());
        addressDB.setCity(addressNew.getCity());
        addressDB.setRegion(addressNew.getRegion());
        addressDB.setCountry(addressNew.getCountry());
        addressDB.setPostcode(addressNew.getPostcode());
        entityTransaction.commit();

        entityManager.close();
        return addressDB;
    }

    public String deleteAddress(Integer addressID){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction  entityTransaction =  entityManager.getTransaction();

        entityTransaction.begin();
        Address address = entityManager.find( Address.class, addressID);
        entityManager.remove(address);
        entityTransaction.commit();

        entityManager.close();
        return "Address Deleted Successfully.";
    }

}
