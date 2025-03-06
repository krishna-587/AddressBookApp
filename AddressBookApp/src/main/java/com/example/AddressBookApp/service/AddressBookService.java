package com.example.AddressBookApp.service;

import com.example.AddressBookApp.DTOs.AddressBookDTO;
import com.example.AddressBookApp.model.AddressBook;

import java.util.List;

public interface AddressBookService {
    List<AddressBookDTO> getAllAddresses();
    AddressBookDTO getAddressById(Long id);
    AddressBookDTO createAddress(AddressBookDTO addressBookDTO);
    AddressBookDTO updateAddress(Long id, AddressBookDTO addressBookDTO);
    void deleteAddress(Long id);
}
