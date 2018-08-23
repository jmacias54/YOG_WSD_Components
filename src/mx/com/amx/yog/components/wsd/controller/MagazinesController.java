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
import mx.com.amx.yog.components.wsd.dao.MagazineDAO;
import mx.com.amx.yog.components.wsd.model.Magazine;

/**
 * @author  Jesus Armando Macias Benitez
 *
 */


@Controller
@RequestMapping("/magazine")
public class MagazinesController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(CategoriasController.class);
	
	@Autowired
	private MagazineDAO magazineDAO;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Magazine> findAll() throws ControllerException {
		logger.debug("--- findAll [ MagazinesController ]-----");
		

	
		try {
			return magazineDAO.findAll();
		} catch (Exception e) {
			logger.error(" -- Error  findAll [ MagazinesController ] :", e);
			throw new ControllerException(e.getMessage());
		}

		
	}
	
	
	@RequestMapping(value = "/{idMagazine}/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public Magazine findById(@PathVariable String idMagazine) throws ControllerException {
		logger.debug("--- findById [ MagazinesController ]-----");
		logger.debug("--- idMagazine : "+idMagazine+"-----");
		

	
		try {
			return magazineDAO.findById(idMagazine);
		} catch (Exception e) {
			logger.error(" -- Error  findById [ MagazinesController ] :", e);
			throw new ControllerException(e.getMessage());
		}
	}
}
