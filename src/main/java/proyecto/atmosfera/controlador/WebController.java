package proyecto.atmosfera.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.atmosfera.manejoArchivos.ManejoDato;
import proyecto.atmosfera.manejoArchivos.ManejoRegistro;
import proyecto.atmosfera.modelo.Registro;

import java.util.ArrayList;

@Controller
@RequestMapping()
public class WebController {

    /*@RequestMapping("")
    public String index(Model model) {
        ManejoDato md = new ManejoDato();
        ManejoRegistro rController = new ManejoRegistro();
        ArrayList<Registro> ListaRegistros = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        String [][] arraymirar = ListaRegistros.get(1).contarValor(100,ListaRegistros,"30/04/2019","MP10");
        model.addAttribute("registros", ListaRegistros);
        model.addAttribute("array", arraymirar);
        return "index";
    }
    */

    @RequestMapping("/tabla")
    public String tabla(Model model) {
        ManejoDato md = new ManejoDato();
        ManejoRegistro rController = new ManejoRegistro();
        ArrayList<Registro> ListaRegistros = rController.registrosPorHora(md.leerArchivo("ProyectoAtmosfera.csv"));
        model.addAttribute("registros", ListaRegistros);
        return "tablaRegistros";
    }

    @RequestMapping("/home")
    public String index(Model model){
        return "PaginaBienvenidaBootstrap";
    }

    @RequestMapping("/PaginaGraficoBootstrap")
    public String PaginaGraficoBootstrap(Model model){
        return "PaginaGraficoBootstrap";
    }

    @RequestMapping("/Heatmap")
    public String heatmap(Model model){
        ArrayList<Registro> registros = new ArrayList<>();
        registros.add(new Registro("amanecer",1,"20-11-19","00:00",35.0,56.0));
        registros.add(new Registro("amanecer",1,"21-11-19","01:00",54.0,23.0));
        registros.add(new Registro("amanecer",1,"22-11-19","02:00",78.0,14.0));
        model.addAttribute("datosRegistros",registros);
        return "HeatMap";
    }
}
