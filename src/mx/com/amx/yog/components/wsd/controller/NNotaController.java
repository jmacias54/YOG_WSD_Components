/**
 * 
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
import mx.com.amx.yog.components.wsd.dao.NNotaDAO;
import mx.com.amx.yog.components.wsd.model.Nota;



/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("nNota")
public class NNotaController {
	private static Logger logger = Logger.getLogger(NNotaController.class);

	@Autowired
	private NNotaDAO nNotaDAO;
	

	
	
	@RequestMapping(value = "/getNotesByIdMagazine/{idMagazine}/{limit}/", method = RequestMethod.POST , headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Nota> getNotesByIdMagazine(@PathVariable String idMagazine, @PathVariable int limit) throws ControllerException {
		logger.debug(" --- getNotesByIdMagazine  [ NNotaController ]  --- ");
		logger.debug(" ---  idMagazine : " + idMagazine + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");

		try {

			
			return nNotaDAO.getNotesByIdMagazine(idMagazine,limit);
		

		} catch (Exception e) {
			logger.error(" ¡ Error lastNotesFindByIdCategoriaLimit  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}
	
	
	
	@RequestMapping(value = "/getNotesNotInMagazineByIdCategoria/{idCategoria}/{limit}/", method = RequestMethod.POST , headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Nota> getNotesNotInMagazineByIdCategoria(@PathVariable String idCategoria, @PathVariable int limit) throws ControllerException {
		logger.debug(" --- getNotesNotInMagazineByIdCategoria  [ NNotaController ]  --- ");
		logger.debug(" ---  idCategoria : " + idCategoria + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");


		try {

			return nNotaDAO.getNotesNotInMagazineByIdCategoria(idCategoria,limit);

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesNotInMagazineByIdCategoria  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/getNotesByIdCategoria/{idCategoria}/{limit}/{fechaIni}/{fechaFin}/", method = RequestMethod.POST , headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Nota> getNotesByIdCategoria(@PathVariable String idCategoria, @PathVariable int limit , 
											@PathVariable String fechaIni  , @PathVariable String fechaFin) throws ControllerException {
		logger.debug(" --- getNotesByIdCategoria  [ NNotaController ]  --- ");
		logger.debug(" ---  idCategoria : " + idCategoria + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");
		logger.debug(" ---  fechaIni : " + fechaIni + "  --- ");
		logger.debug(" ---  fechaFin : " + fechaFin + "  --- ");

		try {

			return nNotaDAO.getNotesByIdCategoria(idCategoria,limit,fechaIni,fechaFin);

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdCategoria  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/getNotesByIdCategoriaAndIdDeporte/{idCategoria}/{idDeporte}/{limit}/{fechaIni}/{fechaFin}/", method = RequestMethod.POST , headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Nota> getNotesByIdCategoriaAndIdDeporte(@PathVariable String idCategoria , @PathVariable String idDeporte,  @PathVariable int limit , 
											@PathVariable String fechaIni  , @PathVariable String fechaFin) throws ControllerException {
		logger.debug(" --- getNotesByIdCategoriaAndIdDeporte  [ NNotaController ]  --- ");
		logger.debug(" ---  idCategoria : " + idCategoria + "  --- ");
		logger.debug(" ---  idDeporte : " + idDeporte + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");
		logger.debug(" ---  fechaIni : " + fechaIni + "  --- ");
		logger.debug(" ---  fechaFin : " + fechaFin + "  --- ");



		try {

			return nNotaDAO.getNotesByIdCategoriaAndIdDeporte(idCategoria,idDeporte,limit,fechaIni,fechaFin);

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdCategoriaAndIdDeporte  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}
	
	
	
	@RequestMapping(value = "/getNotesByIdTipoVideo/{idTipoVideo}/{limit}/{fechaIni}/{fechaFin}/", method = RequestMethod.POST , headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<Nota> getNotesByIdTipoVideo(@PathVariable String idTipoVideo ,  @PathVariable int limit , 
											@PathVariable String fechaIni  , @PathVariable String fechaFin) throws ControllerException {
		logger.debug(" --- getNotesByIdTipoVideo  [ NNotaController ]  --- ");
		logger.debug(" ---  idCategoria : " + idTipoVideo + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");
		logger.debug(" ---  fechaIni : " + fechaIni + "  --- ");
		logger.debug(" ---  fechaFin : " + fechaFin + "  --- ");



		try {

			return nNotaDAO.getNotesByIdTipoVideo(idTipoVideo,limit,fechaIni,fechaFin);

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdTipoVideo  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}


}
