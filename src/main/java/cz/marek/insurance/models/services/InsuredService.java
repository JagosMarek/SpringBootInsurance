package cz.marek.insurance.models.services;

import cz.marek.insurance.models.dto.InsuredDTO;

import java.util.List;

public interface InsuredService {

    void create(InsuredDTO insuredDTO);

    List<InsuredDTO> getAll();

    InsuredDTO getById(long insuredId);

    void edit(InsuredDTO insuredDTO);

    void remove(long articleId);
}
