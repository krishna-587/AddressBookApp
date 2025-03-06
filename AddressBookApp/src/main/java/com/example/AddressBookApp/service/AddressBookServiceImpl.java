package com.example.AddressBookApp.service;

import com.example.AddressBookApp.DTOs.AddressBookDTO;
import com.example.AddressBookApp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    // In-memory data storage
    private List<AddressBook> addressBooks = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<AddressBookDTO> getAllAddresses() {
        return addressBooks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressBookDTO getAddressById(Long id) {
        Optional<AddressBook> addressBook = addressBooks.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();

        return addressBook.map(this::convertToDTO).orElse(null);
    }

    @Override
    public AddressBookDTO createAddress(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = convertToEntity(addressBookDTO);
        addressBook.setId(nextId++);
        addressBooks.add(addressBook);
        return convertToDTO(addressBook);
    }

    @Override
    public AddressBookDTO updateAddress(Long id, AddressBookDTO addressBookDTO) {
        Optional<AddressBook> existingAddress = addressBooks.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();

        if (existingAddress.isPresent()) {
            AddressBook addressBook = existingAddress.get();
            addressBook.setName(addressBookDTO.getName());
            addressBook.setAddress(addressBookDTO.getAddress());
            addressBook.setCity(addressBookDTO.getCity());
            addressBook.setState(addressBookDTO.getState());
            addressBook.setZip(addressBookDTO.getZip());
            addressBook.setPhone(addressBookDTO.getPhone());
            addressBook.setEmail(addressBookDTO.getEmail());

            return convertToDTO(addressBook);
        }

        return null;
    }

    @Override
    public void deleteAddress(Long id) {
        addressBooks.removeIf(address -> address.getId().equals(id));
    }

    // Helper methods to convert between Entity and DTO
    private AddressBookDTO convertToDTO(AddressBook addressBook) {
        return new AddressBookDTO(
                addressBook.getId(),
                addressBook.getName(),
                addressBook.getAddress(),
                addressBook.getCity(),
                addressBook.getState(),
                addressBook.getZip(),
                addressBook.getPhone(),
                addressBook.getEmail()
        );
    }

    private AddressBook convertToEntity(AddressBookDTO dto) {
        return new AddressBook(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getCity(),
                dto.getState(),
                dto.getZip(),
                dto.getPhone(),
                dto.getEmail()
        );
    }
}