/**
 * @author Jesus Armando Macias Benitez
 */
package mx.com.amx.yog.components.wsd.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.yog.components.wsd.controller.exception.ControllerException;
import mx.com.amx.yog.components.wsd.dao.CategoriaDAO;
import mx.com.amx.yog.components.wsd.model.Categoria;

/**
 * 
 * @author  Jesus Armando Macias Benitez
 *
 */


@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	/** The logger. */
	private static Logger logger = Logger.getLogger(CategoriasController.class);
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Categoria> findAll() throws ControllerException {
		logger.debug("--- findAll [ CategoriaController ]-----");
		

	
		try {
			return categoriaDAO.findAll();
		} catch (Exception e) {
			logger.error(" -- Error  findAll [ CategoriaController ] :", e);
			throw new ControllerException(e.getMessage());
		}

		
	}
	
	
	@RequestMapping(value = "/{idCategoria}/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public Categoria findByIdCategoria(@PathVariable String idCategoria) throws ControllerException {
		logger.debug("--- findByIdCategoria [ CategoriaController ]-----");
		logger.debug("--- idCategoria : "+idCategoria+"-----");
		

	
		try {
			return categoriaDAO.findById(idCategoria);
		} catch (Exception e) {
			logger.error(" -- Error  findByIdCategoria [ CategoriaController ] :", e);
			throw new ControllerException(e.getMessage());
		}

		
	}

}
