package com.example.Grupo3.service;

import com.example.Grupo3.Entity.OrganismoFinEntity;
import com.example.Grupo3.repository.OrganismoFinRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganismoFinService {

    @Autowired
    private OrganismoFinRepository organismoFinRepository;

    @PostConstruct
    public void init() {
        if (organismoFinRepository.count() == 0) {
            organismoFinRepository.save(new OrganismoFinEntity(2013, "111", "Tesoro", "TGN"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "112", "Tesoro", "TGN-P"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "113", "Tesoro", "TGN-CT"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "114", "Recurso", "RECON"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "115", "Donación", "DON-HIF"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "116", "T.G.N.", "TGN-FCC"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "117", "T.G.N.", "TGN-IEHI"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "119", "T.G.N.", "TGN-IDH"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "120", "T.G.N.", "TGN-IPJ"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "129", "Otros", "OT-GOB"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "210", "Rec.Esp", "RECESPIN"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "220", "Regalías", "REG"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "230", "Otros Rc", "OTPRO"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "311", "Asociación", "ALADI"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "312", "Centro I", "CIAT"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "313", "Comisión", "CEPAL"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "314", "Corporación", "CAF"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "315", "Fondo", "FAR"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "316", "Instituto", "IICA"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "317", "Comunidad", "CAN"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "318", "Organización", "OEA"));
            organismoFinRepository.save(new OrganismoFinEntity(2013, "319", "Organización", "OLADE"));
        }
    }

    public List<OrganismoFinEntity> getAll() {
        return organismoFinRepository.findAll();
    }

    public Optional<OrganismoFinEntity> getById(String of) {
        return organismoFinRepository.findById(of);
    }

    public OrganismoFinEntity save(OrganismoFinEntity organismo) {
        return organismoFinRepository.save(organismo);
    }

    public OrganismoFinEntity update(String of, OrganismoFinEntity organismo) {
        organismo.setOf(of);
        return organismoFinRepository.save(organismo);
    }

    public void delete(String of) {
        organismoFinRepository.deleteById(of);
    }
}