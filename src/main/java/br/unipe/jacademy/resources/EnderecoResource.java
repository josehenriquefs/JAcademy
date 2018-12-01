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
@RequestMapping("endereco")
public class EnderecoResource extends GenericResource<SalaService, SalaEntity> {

    @Autowired
    private SalaService service;

    @GetMapping("/listar")
    public ModelAndView inicio() {
        ModelAndView modelAndView = view("endereco/adicionar", "enderecos", service.getAll());
        return modelAndView.addAllObjects(novo());
    }

    @GetMapping("/cadastrar")
    public ModelAndView salvar(SalaEntity entity) {
        service.salvar(entity);
        return inicio();
    }


    @GetMapping("/editar/{idendereco}")
    public ModelAndView editar(@PathVariable("idendereco") Long idendereco) {
        Optional<SalaEntity> optional = service.getPorId(idendereco);
        ModelAndView modelAndView = view("endereco/editar", "endereco", optional.get());
        return modelAndView.addAllObjects(model("enderecos", service.getAll()));
    }

    @GetMapping("/excluir/{idendereco}")
    public ModelAndView excluir(@PathVariable("idendereco") Long idendereco) {
        service.excluirPorId(idendereco);
        return inicio();
    }

    @GetMapping("**/pesquisar")
    public ModelAndView pesquisar(@RequestParam("nome") String nome) {
        ModelAndView modelAndView = view("endereco/listar","enderecos", service.getPorNome(nome));
        return modelAndView.addAllObjects(novo());
    }

    private Map novo(){
        return model("endereco", new SalaEntity());
    }
}
