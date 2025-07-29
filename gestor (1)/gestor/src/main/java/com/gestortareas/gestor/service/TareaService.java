package com.gestortareas.gestor.service;

import com.gestortareas.gestor.model.Tarea;
import com.gestortareas.gestor.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> obtenerTodasLasTareas(){
        return tareaRepository.findAll();
    }

    public Tarea guardarTarea( Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> buscarTareaPorId(Long id) {
        return tareaRepository.findById(id);
    }

    public Optional<Tarea> actualizarTarea(Long id, Tarea tareaActualizada) {
        return tareaRepository.findById(id).map(tareaExistente -> {
            tareaExistente.setTitulo(tareaActualizada.getTitulo());
            tareaExistente.setDescripcion(tareaActualizada.getDescripcion());
            return  tareaRepository.save(tareaExistente);
        });
    }

    public boolean eliminarTarea(Long id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
