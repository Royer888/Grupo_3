package com.example.Grupo3.Tablas_antes_de_Entity.organismo_fin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/organismos")

@Tag(
        name = "ORGANISMO_FIN",
        description = "CRUD de organismos financiadores del sistema VISIAF"
)

public class OrganismoFinController {

    private List<OrganismoFin> lista = new ArrayList<>();

    public OrganismoFinController() {

        lista.add(new OrganismoFin(2013, "111", "Tesoro", "TGN"));
        lista.add(new OrganismoFin(2013, "112", "Tesoro", "TGN-P"));
        lista.add(new OrganismoFin(2013, "113", "Tesoro", "TGN-CT"));
        lista.add(new OrganismoFin(2013, "114", "Recurso", "RECON"));
        lista.add(new OrganismoFin(2013, "115", "Donación", "DON-HIF"));
        lista.add(new OrganismoFin(2013, "116", "T.G.N.", "TGN-FCC"));
        lista.add(new OrganismoFin(2013, "117", "T.G.N.", "TGN-IEHI"));
        lista.add(new OrganismoFin(2013, "119", "T.G.N.", "TGN-IDH"));
        lista.add(new OrganismoFin(2013, "120", "T.G.N.", "TGN-IPJ"));
        lista.add(new OrganismoFin(2013, "129", "Otros", "OT-GOB"));
        lista.add(new OrganismoFin(2013, "210", "Rec.Esp", "RECESPIN"));
        lista.add(new OrganismoFin(2013, "220", "Regalías", "REG"));
        lista.add(new OrganismoFin(2013, "230", "Otros Rc", "OTPRO"));
        lista.add(new OrganismoFin(2013, "311", "Asociación", "ALADI"));
        lista.add(new OrganismoFin(2013, "312", "Centro I", "CIAT"));
        lista.add(new OrganismoFin(2013, "313", "Comisión", "CEPAL"));
        lista.add(new OrganismoFin(2013, "314", "Corporación", "CAF"));
        lista.add(new OrganismoFin(2013, "315", "Fondo", "FAR"));
        lista.add(new OrganismoFin(2013, "316", "Instituto", "IICA"));
        lista.add(new OrganismoFin(2013, "317", "Comunidad", "CAN"));
        lista.add(new OrganismoFin(2013, "318", "Organización", "OEA"));
        lista.add(new OrganismoFin(2013, "319", "Organización", "OLADE"));
    }

    @Operation(
            summary = "Obtener todos los organismos financiadores",
            description = "Devuelve la lista completa de organismos registrados"
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    })

    @GetMapping
    public List<OrganismoFin> obtenerOrganismos() {
        return lista;
    }

    @Operation(
            summary = "Registrar un nuevo organismo financiador",
            description = "Permite agregar un nuevo organismo a la lista"
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Organismo agregado correctamente")
    })

    @PostMapping
    public OrganismoFin agregarOrganismo(@RequestBody OrganismoFin organismo) {

        lista.add(organismo);

        return organismo;
    }

    @Operation(
            summary = "Actualizar un organismo financiador",
            description = "Actualiza los datos de un organismo utilizando el código OF"
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Organismo actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Organismo no encontrado")
    })

    @PutMapping("/{of}")
    public String actualizarOrganismo(

            @Parameter(description = "Código OF del organismo")
            @PathVariable String of,

            @RequestBody OrganismoFin nuevoOrganismo
    ) {

        for (OrganismoFin organismo : lista) {

            if (organismo.getOf().equals(of)) {

                organismo.setGestion(nuevoOrganismo.getGestion());
                organismo.setDes(nuevoOrganismo.getDes());
                organismo.setSigla(nuevoOrganismo.getSigla());

                return "Organismo actualizado correctamente";
            }
        }

        return "Organismo no encontrado";
    }

    @Operation(
            summary = "Eliminar un organismo financiador",
            description = "Elimina un organismo utilizando el código OF"
    )

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Organismo eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Organismo no encontrado")
    })

    @DeleteMapping("/{of}")
    public String eliminarOrganismo(

            @Parameter(description = "Código OF del organismo")
            @PathVariable String of
    ) {

        for (OrganismoFin organismo : lista) {

            if (organismo.getOf().equals(of)) {

                lista.remove(organismo);

                return "Organismo eliminado correctamente";
            }
        }

        return "Organismo no encontrado";
    }
}