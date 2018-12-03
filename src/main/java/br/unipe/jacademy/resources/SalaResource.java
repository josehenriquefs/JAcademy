package br.unipe.jacademy.resources;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.entities.TurmaEntity;
import br.unipe.jacademy.services.SalaService;
import br.unipe.jacademy.services.TurmaService;

@Controller
@RequestMapping("sala")
public class SalaResource extends GenericResource<SalaService, SalaEntity> {

    @Autowired
    private SalaService service;
    @Autowired
    private TurmaService turmaService;

    @GetMapping("/listar")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("sala/adicionar", "salas", service.getAll());
        return modelAndView.addAllObjects(novo());
    }

    @GetMapping("/cadastrar")
    public ModelAndView salvar(SalaEntity entity) {
        service.salvar(entity);
        return inicio();
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        Optional<SalaEntity> optional = service.getPorId(id);
        ModelAndView modelAndView = view("sala/editar", "sala", optional.get());
        return modelAndView.addAllObjects(model("salas", service.getAll()));
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        service.excluirPorId(id);
        return inicio();
    }
    
    @GetMapping("**/pesquisar")
    public ModelAndView pesquisar(@RequestParam("nome") String nome) {
        ModelAndView modelAndView = view("sala/listar","salas", service.getPorNome(nome));
        return modelAndView.addAllObjects(novo());
    }
    
    @GetMapping("/listar/turma/{id}")
    public ModelAndView listarTurma(@PathVariable("id") Long id) {
        Optional<SalaEntity> optional = service.getPorId(id);
        ModelAndView modelAndView = view("sala/relacionar1", "sala", optional.get());
        return modelAndView.addAllObjects(model("turmas", turmaService.getTurmaPorSala(id)));
    }
    
    @PostMapping("/cadastrar/turma/{id}")
    public ModelAndView cadastarTurma(TurmaEntity turma, @PathVariable("id") Long id) {
    	SalaEntity sala =  service.getPorId(id).get();
    	turma.setSala(sala);
    	turmaService.salvar(turma);
        ModelAndView modelAndView = view("sala/relacionar1", "sala", sala);
        List<TurmaEntity> turmas= turmaService.getTurmaPorSala(id);
        return modelAndView.addAllObjects(model("turmas", turmas));
    }

    @GetMapping("/excluir/turma/{id}")
    public ModelAndView excluirTurma(@PathVariable("id") Long id) {
    	SalaEntity sala = turmaService.getPorId(id).get().getSala();
    	turmaService.excluirPorId(id);
        ModelAndView modelAndView = view("sala/relacionar1", "sala", sala);
        return modelAndView.addAllObjects(model("turmas", turmaService.getTurmaPorSala(sala.getId())));
    }

    private Map novo(){
        return model("sala", new SalaEntity());
    }
}
