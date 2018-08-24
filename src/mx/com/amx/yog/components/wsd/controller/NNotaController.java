/**
 * 
 */
package mx.com.amx.yog.components.wsd.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.yog.components.wsd.controller.exception.ControllerException;
import mx.com.amx.yog.components.wsd.dao.NNotaDAO;
import mx.com.amx.yog.components.wsd.model.Nota;
import mx.com.amx.yog.components.wsd.request.NotesByIdCategoria;
import mx.com.amx.yog.components.wsd.request.NotesByIdDeporte;
import mx.com.amx.yog.components.wsd.request.NotesByIdTipoVideo;



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
	
	@RequestMapping(value = "getNotesByIdCategoria", method = RequestMethod.POST , headers = "Accept=application/json")
	@ResponseBody
	public List<Nota> getNotesByIdCategoria(@RequestBody NotesByIdCategoria req) throws ControllerException {
		
		
		logger.debug(" --- getNotesByIdCategoria  [ NNotaController ]  --- ");
		logger.debug(" ---  idCategoria : " + req.getIdCategoria() + "  --- ");
		logger.debug(" ---  limit : " + req.getLimit() + "  --- ");
		logger.debug(" ---  fechaIni : " + req.getFechaIni() + "  --- ");
		logger.debug(" ---  fechaFin : " + req.getFechaFin() + "  --- ");

		try {

			return nNotaDAO.getNotesByIdCategoria(req.getIdCategoria(),req.getLimit(),req.getFechaIni(),req.getFechaFin());

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdCategoria  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "getNotesByIdMagazine", method = RequestMethod.POST , headers = "Accept=application/json")
	@ResponseBody
	public List<Nota> getNotesByIdMagazine(@RequestParam(value = "idMagazine") String idMagazine, 
										   @RequestParam(value = "limit")  int limit , HttpServletResponse response) throws ControllerException {
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
	
	
	
	@RequestMapping(value = "getNotesNotInMagazineByIdCategoria", method = RequestMethod.POST , headers = "Accept=application/json")
	@ResponseBody
	public List<Nota> getNotesNotInMagazineByIdCategoria(@RequestParam(value = "idCategoria") String idCategoria, 
														 @RequestParam(value = "limit") int limit) throws ControllerException {
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
	
	

	
	@RequestMapping(value = "getNotesByIdDeporte", method = RequestMethod.POST , headers = "Accept=application/json")
	@ResponseBody
	public List<Nota> getNotesByIdDeporte(@RequestBody  NotesByIdDeporte req) throws ControllerException {
		logger.debug(" --- getNotesByIdDeporte  [ NNotaController ]  --- ");
		logger.debug(" ---  idDeporte : " + req.getIdDeporte() + "  --- ");
		logger.debug(" ---  limit : " + req.getLimit() + "  --- ");
		logger.debug(" ---  fechaIni : " + req.getFechaIni() + "  --- ");
		logger.debug(" ---  fechaFin : " + req.getFechaFin() + "  --- ");

		try {

			return nNotaDAO.getNotesByIdDeporte(req.getIdDeporte(),req.getLimit(),req.getFechaIni(),req.getFechaFin());

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdDeporte  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "getNotesByIdCategoriaAndIdDeporte", method = RequestMethod.POST , headers = "Accept=application/json")
	@ResponseBody
	public List<Nota> getNotesByIdCategoriaAndIdDeporte(@RequestParam (value ="idCategoria") String idCategoria , 
														@RequestParam (value ="idDeporte") String idDeporte,  
														@RequestParam (value ="limit") int limit , 
														@RequestParam (value ="fechaIni") String fechaIni  , 
														@RequestParam (value ="fechaFin") String fechaFin) throws ControllerException {
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
	
	
	
	@RequestMapping(value = "getNotesByIdTipoVideo", method = RequestMethod.POST , headers = "Accept=application/json")
	@ResponseBody
	public List<Nota> getNotesByIdTipoVideo(@RequestBody NotesByIdTipoVideo req) throws ControllerException {
		logger.debug(" --- getNotesByIdTipoVideo  [ NNotaController ]  --- ");
		logger.debug(" ---  idTipoVideo: " + req.getIdTipoVideo() + "  --- ");
		logger.debug(" ---  limit : " + req.getLimit() + "  --- ");
		logger.debug(" ---  fechaIni : " + req.getFechaIni() + "  --- ");
		logger.debug(" ---  fechaFin : " + req.getFechaFin() + "  --- ");



		try {

			return nNotaDAO.getNotesByIdTipoVideo( req.getIdTipoVideo(),req.getLimit(), req.getFechaIni(),req.getFechaFin());

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdTipoVideo  [ NNotaController ] ! ", e);
			throw new ControllerException(e.getMessage());
		}
	}


}
