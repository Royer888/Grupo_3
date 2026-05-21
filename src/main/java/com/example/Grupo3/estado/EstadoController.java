package com.example.Grupo3.estado;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estados")

@Tag(
        name = "ESTADO",
        description = "CRUD de estados físicos de bienes del sistema VISIAF"
)

public class EstadoController {

    private List<Estado> lista = new ArrayList<>();

    public EstadoController() {

        lista.add(new Estado(1, "BUENO"));
        lista.add(new Estado(2, "REGULAR"));
        lista.add(new Estado(3, "MALO"));
        lista.add(new Estado(4, "EXCELENTE"));
    }

    @Operation(
            summary = "Obtener todos los estados",
            description = "Devuelve la lista completa de estados registrados"
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })

    @GetMapping
    public List<Estado> obtenerEstados() {
        return lista;
    }

    @Operation(
            summary = "Registrar un nuevo estado",
            description = "Permite agregar un nuevo estado"
    )

    @PostMapping
    public Estado agregarEstado(@RequestBody Estado estado) {

        lista.add(estado);

        return estado;
    }

    @Operation(
            summary = "Actualizar un estado",
            description = "Actualiza un estado usando el código"
    )

    @PutMapping("/{codestado}")
    public String actualizarEstado(

            @Parameter(description = "Código del estado")
            @PathVariable int codestado,

            @RequestBody Estado nuevoEstado
    ) {

        for (Estado estado : lista) {

            if (estado.getCodestado() == codestado) {

                estado.setNomestado(
                        nuevoEstado.getNomestado()
                );

                return "Estado actualizado correctamente";
            }
        }

        return "Estado no encontrado";
    }

    @Operation(
            summary = "Eliminar un estado",
            description = "Elimina un estado usando el código"
    )

    @DeleteMapping("/{codestado}")
    public String eliminarEstado(

            @Parameter(description = "Código del estado")
            @PathVariable int codestado
    ) {

        for (Estado estado : lista) {

            if (estado.getCodestado() == codestado) {

                lista.remove(estado);

                return "Estado eliminado correctamente";
            }
        }

        return "Estado no encontrado";
    }
}