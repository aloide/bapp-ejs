package TrabajoPractico.MicroServicios.dominio.repositorio;

import TrabajoPractico.MicroServicios.dominio.modelo.Marca;
import TrabajoPractico.MicroServicios.dominio.repositorio.MarcaRepository;
import TrabajoPractico.MicroServicios.infraestructura.dao.MarcaDao;

import java.util.List;

public class MarcaRepositoryImpl implements MarcaRepository {

    private MarcaDao dao;

    public MarcaRepositoryImpl (MarcaDao dao){
        this.dao = dao;
    }

    @Override
    public List<Marca> getAll() {
        return dao.findAll();
    }
}
