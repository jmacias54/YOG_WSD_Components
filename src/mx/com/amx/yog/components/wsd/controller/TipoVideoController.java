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
import mx.com.amx.yog.components.wsd.dao.TipoVideoDAO;
import mx.com.amx.yog.components.wsd.model.TipoVideo;



/**
 * @author  Jesus Armando Macias Benitez
 *
 */
@Controller
@RequestMapping("/tipo-video")
public class TipoVideoController {
	
	
	private static Logger logger = Logger.getLogger(TipoVideoController.class);
	
	@Autowired
	private TipoVideoDAO tipoVideoDAO;
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<TipoVideo> findAll() throws ControllerException {
		logger.debug("--- findAll [ TipoVideoController ]-----");
		

	
		try {
			return tipoVideoDAO.findAll();
		} catch (Exception e) {
			logger.error(" -- Error  findAll [ TipoVideoController ] :", e);
			throw new ControllerException(e.getMessage());
		}

		
	}
	
	
	@RequestMapping(value = "/{idTipoVideo}/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public TipoVideo findByIdTipoVideo(@PathVariable String idTipoVideo) throws ControllerException {
		logger.debug("--- findByIdTipoVideo [ TipoVideoController ]-----");
		logger.debug("--- idTipoVideo : "+idTipoVideo+"-----");
		

	
		try {
			return tipoVideoDAO.findById(idTipoVideo);
		} catch (Exception e) {
			logger.error(" -- Error  findByIdTipoVideo [ TipoVideoController ] :", e);
			throw new ControllerException(e.getMessage());
		}

		
	}

}
