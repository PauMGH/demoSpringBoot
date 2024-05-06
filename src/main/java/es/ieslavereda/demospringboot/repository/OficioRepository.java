package es.ieslavereda.demospringboot.repository;

import es.ieslavereda.demospringboot.model.Oficio;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class OficioRepository {

    private List<Oficio> oficios;

    public OficioRepository(){
        oficios = new ArrayList<>();
        oficios.add(new Oficio(1, "Juzgador"));
        oficios.add(new Oficio(2, "Influencer"));
        oficios.add(new Oficio(3, "Sistemas"));
    }

    public List<Oficio> getAll() {
        return oficios;
    }

    public Oficio findOficioById(int id) {
        Optional<Oficio> optional = oficios.stream()
                .filter(oficio -> oficio.getId_oficio() == id)
                .findFirst();
        return optional.orElse(null);
    }

    public Oficio createOficio(Oficio oficio) {
        oficios.add(oficio);
        return oficio;
    }

    public Oficio deleteOficio(int id) throws SQLException {
        Optional<Oficio> optional = oficios.stream()
                .filter(oficio -> oficio.getId_oficio() == id)
                .findFirst();
        if (optional.isPresent()) {
            oficios.remove(optional.get());
            return optional.get();
        }

        throw new SQLException("No existe el oficio con id " + id);
    }

    public Oficio updateOficio(Oficio oficio) throws SQLException{
        Oficio o = findOficioById(oficio.getId_oficio());
        if (o == null) throw new SQLException("No existe el oficio");

        o.setNombre(oficio.getNombre());
        return o;
    }
}
