package com.example.Grupo3.config;

import com.example.Grupo3.Entity.ActivoEntity;
import com.example.Grupo3.Entity.BajaEntity;
import com.example.Grupo3.Entity.DepartamentoEntity;
import com.example.Grupo3.Entity.EntidadEntity;
import com.example.Grupo3.Entity.EstadoEntity;
import com.example.Grupo3.Entity.MesEntity;
import com.example.Grupo3.Entity.ObjetoGastoEntity;
import com.example.Grupo3.Entity.OrganismoFinEntity;
import com.example.Grupo3.Entity.UnidadAdministrativaEntity;
import com.example.Grupo3.Entity.UsuarioEntity;
import com.example.Grupo3.repository.ActivoRepository;
import com.example.Grupo3.repository.BajaRepository;
import com.example.Grupo3.repository.DepartamentoRepository;
import com.example.Grupo3.repository.EntidadRepository;
import com.example.Grupo3.repository.EstadoRepository;
import com.example.Grupo3.repository.MesRepository;
import com.example.Grupo3.repository.ObjetoGastoRepository;
import com.example.Grupo3.repository.OrganismoFinRepository;
import com.example.Grupo3.repository.UnidadAdministrativaRepository;
import com.example.Grupo3.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final MesRepository mesRepository;
    private final DepartamentoRepository departamentoRepository;
    private final EstadoRepository estadoRepository;
    private final BajaRepository bajaRepository;
    private final OrganismoFinRepository organismoFinRepository;
    private final EntidadRepository entidadRepository;
    private final UnidadAdministrativaRepository unidadAdministrativaRepository;
    private final ActivoRepository activoRepository;
    private final ObjetoGastoRepository objetoGastoRepository;

    public DataInitializer(UsuarioRepository usuarioRepository,
                           MesRepository mesRepository,
                           DepartamentoRepository departamentoRepository,
                           EstadoRepository estadoRepository,
                           BajaRepository bajaRepository,
                           OrganismoFinRepository organismoFinRepository,
                           EntidadRepository entidadRepository,
                           UnidadAdministrativaRepository unidadAdministrativaRepository,
                           ActivoRepository activoRepository,
                           ObjetoGastoRepository objetoGastoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.mesRepository = mesRepository;
        this.departamentoRepository = departamentoRepository;
        this.estadoRepository = estadoRepository;
        this.bajaRepository = bajaRepository;
        this.organismoFinRepository = organismoFinRepository;
        this.entidadRepository = entidadRepository;
        this.unidadAdministrativaRepository = unidadAdministrativaRepository;
        this.activoRepository = activoRepository;
        this.objetoGastoRepository = objetoGastoRepository;
    }

    @Override
    public void run(String... args) {
        cargarUsuarios();
        cargarMeses();
        cargarDepartamentos();
        cargarEstados();
        cargarBajas();
        cargarOrganismosFin();
        cargarEntidades();
        cargarUnidadesAdministrativas();
        cargarActivos();
        cargarObjetosGasto();
    }

    private void cargarUsuarios() {
        if (usuarioRepository.count() == 0) {
            usuarioRepository.save(new UsuarioEntity(null, "Cristian", "Paco", "admin", "1234"));
        }
    }

    private void cargarMeses() {
        if (mesRepository.count() == 0) {
            mesRepository.save(new MesEntity(null, "Enero"));
            mesRepository.save(new MesEntity(null, "Febrero"));
            mesRepository.save(new MesEntity(null, "Marzo"));
            mesRepository.save(new MesEntity(null, "Abril"));
            mesRepository.save(new MesEntity(null, "Mayo"));
            mesRepository.save(new MesEntity(null, "Junio"));
            mesRepository.save(new MesEntity(null, "Julio"));
            mesRepository.save(new MesEntity(null, "Agosto"));
            mesRepository.save(new MesEntity(null, "Septiembre"));
            mesRepository.save(new MesEntity(null, "Octubre"));
            mesRepository.save(new MesEntity(null, "Noviembre"));
            mesRepository.save(new MesEntity(null, "Diciembre"));
        }
    }

    private void cargarDepartamentos() {
        if (departamentoRepository.count() == 0) {
            departamentoRepository.save(new DepartamentoEntity(1, "Chuquisaca", "CHQ"));
            departamentoRepository.save(new DepartamentoEntity(2, "La Paz", "LPZ"));
            departamentoRepository.save(new DepartamentoEntity(3, "Cochabamba", "CBB"));
            departamentoRepository.save(new DepartamentoEntity(4, "Oruro", "ORU"));
            departamentoRepository.save(new DepartamentoEntity(5, "Potos\u00ed", "PTS"));
            departamentoRepository.save(new DepartamentoEntity(6, "Tarija", "TJA"));
            departamentoRepository.save(new DepartamentoEntity(7, "Santa Cruz", "SCZ"));
            departamentoRepository.save(new DepartamentoEntity(8, "Beni", "BEN"));
            departamentoRepository.save(new DepartamentoEntity(9, "Pando", "PAN"));
        }
    }

    private void cargarEstados() {
        if (estadoRepository.count() == 0) {
            estadoRepository.save(new EstadoEntity(1, "Bueno"));
            estadoRepository.save(new EstadoEntity(2, "Regular"));
            estadoRepository.save(new EstadoEntity(3, "Malo"));
            estadoRepository.save(new EstadoEntity(4, "En reparaci\u00f3n"));
            estadoRepository.save(new EstadoEntity(5, "De baja"));
        }
    }

    private void cargarBajas() {
        if (bajaRepository.count() == 0) {
            bajaRepository.save(new BajaEntity(null, "Robo"));
            bajaRepository.save(new BajaEntity(null, "P\u00e9rdida"));
            bajaRepository.save(new BajaEntity(null, "Deterioro"));
            bajaRepository.save(new BajaEntity(null, "Donaci\u00f3n"));
            bajaRepository.save(new BajaEntity(null, "Venta"));
            bajaRepository.save(new BajaEntity(null, "Error de transcripci\u00f3n"));
        }
    }

    private void cargarOrganismosFin() {
        if (organismoFinRepository.count() == 0) {
            organismoFinRepository.save(new OrganismoFinEntity(2026, "111", "Tesoro General de la Naci\u00f3n", "TGN"));
            organismoFinRepository.save(new OrganismoFinEntity(2026, "112", "Recursos Propios", "RP"));
            organismoFinRepository.save(new OrganismoFinEntity(2026, "113", "Donaci\u00f3n Externa", "DON"));
            organismoFinRepository.save(new OrganismoFinEntity(2026, "114", "Banco Interamericano de Desarrollo", "BID"));
            organismoFinRepository.save(new OrganismoFinEntity(2026, "115", "Corporaci\u00f3n Andina de Fomento", "CAF"));
        }
    }

    private void cargarEntidades() {
        if (entidadRepository.count() == 0) {
            entidadRepository.save(new EntidadEntity(
                    2026,
                    1,
                    1,
                    1,
                    1,
                    0,
                    "Universidad Aut\u00f3noma Tom\u00e1s Fr\u00edas",
                    "UATF",
                    "S"
            ));
        }
    }

    private void cargarUnidadesAdministrativas() {
        if (unidadAdministrativaRepository.count() == 0) {
            unidadAdministrativaRepository.save(new UnidadAdministrativaEntity(
                    null,
                    "UATF",
                    "ING",
                    "Facultad de Ingenier\u00eda",
                    "Potos\u00ed",
                    "ACTIVO"
            ));
        }
    }

    private void cargarActivos() {
        if (activoRepository.count() == 0) {
            activoRepository.save(new ActivoEntity(
                    null,
                    "AF-001",
                    "Computadora Dell Optiplex",
                    "Dell",
                    "Optiplex",
                    "SN-12345",
                    8500.0,
                    LocalDate.of(2026, 6, 26),
                    "Potos\u00ed",
                    "Bueno",
                    "TGN",
                    "Facultad de Ingenier\u00eda",
                    "UATF",
                    "admin"
            ));
        }
    }

    private void cargarObjetosGasto() {
        if (objetoGastoRepository.count() == 0) {
            objetoGastoRepository.save(new ObjetoGastoEntity("31120", "Gastos por alimentaci\u00f3n", 2026, "ACTIVO"));
            objetoGastoRepository.save(new ObjetoGastoEntity("31130", "Gastos por hospedaje", 2026, "ACTIVO"));
            objetoGastoRepository.save(new ObjetoGastoEntity("34110", "Combustibles y lubricantes", 2026, "ACTIVO"));
            objetoGastoRepository.save(new ObjetoGastoEntity("34200", "Productos qu\u00edmicos y farmac\u00e9uticos", 2026, "ACTIVO"));
            objetoGastoRepository.save(new ObjetoGastoEntity("39700", "\u00datiles de escritorio y oficina", 2026, "ACTIVO"));
            objetoGastoRepository.save(new ObjetoGastoEntity("43110", "Equipo de oficina y muebles", 2026, "ACTIVO"));
            objetoGastoRepository.save(new ObjetoGastoEntity("43400", "Equipo de computaci\u00f3n", 2026, "ACTIVO"));
            objetoGastoRepository.save(new ObjetoGastoEntity("43500", "Equipo de comunicaci\u00f3n", 2026, "ACTIVO"));
        }
    }
}
