package com.example.AddressBookApp.repository;

import com.example.AddressBookApp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
    // Spring Data JPA will automatically implement basic CRUD operations
    // You can add custom query methods here if needed
}
