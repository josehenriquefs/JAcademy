package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.AlunoEntity;
import br.unipe.jacademy.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class AlunoResource extends GenericResource<AlunoService, AlunoEntity> {

    @Autowired
    private AlunoService service;

    @GetMapping("/alunos")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("aluno/adicionar", "alunos", service.getAll());
        return modelAndView.addAllObjects(novo());
    }


    @PostMapping("/aluno/salvar")
    public ModelAndView salvar(AlunoEntity entity) {
        service.salvar(entity);
        return inicio();
    }

    @GetMapping("/aluno/editar/{idaluno}")
    public ModelAndView editar(@PathVariable("idaluno") Long idaluno) {
        Optional<AlunoEntity> optional = service.getPorId(idaluno);
        ModelAndView modelAndView = view("aluno/editar", "aluno", optional.get());
        return modelAndView.addAllObjects(model("alunos", service.getAll()));
    }

    @GetMapping("/aluno/excluir/{idaluno}")
    public ModelAndView excluir(@PathVariable("idaluno") Long idaluno) {
        service.excluirPorId(idaluno);
        return inicio();
    }

    @PostMapping("/aluno/pesquisar")
    public ModelAndView pesquisar(@RequestParam("nome") String nome) {
        ModelAndView modelAndView = view("sala/listar","salas", service.getPorNome(nome));
        return modelAndView.addAllObjects(novo());
    }

    private Map novo(){
        return model("aluno", new AlunoEntity());
    }
}
