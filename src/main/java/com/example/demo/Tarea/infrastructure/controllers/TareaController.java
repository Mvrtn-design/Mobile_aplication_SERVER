package com.example.demo.Tarea.infrastructure.controllers;

import com.example.demo.Tarea.application.services.TareaService;
import com.example.demo.Tarea.domain.models.InformacionAdicional;
import com.example.demo.Tarea.domain.models.Tarea;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("miapi/tareas")
@CrossOrigin
public class TareaController {
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea creada = tareaService.crearTarea(tarea);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarea> obtenerTarea(@PathVariable Long idTareita) {
        return tareaService.getTareaById(idTareita).map((tareaAux) -> new ResponseEntity<>(tareaAux, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTodasLasTareas(){
        ResponseEntity<List<Tarea>> lista = new ResponseEntity<>( tareaService.getAllTarea(),HttpStatus.OK);
        System.out.println("Tareas: "+lista);
        return lista;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea tareaNueva, @PathVariable Long idTareaAActualizar){
      return tareaService.actualizarTarea(tareaNueva,idTareaAActualizar).map((tareaAux) -> new ResponseEntity <>(tareaAux,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_MODIFIED));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarTarea(@PathVariable Long idTareaPaFuera){
       if( tareaService.eliminarTarea(idTareaPaFuera)){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("adicional/{idTarea}")
    public ResponseEntity<InformacionAdicional> obtenerInformacionAdicional(@PathVariable Long idTarea){

        InformacionAdicional miInfo = tareaService.getInformacionAdicional(idTarea);
        System.out.println("La informacion es: "+miInfo);
        return new ResponseEntity<>(miInfo, HttpStatus.OK);
    }
}
