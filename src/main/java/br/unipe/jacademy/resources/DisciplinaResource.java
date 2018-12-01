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
@RequestMapping("disciplina")
public class DisciplinaResource extends GenericResource<SalaService, SalaEntity> {

    @Autowired
    private SalaService service;

    @GetMapping("/listar")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("disciplina/adicionar", "disciplinas", service.getAll());
        return modelAndView.addAllObjects(novo());
    }

    @GetMapping("/cadastrar")
    public ModelAndView salvar(SalaEntity entity) {
        service.salvar(entity);
        return inicio();
    }


    @GetMapping("/editar/{iddisciplina}")
    public ModelAndView editar(@PathVariable("iddisciplina") Long iddisciplina) {
        Optional<SalaEntity> optional = service.getPorId(iddisciplina);
        ModelAndView modelAndView = view("disciplina/editar", "disciplina", optional.get());
        return modelAndView.addAllObjects(model("disciplinas", service.getAll()));
    }

    @GetMapping("/excluir/{iddisciplina}")
    public ModelAndView excluir(@PathVariable("iddisciplina") Long iddisciplina) {
        service.excluirPorId(iddisciplina);
        return inicio();
    }

    @GetMapping("**/pesquisar")
    public ModelAndView pesquisar(@RequestParam("nome") String nome) {
        ModelAndView modelAndView = view("disciplina/listar","disciplinas", service.getPorNome(nome));
        return modelAndView.addAllObjects(novo());
    }

    private Map novo(){
        return model("disciplina", new SalaEntity());
    }
}
