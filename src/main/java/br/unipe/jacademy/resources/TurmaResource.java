package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.TurmaEntity;
import br.unipe.jacademy.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class TurmaResource extends GenericResource<TurmaService, TurmaEntity> {

    @Autowired
    private TurmaService service;

    @GetMapping("/turmas")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("turma/adicionar", "turmas", service.getAll());
        return modelAndView.addAllObjects(novo());
    }


    @PostMapping("/turma/salvar")
    public ModelAndView salvar(TurmaEntity entity) {
        service.salvar(entity);
        return inicio();
    }

    @GetMapping("/turma/editar/{idturma}")
    public ModelAndView editar(@PathVariable("idturma") Long idturma) {
        Optional<TurmaEntity> optional = service.getPorId(idturma);
        ModelAndView modelAndView = view("turma/editar", "turma", optional.get());
        return modelAndView.addAllObjects(model("turmas", service.getAll()));
    }

    @GetMapping("/turma/excluir/{idturma}")
    public ModelAndView excluir(@PathVariable("idturma") Long idturma) {
        service.excluirPorId(idturma);
        return inicio();
    }

    private Map novo(){
        return model("turma", new TurmaEntity());
    }
}
