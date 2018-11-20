package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.SalaEntity;
import br.unipe.jacademy.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SalaResource {

    @Autowired
    private SalaService service;

    @RequestMapping(method = RequestMethod.GET, value = "/salas")
    public ModelAndView inicio() {
        ModelAndView modelAndView = new ModelAndView("salaView");
        return modelAndView.addObject("sala", new SalaEntity());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listarsalas")
    public ModelAndView salas(){
        ModelAndView modelAndView = new ModelAndView("salaView");
        return modelAndView.addObject("salas", service.getAll()).addObject("sala", new SalaEntity());
    }

    @RequestMapping(method = RequestMethod.POST, value = "**/salvarsalas")
    public ModelAndView salvar(SalaEntity entity){
        entity = service.salvar(entity);
        return salas();
    }

    @GetMapping("/editarsalas/{idsala}")
    public ModelAndView editar (@PathVariable("idsala") Long idsala){
        ModelAndView modelAndView = new ModelAndView("salaView");
        Optional<SalaEntity> optional = service.getPorId(idsala);
        return modelAndView.addObject("sala", optional.get());
    }

    @GetMapping("/excluirsalas/{idsala}")
    public ModelAndView excluir (@PathVariable("idsala") Long idsala){
        service.excluiPorId(idsala);
        return salas();
    }

    @PostMapping("**/pesquisarsalas")
    public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa){
        ModelAndView modelAndView = new ModelAndView("salaView");
        return modelAndView.addObject("salas", service.getPorNome(nomepesquisa)).addObject("sala", new SalaEntity());
    }
}
