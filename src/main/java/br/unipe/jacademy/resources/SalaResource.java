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
    private SalaService salaService;
    @Autowired
    private TurmaService turmaService;

    @GetMapping("/listar")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("sala/adicionar", "salas", salaService.getAll());
        return modelAndView.addAllObjects(novo());
    }

    @GetMapping("/cadastrar")
    public ModelAndView salvar(SalaEntity entity) {
        salaService.salvar(entity);
        return inicio();
    }

    @GetMapping("/editar/{idsala}")
    public ModelAndView editar(@PathVariable("idsala") Long idsala) {
        Optional<SalaEntity> optional = salaService.getPorId(idsala);
        ModelAndView modelAndView = view("sala/editar", "sala", optional.get());
        return modelAndView.addAllObjects(model("salas", salaService.getAll()));
    }

    @GetMapping("/excluir/{idsala}")
    public ModelAndView excluir(@PathVariable("idsala") Long idsala) {
        salaService.excluirPorId(idsala);
        return inicio();
    }
    
    @GetMapping("**/pesquisar")
    public ModelAndView pesquisar(@RequestParam("nome") String nome) {
        ModelAndView modelAndView = view("sala/listar","salas", salaService.getPorNome(nome));
        return modelAndView.addAllObjects(novo());
    }
    
    @GetMapping("/relacionar/listar/{idsala}")
    public ModelAndView listar(@PathVariable("idsala") Long idsala) {
        Optional<SalaEntity> optional = salaService.getPorId(idsala);
        ModelAndView modelAndView = view("sala/relacionar1", "sala", optional.get());
        return modelAndView.addAllObjects(model("relacoes", turmaService.getTurmaPorSala(idsala)));
    }
    
    @PostMapping("/relacionar/cadastrar/{idsala}")
    public ModelAndView cadastar(TurmaEntity turma, @PathVariable("idsala") Long idsala) {
    	SalaEntity sala =  salaService.getPorId(idsala).get();
    	turma.setSala(sala);
    	turmaService.salvar(turma);
        ModelAndView modelAndView = view("sala/relacionar1", "sala", sala);
        List<TurmaEntity> turmas= turmaService.getTurmaPorSala(idsala);
        return modelAndView.addAllObjects(model("relacoes", turmas));
    }

    private Map novo(){
        return model("sala", new SalaEntity());
    }
}
