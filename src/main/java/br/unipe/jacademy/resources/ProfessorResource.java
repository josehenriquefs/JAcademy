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
@RequestMapping("professor")
public class ProfessorResource extends GenericResource<SalaService, SalaEntity> {

    @Autowired
    private SalaService service;

    @GetMapping("/listar")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("professor/adicionar", "professors", service.getAll());
        return modelAndView.addAllObjects(novo());
    }

    @GetMapping("/cadastrar")
    public ModelAndView salvar(SalaEntity entity) {
        service.salvar(entity);
        return inicio();
    }


    @GetMapping("/editar/{idprofessor}")
    public ModelAndView editar(@PathVariable("idprofessor") Long idprofessor) {
        Optional<SalaEntity> optional = service.getPorId(idprofessor);
        ModelAndView modelAndView = view("professor/editar", "professor", optional.get());
        return modelAndView.addAllObjects(model("professors", service.getAll()));
    }

    @GetMapping("/excluir/{idprofessor}")
    public ModelAndView excluir(@PathVariable("idprofessor") Long idprofessor) {
        service.excluirPorId(idprofessor);
        return inicio();
    }

    @GetMapping("**/pesquisar")
    public ModelAndView pesquisar(@RequestParam("nome") String nome) {
        ModelAndView modelAndView = view("professor/listar","professors", service.getPorNome(nome));
        return modelAndView.addAllObjects(novo());
    }

    private Map novo(){
        return model("professor", new SalaEntity());
    }
}
