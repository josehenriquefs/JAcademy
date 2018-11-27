package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.ProfessorEntity;
import br.unipe.jacademy.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class ProfessorResource extends GenericResource<ProfessorService, ProfessorEntity> {

    @Autowired
    private ProfessorService service;

    @GetMapping("/professors")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("professor/adicionar", "professors", service.getAll());
        return modelAndView.addAllObjects(novo());
    }


    @PostMapping("/professor/salvar")
    public ModelAndView salvar(ProfessorEntity entity) {
        service.salvar(entity);
        return inicio();
    }

    @GetMapping("/professor/editar/{idprofessor}")
    public ModelAndView editar(@PathVariable("idprofessor") Long idprofessor) {
        Optional<ProfessorEntity> optional = service.getPorId(idprofessor);
        ModelAndView modelAndView = view("professor/editar", "professor", optional.get());
        return modelAndView.addAllObjects(model("professors", service.getAll()));
    }

    @GetMapping("/professor/excluir/{idprofessor}")
    public ModelAndView excluir(@PathVariable("idprofessor") Long idprofessor) {
        service.excluirPorId(idprofessor);
        return inicio();
    }

    private Map novo(){
        return model("professor", new ProfessorEntity());
    }
}
