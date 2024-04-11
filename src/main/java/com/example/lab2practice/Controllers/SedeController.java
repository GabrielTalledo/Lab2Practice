package com.example.lab2practice.Controllers;

import com.example.lab2practice.Entities.Sede;
import com.example.lab2practice.Repositories.SedeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/sede")
public class SedeController {

    // Repositorio de Sede
    final SedeRepository sedeRepository;
    SedeController(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    // Métodos
    @GetMapping(value={"","/"})
    public String listarSedes(Model model){
        List<Sede> listaSedes = sedeRepository.findAll();
        model.addAttribute("listaSedes",listaSedes);
        return "Sede_Lista";
    }

    @GetMapping(value={"/nuevo"})
    public String crearSede(Model model){
        return "Sede_Crear";
    }

    @PostMapping(value={"/guardar"})
    public String guardarSede(Sede sede){
        sedeRepository.save(sede);
        return "redirect:/sede";
    }

    @GetMapping(value={"/editar"})
    public String editarSede(Model model,
                             @RequestParam("id") Integer id){

        Optional<Sede> optSede = sedeRepository.findById(id);
        if(optSede.isPresent()){
            Sede sede = optSede.get();
            model.addAttribute("sede", sede);
            return "Sede_Editar";
        }
        return "redirect:/sede";

    }

    @GetMapping(value={"/borrar"})
    public String eliminarSede(@RequestParam("id") Integer id){

        Optional<Sede> optSede = sedeRepository.findById(id);
        if(optSede.isPresent()){
            sedeRepository.deleteById(optSede.get().getIdSede());
        }
        return "redirect:/sede";

    }
}
