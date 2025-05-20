package application.service;

import application.model.Modulo;
import application.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo> listarTodos() {
        return moduloRepository.findAll();
    }

    public Optional<Modulo> buscarPorId(Long id) {
        return moduloRepository.findById(id);
    }

    public Modulo salvar(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    public void deletar(Long id) {
        moduloRepository.deleteById(id);
    }
}
