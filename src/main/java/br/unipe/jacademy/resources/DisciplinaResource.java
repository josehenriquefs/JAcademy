package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.DisciplinaEntity;
import br.unipe.jacademy.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class DisciplinaResource extends GenericResource<DisciplinaService, DisciplinaEntity> {

    @Autowired
    private DisciplinaService service;

    @GetMapping("/disciplinas")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("disciplina/adicionar", "disciplinas", service.getAll());
        return modelAndView.addAllObjects(novo());
    }


    @PostMapping("/disciplina/salvar")
    public ModelAndView salvar(DisciplinaEntity entity) {
        service.salvar(entity);
        return inicio();
    }

    @GetMapping("/disciplina/editar/{iddisciplina}")
    public ModelAndView editar(@PathVariable("iddisciplina") Long iddisciplina) {
        Optional<DisciplinaEntity> optional = service.getPorId(iddisciplina);
        ModelAndView modelAndView = view("disciplina/editar", "disciplina", optional.get());
        return modelAndView.addAllObjects(model("disciplinas", service.getAll()));
    }

    @GetMapping("/disciplina/excluir/{iddisciplina}")
    public ModelAndView excluir(@PathVariable("iddisciplina") Long iddisciplina) {
        service.excluirPorId(iddisciplina);
        return inicio();
    }

    private Map novo(){
        return model("disciplina", new DisciplinaEntity());
    }
}
