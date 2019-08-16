package com.atomic.controllers;

import com.atomic.models.Atomic;
import com.atomic.repositories.AtomicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/")
public class AtomicController {

    @Autowired
    private AtomicRepository atomicRepository;

    @GetMapping("/atomics")
    public List<Atomic> getAllAtomics() {
        return atomicRepository.findAll();
    }

    @GetMapping("/atomics/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        try {
            Atomic atomic = atomicRepository.getOne(id);
            return ResponseEntity.status(HttpStatus.OK).body(atomic);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Atom with id " + id + " " + "not found");
        }
    }

    @PostMapping("/atomics")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity create(@RequestBody Atomic atomic) {
        atomicRepository.save(atomic);

        return ResponseEntity.status(HttpStatus.OK).body("Atom successful created with id " + atomic.getId());
    }

    @DeleteMapping("/atomics/{atomicId}")
    public ResponseEntity delete(@PathVariable Long atomicId) {
        atomicRepository.deleteById(atomicId);

        return ResponseEntity.status(HttpStatus.OK).body("atom deleted with this id: " + atomicId);

    }
}
