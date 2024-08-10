package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.infrastructure.out.mongodb.adapter.TraceMongodbAdapter;
import com.pragma.powerup.infrastructure.out.mongodb.entity.TraceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class MongoTestController {
    @Autowired
    private TraceMongodbAdapter personaService;

    @GetMapping
    public List<TraceEntity> obtenerTodasLasPersonas() {
        return personaService.obtenerTodasLasPersonas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TraceEntity> obtenerPersonaPorId(@PathVariable String id) {
        TraceEntity persona = personaService.obtenerPersonaPorId(id);
        if (persona != null) {
            return new ResponseEntity<>(persona, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TraceEntity> crearPersona(@RequestBody TraceEntity persona) {
        TraceEntity nuevaPersona = personaService.crearPersona(persona);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TraceEntity> actualizarPersona(@PathVariable String id, @RequestBody TraceEntity persona) {
        TraceEntity personaActualizada = personaService.actualizarPersona(id, persona);
        if (personaActualizada != null) {
            return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable String id) {
        personaService.eliminarPersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}