package com.integrador.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.integrador.service.MaterialService;
import com.integrador.web.rest.util.HeaderUtil;
import com.integrador.service.dto.MaterialDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Material.
 */
@RestController
@RequestMapping("/api")
public class MaterialResource {

    private final Logger log = LoggerFactory.getLogger(MaterialResource.class);

    private static final String ENTITY_NAME = "material";

    private final MaterialService materialService;

    public MaterialResource(MaterialService materialService) {
        this.materialService = materialService;
    }

    /**
     * POST  /materials : Create a new material.
     *
     * @param materialDTO the materialDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new materialDTO, or with status 400 (Bad Request) if the material has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/materials")
    @Timed
    public ResponseEntity<MaterialDTO> createMaterial(@Valid @RequestBody MaterialDTO materialDTO) throws URISyntaxException {
        log.debug("REST request to save Material : {}", materialDTO);
        if (materialDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new material cannot already have an ID")).body(null);
        }
        MaterialDTO result = materialService.save(materialDTO);
        return ResponseEntity.created(new URI("/api/materials/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /materials : Updates an existing material.
     *
     * @param materialDTO the materialDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated materialDTO,
     * or with status 400 (Bad Request) if the materialDTO is not valid,
     * or with status 500 (Internal Server Error) if the materialDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/materials")
    @Timed
    public ResponseEntity<MaterialDTO> updateMaterial(@Valid @RequestBody MaterialDTO materialDTO) throws URISyntaxException {
        log.debug("REST request to update Material : {}", materialDTO);
        if (materialDTO.getId() == null) {
            return createMaterial(materialDTO);
        }
        MaterialDTO result = materialService.save(materialDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, materialDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /materials : get all the materials.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of materials in body
     */
    @GetMapping("/materials")
    @Timed
    public List<MaterialDTO> getAllMaterials() {
        log.debug("REST request to get all Materials");
        return materialService.findAll();
        }

    /**
     * GET  /materials/:id : get the "id" material.
     *
     * @param id the id of the materialDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the materialDTO, or with status 404 (Not Found)
     */
    @GetMapping("/materials/{id}")
    @Timed
    public ResponseEntity<MaterialDTO> getMaterial(@PathVariable Long id) {
        log.debug("REST request to get Material : {}", id);
        MaterialDTO materialDTO = materialService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(materialDTO));
    }

    /**
     * DELETE  /materials/:id : delete the "id" material.
     *
     * @param id the id of the materialDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/materials/{id}")
    @Timed
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        log.debug("REST request to delete Material : {}", id);
        materialService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
