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
@RequestMapping("sala")
public class SalaResource extends GenericResource<SalaService, SalaEntity> {

    @Autowired
    private SalaService service;

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


    @GetMapping("/editar/{idsala}")
    public ModelAndView editar(@PathVariable("idsala") Long idsala) {
        Optional<SalaEntity> optional = service.getPorId(idsala);
        ModelAndView modelAndView = view("sala/editar", "sala", optional.get());
        return modelAndView.addAllObjects(model("salas", service.getAll()));
    }

    @GetMapping("/excluir/{idsala}")
    public ModelAndView excluir(@PathVariable("idsala") Long idsala) {
        service.excluirPorId(idsala);
        return inicio();
    }

    @GetMapping("**/pesquisar")
    public ModelAndView pesquisar(@RequestParam("nome") String nome) {
        ModelAndView modelAndView = view("sala/listar","salas", service.getPorNome(nome));
        return modelAndView.addAllObjects(novo());
    }

    private Map novo(){
        return model("sala", new SalaEntity());
    }
}
