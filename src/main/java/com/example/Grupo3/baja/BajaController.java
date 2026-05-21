package com.example.Grupo3.baja;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/baja")

public class BajaController {

    private List<Baja> listaBajas = new ArrayList<>();
    private int nextId = 10;

    public BajaController() {
        listaBajas.add(new Baja(1, "Disposición definitiva de bienes"));
        listaBajas.add(new Baja(2, "Hurto, robo o perdida fortuita"));
        listaBajas.add(new Baja(3, "Mermas"));
        listaBajas.add(new Baja(4, "Vencimiento, descomposiciones, alt"));
        listaBajas.add(new Baja(5, "Inutilización"));
        listaBajas.add(new Baja(6, "Obsolescencia"));
        listaBajas.add(new Baja(7, "Desmantelamiento total o parcial de"));
        listaBajas.add(new Baja(8, "Siniestros"));
        listaBajas.add(new Baja(9, "ERROR DE TRANSCRIPCION"));
        nextId = 10;
    }

    @GetMapping
    public List<Baja> getAll() {
        return listaBajas;
    }

    @GetMapping("/{codbaja}")
    public Baja getById(@PathVariable int codbaja) {
        for (Baja b : listaBajas) {
            if (b.getCodbaja() == codbaja) {
                return b;
            }
        }
        return null;
    }

    @PostMapping
    public Baja create(@RequestBody Baja baja) {
        baja.setCodbaja(nextId++);
        listaBajas.add(baja);
        return baja;
    }

    @PutMapping("/{codbaja}")
    public String update(@PathVariable int codbaja, @RequestBody Baja nuevaBaja) {
        for (int i = 0; i < listaBajas.size(); i++) {
            if (listaBajas.get(i).getCodbaja() == codbaja) {
                nuevaBaja.setCodbaja(codbaja);
                listaBajas.set(i, nuevaBaja);
                return "Motivo de baja actualizado";
            }
        }
        return "No encontrado";
    }

    @DeleteMapping("/{codbaja}")
    public String delete(@PathVariable int codbaja) {
        for (int i = 0; i < listaBajas.size(); i++) {
            if (listaBajas.get(i).getCodbaja() == codbaja) {
                listaBajas.remove(i);
                return "Motivo de baja eliminado";
            }
        }
        return "No encontrado";
    }
}

