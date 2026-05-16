package com.example.Grupo3.test_ent;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
 * Controlador REST para la tabla TEST_ENT
 * Aquí se implementa el CRUD completo:
 * GET, POST, PUT y DELETE
 */

@RestController
@RequestMapping("/test-ent")
@Tag(name = "TEST_ENT", description = "CRUD de la tabla Estado Entidad")
public class TestEntController {

    // Lista temporal en memoria
    private List<TestEnt> lista = new ArrayList<>();

    /*
     * Constructor:
     * Aquí cargamos los datos iniciales
     */
    public TestEntController() {

        lista.add(new TestEnt(2012,1,0,0,0,0,
                "ADMINISTRACIÓN PÚBLICA","APUB","N"));

        lista.add(new TestEnt(2012,1,1,0,0,0,
                "ORGANOS DEL ESTADO PLURINACIONAL","OEP","N"));

        lista.add(new TestEnt(2012,1,1,1,0,0,
                "Organo Legislativo","OL","S"));

        lista.add(new TestEnt(2012,1,1,1,2,0,
                "Organo Ejecutivo","OE","S"));

        lista.add(new TestEnt(2012,1,1,1,3,0,
                "Organo Judicial y Tribunal Constitucional","OJ - TC","S"));

        lista.add(new TestEnt(2012,1,1,1,4,0,
                "Organo Electoral","OEL","S"));

        lista.add(new TestEnt(2012,1,1,1,5,0,
                "Instituciones de Control y Defensa","ECDE","S"));

        lista.add(new TestEnt(2012,1,1,1,6,0,
                "Instituciones Públicas Descentralizadas","INSPUBDES","S"));

        lista.add(new TestEnt(2012,1,1,1,7,0,
                "Universidades Públicas","UNIV-PUB","S"));

        lista.add(new TestEnt(2012,1,1,1,8,0,
                "Instituciones de Seguridad Social","ISS","S"));

        lista.add(new TestEnt(2012,1,1,1,9,0,
                "EMPRESAS PÚBLICAS","EMP-PUB","N"));

        lista.add(new TestEnt(2012,1,1,1,10,0,
                "Empresas Nacionales","EMP-NAL","S"));

        lista.add(new TestEnt(2012,1,1,1,11,0,
                "Empresas Regionales","EMP-REG","S"));

        lista.add(new TestEnt(2012,1,1,1,12,0,
                "Empresas Municipales","EMP-MUN","S"));

        lista.add(new TestEnt(2012,1,1,1,13,0,
                "ADMINISTRACIÓN TERRITORIAL","ADM-TERR","N"));

        lista.add(new TestEnt(2012,1,1,1,14,0,
                "Gobiernos Autónomos Departamentales","GAD","S"));

        lista.add(new TestEnt(2012,1,1,1,15,0,
                "Administración Regional","ADM-REG","S"));

        lista.add(new TestEnt(2012,1,1,1,16,0,
                "Gobiernos Autónomos Municipales","GAM","S"));

        lista.add(new TestEnt(2012,1,1,1,17,0,
                "Administración Indígena Originaria Campesina","AID-IOC","S"));

        lista.add(new TestEnt(2012,1,1,1,18,0,
                "ADMINISTRACIÓN PÚBLICA FINANCIERA","APF","N"));

        lista.add(new TestEnt(2012,1,1,1,19,0,
                "Instituciones Financieras no Bancarias","IFNB","S"));
    }

    /*
     * GET
     * Obtiene toda la lista
     */
    @GetMapping
    @Operation(summary = "Obtener todos los registros")
    public List<TestEnt> obtenerEntidades() {
        return lista;
    }

    /*
     * POST
     * Agrega un nuevo registro
     */
    @PostMapping
    @Operation(summary = "Agregar un nuevo registro")
    public TestEnt agregarEntidad(@RequestBody TestEnt entidad) {

        lista.add(entidad);

        return entidad;
    }

    /*
     * PUT
     * Actualiza un registro usando la sigla
     */
    @PutMapping("/{siglaestru}")
    @Operation(summary = "Actualizar un registro por sigla")
    public String actualizarEntidad(
            @PathVariable String siglaestru,
            @RequestBody TestEnt nuevaEntidad) {

        for (TestEnt entidad : lista) {

            if (entidad.getSiglaestru().equals(siglaestru)) {

                entidad.setGestion(nuevaEntidad.getGestion());
                entidad.setSector_ent(nuevaEntidad.getSector_ent());
                entidad.setSubsec_ent(nuevaEntidad.getSubsec_ent());
                entidad.setArea_ent(nuevaEntidad.getArea_ent());
                entidad.setSubareaent(nuevaEntidad.getSubareaent());
                entidad.setNivel_inst(nuevaEntidad.getNivel_inst());
                entidad.setDes_estruct(nuevaEntidad.getDes_estruct());
                entidad.setApropiable(nuevaEntidad.getApropiable());

                return "Entidad actualizada correctamente";
            }
        }

        return "Entidad no encontrada";
    }

    /*
     * DELETE
     * Elimina un registro usando la sigla
     */
    @DeleteMapping("/{siglaestru}")
    @Operation(summary = "Eliminar un registro por sigla")
    public String eliminarEntidad(@PathVariable String siglaestru) {

        for (TestEnt entidad : lista) {

            if (entidad.getSiglaestru().equals(siglaestru)) {

                lista.remove(entidad);

                return "Entidad eliminada correctamente";
            }
        }

        return "Entidad no encontrada";
    }
}