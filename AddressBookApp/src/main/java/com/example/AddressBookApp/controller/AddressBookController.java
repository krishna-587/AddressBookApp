package com.example.AddressBookApp.controller;

import com.example.AddressBookApp.DTOs.AddressBookDTO;
import com.example.AddressBookApp.model.AddressBook;
import com.example.AddressBookApp.service.AddressBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/addressbook")
@CrossOrigin(origins = "*")
@Validated
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<AddressBookDTO>> getAllAddresses() {
        List<AddressBookDTO> addresses = addressBookService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getAddressById(@PathVariable Long id) {
        AddressBookDTO addressDTO = addressBookService.getAddressById(id);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<AddressBookDTO> createAddress(@Valid @RequestBody AddressBookDTO addressDTO) {
        AddressBookDTO createdAddress = addressBookService.createAddress(addressDTO);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateAddress(
            @PathVariable Long id,
            @Valid @RequestBody AddressBookDTO addressDTO) {
        AddressBookDTO updatedAddress = addressBookService.updateAddress(id, addressDTO);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteAddress(@PathVariable Long id) {
        addressBookService.deleteAddress(id);
        return new ResponseEntity<>(Map.of("message", "Address deleted successfully"), HttpStatus.OK);
    }
}