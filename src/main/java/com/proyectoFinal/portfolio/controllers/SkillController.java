package com.proyectoFinal.portfolio.controllers;

import com.proyectoFinal.portfolio.models.SkillModel;
import com.proyectoFinal.portfolio.services.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("/all")
    public List<SkillModel> getAllSkills() {
        return skillService.getSkill();
    }
    
     @GetMapping("/traerporid/{id}")
    public ResponseEntity<SkillModel> findSkill(@PathVariable("id") Long id) {
        SkillModel skill = skillService.getSkillById(id);
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @GetMapping("/query")
    //ATENCIÓN...acá se tuvo q crear método en Repository para luego llamarlo en el Service y luego poder llamarlo acá.
    public List<SkillModel> getSkillByTipo(@RequestParam("tipo") String tipo) {
        return skillService.getSkillByTipo(tipo);
    }
    
    @PostMapping("/crear")
    public ResponseEntity createSkill(@RequestBody SkillModel skill){
        skillService.saveSkill(skill);
        return ResponseEntity.ok().body(skill);
    }
   
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarSkill(@PathVariable("id") Long id) {
        skillService.deleteSkill(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editSkill(@PathVariable("id") Long id, @RequestBody SkillModel skill) {
        SkillModel sk = skillService.findSkill(id);

        sk.setTipo(skill.getTipo());
        sk.setNombre(skill.getNombre());
        sk.setPorcentaje(skill.getPorcentaje());

        skillService.saveSkill(sk);
        return new ResponseEntity(HttpStatus.OK);
    }
    /*@PutMapping("/editar/{id}")
    public SkillModel editSkill(@PathVariable Long id,
                                    @RequestParam("tipo") String nuevotipo,
                                    @RequestParam("nombre") String nuevonombre,
                                    @RequestParam("porcentaje") int nuevoporcentaje){
        SkillModel skill = skillService.findSkill(id);
        
        skill.setTipo(nuevotipo);
        skill.setNombre(nuevonombre);
        skill.setPorcentaje(nuevoporcentaje);

        skillService.saveSkill(skill);
        return skill;
    }*/
    
    /*@GetMapping("/{id}")
    public SkillModel getSkillById(@PathVariable("id") Long id) {
        return skillService.getSkillById(id);
    }*/
}
