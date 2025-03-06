package com.example.AddressBookApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping({"", "/"})
    public ResponseEntity<List<String>> getAllAddresses() {
        // This is a simple test response for UC1-UC2
        List<String> addresses = Arrays.asList("Address 1", "Address 2", "Address 3");
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable Long id) {
        // Simple test response
        return new ResponseEntity<>("Address " + id, HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<String> createAddress(@RequestBody String address) {
        // Simple test response
        return new ResponseEntity<>("Created: " + address, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody String address) {
        // Simple test response
        return new ResponseEntity<>("Updated address " + id + " with: " + address, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        // Simple test response
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}