package es.ieslavereda.demospringboot.service;


import es.ieslavereda.demospringboot.model.Oficio;
import es.ieslavereda.demospringboot.repository.OficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OficioService {

    @Autowired
    private OficioRepository oficioRepository;

    public List<Oficio> getOficios() {
        return oficioRepository.getAll();
    }


    public Oficio getOficioById(int id) {
        return oficioRepository.findOficioById(id);
    }

    public Oficio createOficio(Oficio oficio) {
        return oficioRepository.createOficio(oficio);
    }

    public Oficio deleteOficio(int id) throws SQLException {
        return oficioRepository.deleteOficio(id);
    }

    public Oficio updateOficio(Oficio oficio) throws SQLException {
        return oficioRepository.updateOficio(oficio);
    }
}
