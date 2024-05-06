package es.ieslavereda.demospringboot.controller;

import es.ieslavereda.demospringboot.model.Oficio;
import es.ieslavereda.demospringboot.service.OficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class OficioController {

    private final Logger LOGGER = Logger.getLogger(getClass().getCanonicalName());

    @Autowired
    private OficioService oficioService;

    @GetMapping("/oficios")
    public List<Oficio> getAll(){
        LOGGER.log(Level.INFO,"Obteniendo todos los oficios");
        return oficioService.getOficios();
    }

    @GetMapping("/oficios/{id}")
    public Oficio getOficio(@PathVariable int id){
        LOGGER.log(Level.INFO,"Obteniendo el oficio " + id);
        return oficioService.getOficioById(id);
    }

    @PostMapping("/oficio")
    public ResponseEntity<Oficio> createOficio(@RequestBody Oficio oficio){
        LOGGER.log(Level.INFO,"Creando el oficio " + oficio);
        Oficio o = oficioService.createOficio(oficio);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    @DeleteMapping("/oficio/{id}")
    public ResponseEntity<?> deleteOficio(@PathVariable int id){
        LOGGER.log(Level.INFO,"Borrando el oficio " + id);
        try {
            Oficio oficio = oficioService.deleteOficio(id);
            return new ResponseEntity<>(oficio, HttpStatus.OK);
        }catch (SQLException e){
            return getResponseError(e);
        }
    }

    @PutMapping("/oficio")
    public ResponseEntity<?> updateOficio(@RequestBody Oficio oficio){
        LOGGER.log(Level.INFO,"Actualizando el oficio " + oficio);
        try {
            Oficio o = oficioService.updateOficio(oficio);
            return new ResponseEntity<>(o, HttpStatus.OK);
        }catch (SQLException e){
            return getResponseError(e);
        }
    }


/*
    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        LOGGER.log(Level.INFO,"Actualizando el usuario: " + user);
        try {
            User u = userService.updateUser(user);
            return new ResponseEntity<>(u, HttpStatus.OK);
        } catch (SQLException e) {
            return getResponseError(e);
        }
    }

 */






    private ResponseEntity<?> getResponseError(SQLException e) {

        Map<String, String> map = new HashMap<>();

        map.put("errorCode", String.valueOf(e.getErrorCode()));
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
