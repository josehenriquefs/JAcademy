package br.unipe.jacademy.resources;

import br.unipe.jacademy.entities.EnderecoEntity;
import br.unipe.jacademy.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EnderecoResource extends GenericResource<EnderecoService, EnderecoEntity>{

    @Autowired
    private EnderecoService service;

    @GetMapping("/enderecos")
    public ModelAndView inicio() {
        return view("endereco/listar", "enderecos", service.getAll());
    }


    @PostMapping("/endereco/salvar")
    public ModelAndView salvar(EnderecoEntity entity) {
        service.salvar(entity);
        return inicio();
    }

    @GetMapping("/endereco/editar/{idendereco}")
    public ModelAndView editar(@PathVariable("idendereco") Long idendereco) {
        Optional<EnderecoEntity> optional = service.getPorId(idendereco);
        return view("endereco/editar", "endereco", optional.get());
    }

    @GetMapping("/endereco/excluir/{idendereco}")
    public ModelAndView excluir(@PathVariable("idendereco") Long idendereco) {
        service.excluirPorId(idendereco);
        return inicio();
    }
}
