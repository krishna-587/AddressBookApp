package com.example.AddressBookApp.service;

import com.example.AddressBookApp.DTOs.AddressBookDTO;
import com.example.AddressBookApp.model.AddressBook;
import com.example.AddressBookApp.exception.ResourceNotFoundException;
import com.example.AddressBookApp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBookDTO> getAllAddresses() {
        return addressBookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressBookDTO getAddressById(Long id) {
        AddressBook addressBook = addressBookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AddressBook", "id", id));
        return convertToDTO(addressBook);
    }

    @Override
    public AddressBookDTO createAddress(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = convertToEntity(addressBookDTO);
        // Let the database handle ID generation
        addressBook.setId(null);
        AddressBook savedAddress = addressBookRepository.save(addressBook);
        return convertToDTO(savedAddress);
    }

    @Override
    public AddressBookDTO updateAddress(Long id, AddressBookDTO addressBookDTO) {
        // Check if address exists
        AddressBook existingAddress = addressBookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AddressBook", "id", id));

        // Update the existing address with new values
        AddressBook addressBook = convertToEntity(addressBookDTO);
        addressBook.setId(id);
        // Preserve creation timestamp
        addressBook.setCreatedAt(existingAddress.getCreatedAt());

        AddressBook updatedAddress = addressBookRepository.save(addressBook);
        return convertToDTO(updatedAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        // Check if address exists
        addressBookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AddressBook", "id", id));

        addressBookRepository.deleteById(id);
    }

    // Helper methods to convert between Entity and DTO
    private AddressBookDTO convertToDTO(AddressBook addressBook) {
        AddressBookDTO dto = new AddressBookDTO(
                addressBook.getId(),
                addressBook.getName(),
                addressBook.getAddress(),
                addressBook.getCity(),
                addressBook.getState(),
                addressBook.getZip(),
                addressBook.getPhone(),
                addressBook.getEmail()
        );
        dto.setCreatedAt(addressBook.getCreatedAt());
        dto.setUpdatedAt(addressBook.getUpdatedAt());
        return dto;
    }

    private AddressBook convertToEntity(AddressBookDTO dto) {
        AddressBook entity = new AddressBook(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getCity(),
                dto.getState(),
                dto.getZip(),
                dto.getPhone(),
                dto.getEmail()
        );
        // Don't set timestamps here - let @PrePersist and @PreUpdate handle it
        return entity;
    }
}