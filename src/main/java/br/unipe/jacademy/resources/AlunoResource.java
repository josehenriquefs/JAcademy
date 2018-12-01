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
@RequestMapping("aluno")
public class AlunoResource extends GenericResource<SalaService, SalaEntity> {

    @Autowired
    private SalaService service;

    @GetMapping("/listar")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("aluno/adicionar", "alunos", service.getAll());
        return modelAndView.addAllObjects(novo());
    }

    @GetMapping("/cadastrar")
    public ModelAndView salvar(SalaEntity entity) {
        service.salvar(entity);
        return inicio();
    }


    @GetMapping("/editar/{idaluno}")
    public ModelAndView editar(@PathVariable("idaluno") Long idaluno) {
        Optional<SalaEntity> optional = service.getPorId(idaluno);
        ModelAndView modelAndView = view("aluno/editar", "aluno", optional.get());
        return modelAndView.addAllObjects(model("alunos", service.getAll()));
    }

    @GetMapping("/excluir/{idaluno}")
    public ModelAndView excluir(@PathVariable("idaluno") Long idaluno) {
        service.excluirPorId(idaluno);
        return inicio();
    }

    @GetMapping("**/pesquisar")
    public ModelAndView pesquisar(@RequestParam("nome") String nome) {
        ModelAndView modelAndView = view("aluno/listar","alunos", service.getPorNome(nome));
        return modelAndView.addAllObjects(novo());
    }

    private Map novo(){
        return model("aluno", new SalaEntity());
    }
}
