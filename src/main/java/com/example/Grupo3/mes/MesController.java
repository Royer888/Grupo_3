package com.example.Grupo3.mes;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/mes")
public class MesController {

    private List<Mes> listaMeses = new ArrayList<>();

    public MesController() {
        listaMeses.add(new Mes(1, "ENERO"));
        listaMeses.add(new Mes(2, "FEBRERO"));
        listaMeses.add(new Mes(3, "MARZO"));
        listaMeses.add(new Mes(4, "ABRIL"));
        listaMeses.add(new Mes(5, "MAYO"));
        listaMeses.add(new Mes(6, "JUNIO"));
        listaMeses.add(new Mes(7, "JULIO"));
        listaMeses.add(new Mes(8, "AGOSTO"));
        listaMeses.add(new Mes(9, "SEPTIEMBRE"));
        listaMeses.add(new Mes(10, "OCTUBRE"));
        listaMeses.add(new Mes(11, "NOVIEMBRE"));
        listaMeses.add(new Mes(12, "DICIEMBRE"));
    }

    @GetMapping
    public List<Mes> getAll() {
        return listaMeses;
    }

    @GetMapping("/{mes}")
    public Mes getById(@PathVariable int mes) {
        for (Mes m : listaMeses) {
            if (m.getMes() == mes) return m;
        }
        return null;
    }

    @PostMapping
    public Mes create(@RequestBody Mes nuevoMes) {
        listaMeses.add(nuevoMes);
        return nuevoMes;
    }

    @PutMapping("/{mes}")
    public String update(@PathVariable int mes, @RequestBody Mes mesActualizado) {
        for (int i = 0; i < listaMeses.size(); i++) {
            if (listaMeses.get(i).getMes() == mes) {
                listaMeses.set(i, mesActualizado);
                return "Mes actualizado correctamente";
            }
        }
        return "Mes no encontrado";
    }

    @DeleteMapping("/{mes}")
    public String delete(@PathVariable int mes) {
        for (int i = 0; i < listaMeses.size(); i++) {
            if (listaMeses.get(i).getMes() == mes) {
                listaMeses.remove(i);
                return "Mes eliminado correctamente";
            }
        }
        return "Mes no encontrado";
    }
}