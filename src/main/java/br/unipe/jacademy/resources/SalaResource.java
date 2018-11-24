package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.EnderecoEntity;
import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.services.EnderecoService;
import br.unipe.jacademy.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class SalaResource <T extends Object>{

    @Autowired
    private SalaService service;

    @Autowired
    private EnderecoService enderecoService;

    private ModelAndView modelAndView;
    private Map<String, T> atributo;

    @RequestMapping(method = RequestMethod.GET, value = "/salas")
    public ModelAndView inicio() {
        return salas("cadastro/salas");
    }


    @RequestMapping(method = RequestMethod.POST, value = "**/salvar")
    public ModelAndView salvar(SalaEntity entity) {
        entity = service.salvar(entity);
        return salas();
    }

    @GetMapping("/sala/editar/{idsala}")
    public ModelAndView editar(@PathVariable("idsala") Long idsala) {
        ModelAndView modelAndView = new ModelAndView("sala/editar");
        Optional<SalaEntity> optional = service.getPorId(idsala);
        return modelAndView.addObject("sala", optional.get());
    }

    @GetMapping("/sala/excluir/{idsala}")
    public ModelAndView excluir(@PathVariable("idsala") Long idsala) {
        service.excluiPorId(idsala);
        return salas();
    }

    @PostMapping("**/pesquisarsalas")
    public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa) {
        ModelAndView modelAndView = new ModelAndView("cadastro/salas");
        return modelAndView.addObject("salas", service.getPorNome(nomepesquisa)).addObject("sala", new SalaEntity());
    }

    @GetMapping("/endereco/{idsala}")
    public ModelAndView cadeiras(@PathVariable("idsala") Long idsala) {
        Optional<SalaEntity> optional = service.getPorId(idsala);
        ModelAndView modelAndView = new ModelAndView("cadastro/endereco");
        modelAndView.addObject("salas", optional.get());
        return modelAndView;
    }

    @PostMapping("**/addendereco/{idsala}")
    public ModelAndView addEndereco(EnderecoEntity endereco, @PathVariable("idsala") Long idsala) {
        ModelAndView modelAndView = new ModelAndView("cadastro/endereco");
        SalaEntity sala = service.getPorId(idsala).get();
        endereco.setSala(sala);
        enderecoService.salvar(endereco);
        return modelAndView.addObject("salas", sala);
    }

    private ModelAndView salas(String path) {
        ModelAndView modelAndView = new ModelAndView(path);
        return modelAndView.addObject("salas", service.getAll());
    }

    private ModelAndView newSala() {
        ModelAndView modelAndView = new ModelAndView(path);
        return modelAndView.addObject("salas", service.getAll());
    }

    private ModelAndView prepara(String string, T atributo) {
        this.atributo.
        return atributo
    }
}
