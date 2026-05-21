package com.example.Grupo3.departamentos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamentos")

@Tag(
        name = "DEPARTAMENTOS",
        description = "CRUD de departamentos de Bolivia del sistema VISIAF"
)

@CrossOrigin("*")
public class DepartamentoController {

    private List<Departamento> lista = new ArrayList<>();

    // Datos iniciales obligatorios
    public DepartamentoController() {

        lista.add(new Departamento(1, "CHUQUISACA", "CHQ"));
        lista.add(new Departamento(2, "LA PAZ", "LPZ"));
        lista.add(new Departamento(3, "COCHABAMBA", "CBB"));
        lista.add(new Departamento(4, "ORURO", "ORU"));
        lista.add(new Departamento(5, "POTOSI", "PTS"));
        lista.add(new Departamento(6, "TARIJA", "TAR"));
        lista.add(new Departamento(7, "SANTA CRUZ", "SCZ"));
        lista.add(new Departamento(8, "BENI", "BEN"));
        lista.add(new Departamento(9, "PANDO", "PAN"));
        lista.add(new Departamento(10, "OTROS", "OTR"));
    }

    @Operation(
            summary = "Obtener todos los departamentos",
            description = "Devuelve la lista completa de departamentos"
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })

    @GetMapping
    public List<Departamento> obtenerDepartamentos() {

        return lista;
    }

    @Operation(
            summary = "Registrar un nuevo departamento",
            description = "Permite agregar un departamento"
    )

    @PostMapping
    public Departamento agregarDepartamento(
            @RequestBody Departamento departamento
    ) {

        lista.add(departamento);

        return departamento;
    }

    @Operation(
            summary = "Actualizar un departamento",
            description = "Actualiza un departamento usando el código"
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departamento actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })

    @PutMapping("/{codigo}")
    public String actualizarDepartamento(

            @Parameter(description = "Código del departamento")
            @PathVariable int codigo,

            @RequestBody Departamento nuevoDepartamento
    ) {

        for (Departamento departamento : lista) {

            if (departamento.getCodigo() == codigo) {

                departamento.setDesc(
                        nuevoDepartamento.getDesc()
                );

                departamento.setSigla(
                        nuevoDepartamento.getSigla()
                );

                return "Departamento actualizado correctamente";
            }
        }

        return "Departamento no encontrado";
    }

    @Operation(
            summary = "Eliminar un departamento",
            description = "Elimina un departamento usando el código"
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departamento eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })

    @DeleteMapping("/{codigo}")
    public String eliminarDepartamento(

            @Parameter(description = "Código del departamento")
            @PathVariable int codigo
    ) {

        for (Departamento departamento : lista) {

            if (departamento.getCodigo() == codigo) {

                lista.remove(departamento);

                return "Departamento eliminado correctamente";
            }
        }

        return "Departamento no encontrado";
    }
}