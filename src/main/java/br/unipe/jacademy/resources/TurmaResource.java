package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("turma")
public class TurmaResource extends GenericResource<SalaService, SalaEntity> {

    @Autowired
    private SalaService service;

    @GetMapping("/listar")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("turma/adicionar", "turmas", service.getAll());
        return modelAndView.addAllObjects(novo());
    }

    @GetMapping("/cadastrar")
    public ModelAndView salvar(SalaEntity entity) {
        service.salvar(entity);
        return inicio();
    }


    @GetMapping("/editar/{idturma}")
    public ModelAndView editar(@PathVariable("idturma") Long idturma) {
        Optional<SalaEntity> optional = service.getPorId(idturma);
        ModelAndView modelAndView = view("turma/editar", "turma", optional.get());
        return modelAndView.addAllObjects(model("turmas", service.getAll()));
    }

    @GetMapping("/excluir/{idturma}")
    public ModelAndView excluir(@PathVariable("idturma") Long idturma) {
        service.excluirPorId(idturma);
        return inicio();
    }

    @GetMapping("**/pesquisar")
    public ModelAndView pesquisar(@RequestParam("nome") String nome) {
        ModelAndView modelAndView = view("turma/listar","turmas", service.getPorNome(nome));
        return modelAndView.addAllObjects(novo());
    }

    private Map novo(){
        return model("turma", new SalaEntity());
    }
}
