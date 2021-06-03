package com.proyecto.pac.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.pac.models.entity.Categoria;
import com.proyecto.pac.models.entity.Productos;
import com.proyecto.pac.models.service.ICategoriaService;
import com.proyecto.pac.models.service.IProductoService;


@Controller
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private ICategoriaService categoriaService;
	
	
	@GetMapping("/listar")
	public String listarProductos(Model model) {
		List<Productos> listadoProductos = productoService.listarTodos();
		
 		model.addAttribute("titulo", "Lista de productos");
 		model.addAttribute("productos", listadoProductos);
		return "productos/listar";
		
	}
	

	
	  @GetMapping("/create") 
	  public String crear(Model model,  HttpSession sesion ) {	  
	  Productos productos = new Productos(); 
	  List<Categoria> listCategorias = categoriaService.listaCategoria();
	  
	  model.addAttribute("titulo","Formulario: Nuevo Producto");
	  model.addAttribute("productos", productos); 
	  model.addAttribute("categoria", listCategorias); 
	  return "productos/frmCrear"; 
	  }
	  
	  
		/*
		 * @PostMapping("/save") public String guardar(@ModelAttribute Productos
		 * producto, Model model, RedirectAttributes attributes) {
		 * productoService.guardar(producto);
		 * attributes.addFlashAttribute("success","Producto guardado con exito!");
		 * return "redirect:/productos/";
		 * }
		 */
	  
		@PostMapping("/save")
		public String guardar(@Valid @ModelAttribute Productos producto, BindingResult result, Model model,
				@RequestParam("file") MultipartFile imagen, RedirectAttributes attribute) {
			
			if(!imagen.isEmpty()) {
				Path directorioImagenes = Paths.get("src//main//resources//static/images");
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				//String rutaAbsoluta = "C://Cliente//recursos";
				
				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
					producto.setImagen(imagen.getOriginalFilename());
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			
			productoService.guardar(producto);
			System.out.println("Producto guardado con exito!");
			attribute.addFlashAttribute("success", "Producto guardado con exito!");
			return "redirect:/productos/";
		}
	  
		@GetMapping("/detalle/{idproducto}")
		public String detalleProducto(@PathVariable("idproducto") Integer idproducto, Model model,
				RedirectAttributes attribute) {
			
			Productos producto = productoService.buscarPorId(idproducto); 
			
			model.addAttribute("titulo","Detalle del producto: "+ producto.getNombrep());
			model.addAttribute("productos", producto);
			return "productos/detalle";
		}
	  
	  @GetMapping("/edit/{idproducto}") 
	  public String editar(@PathVariable("idproducto") Integer idProducto, Model model,
			  RedirectAttributes attribute) {
				  
				  Productos producto = productoService.buscarPorId(idProducto); 
				  List<Categoria> listCategoria = categoriaService.listaCategoria();
				  
				  model.addAttribute("titulo","Formulario: Editar Cliente");
				  model.addAttribute("productos", producto); 
				  model.addAttribute("categoria", listCategoria); 
				  attribute.addFlashAttribute("warning", "Registro actualizado con exito!"); 
				  return "productos/frmCrear";
		}
		
		  @GetMapping("/delete/{id}") 
		  public String eliminar(@PathVariable("id") Integer idProducto,Model model ,RedirectAttributes attribute) {		
		  productoService.eliminar(idProducto);
		  System.out.println("Registro Eliminado con Exito!");
		  attribute.addFlashAttribute("warning", "Registro eliminado con exito!");
		  return "redirect:/productos/";
		  }
	
			@GetMapping({"/ubicanos"})
			public String ubicanos() {
				return "ubicanos";
			}
	  
			@GetMapping({"/verproductos"})
			public String verproductos(Model model) {
				List<Productos> listadoProductos = productoService.listarTodos();
				
		 		model.addAttribute("titulo", "Lista de productos");
		 		model.addAttribute("productos", listadoProductos);
				return "productos/verproductos";
				
									
			}
	  
	  }
	 

