/**
 * 
 */
package mx.com.amx.yog.components.wsd.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.yog.components.wsd.dao.exception.DAOException;
import mx.com.amx.yog.components.wsd.model.Nota;


/**
 * @author Jesus A. Macias Benitez
 *
 */
public class NNotaDAO {

	private static Logger logger = Logger.getLogger(NNotaDAO.class);
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	/**  NOTA TAGS MANUAL */
	public List<Nota> getNotesByIdMagazine( String idMagazine ,int limit ) throws DAOException {
		logger.debug(" --- getNotesByIdMagazine  [ NNotaDAO ]  --- ");
		logger.debug(" ---  idMagazine : " + idMagazine + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");

		List<Nota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CATEGORIA idCategoria ,   ");
		query.append(" 		 		 nota.FC_ID_CONTENIDO idContenido ,  ");
		query.append(" 		 		 nota.FC_DESCRIPCION descripcion ,  ");
		query.append(" 		 		 deporte.FC_ID_DEPORTE idDeporte ,  ");
		query.append(" 		 		 deporte.FC_DESCRIPCION deporteDescripcion ,  ");
		query.append(" 		 	     categoria.FC_DESCRIPCION categoriaDescripcion,  ");
		query.append(" 		 		 nota.FC_FRIENDLY_URL nombre ,  ");
		query.append(" 		 		 nota.FC_ID_TIPO_NOTA tipoNota,   ");
		query.append(" 		 		 nota.FD_FECHA_PUBLICACION fechaPublicacion,   ");
		query.append(" 		 		 nota.FC_IMAGEN_PRINCIPAL imagenPrincipal,   ");
		query.append(" 		 		 nota.FC_IMAGEN_PIE imagenPie,   ");
		query.append(" 		 		 nota.FC_ID_TIPO_VIDEO tipoVideo,  ");
		query.append(" 		 		 nota.FC_TITULO titulo,   ");
		query.append(" 		 		CONCAT(COALESCE(categoria.FC_FRIENDLY_URL,''),'/detalle/', COALESCE(nota.FC_FRIENDLY_URL,'')) friendlyUrl   ");
		query.append(" FROM yog_ba_n_nota nota  ");
		query.append(" LEFT JOIN 	  yog_ba_c_categoria categoria  ON nota.FC_ID_CATEGORIA=categoria.FC_ID_CATEGORIA           ");
		query.append(" LEFT JOIN     yog_ba_c_deporte deporte ON nota.FC_ID_DEPORTE= deporte.FC_ID_DEPORTE ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_nota tipo_nota ON  nota.FC_ID_TIPO_NOTA= tipo_nota.FC_ID_TIPO_NOTA           ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_video tipo_video ON nota.FC_ID_TIPO_VIDEO= tipo_video.FC_ID_TIPO_VIDEO   ");
		query.append(" INNER JOIN    yog_ba_i_nota_magazine i_magazine ON nota.FC_ID_CONTENIDO =  i_magazine.FC_ID_CONTENIDO");
		query.append(" WHERE i_magazine.FC_ID_MAGAZINE = '"+idMagazine+"'    ");
		query.append(" AND nota.FC_ID_ESTATUS_NOTA = 'PUB'");
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC  ");
		
		if(limit > 0)
			query.append(" LIMIT "+limit+"  ");
	

		try {

			logger.debug(""+query.toString());
			
			lista =   jdbcTemplate.query(query.toString(),  new BeanPropertyRowMapper<Nota>(Nota.class));
			
			

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdMagazine  [ NNotaDAO ] ! ", e);
			logger.error(" query : " + query);
			throw new DAOException(e.getMessage());
		}
		
		
		logger.debug("lista Size : "+lista.size());
		
		return lista ;
	}
	
	
	public List<Nota> getNotesNotInMagazineByIdCategoria( String idCategoria ,int limit ) throws DAOException {
		logger.debug(" --- getNotesNotInMagazineByIdCategoria  [ NNotaDAO ]  --- ");
		logger.debug(" ---  idCategoria : " + idCategoria + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");

		List<Nota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CATEGORIA idCategoria ,    ");
		query.append(" 		 		 nota.FC_ID_CONTENIDO idContenido ,   ");
		query.append(" 		 		 nota.FC_DESCRIPCION descripcion ,   ");
		query.append(" 		 		 deporte.FC_ID_DEPORTE idDeporte ,   ");
		query.append(" 		 		 deporte.FC_DESCRIPCION deporteDescripcion ,   ");
		query.append(" 		 	     categoria.FC_DESCRIPCION categoriaDescripcion,   ");
		query.append(" 		 		 nota.FC_FRIENDLY_URL nombre ,   ");
		query.append(" 		 		 nota.FC_ID_TIPO_NOTA tipoNota,    ");
		query.append(" 		 		 nota.FD_FECHA_PUBLICACION fechaPublicacion,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PRINCIPAL imagenPrincipal,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PIE imagenPie,    ");
		query.append(" 		 		 nota.FC_TITULO titulo,  ");
		query.append(" 		 		 nota.FC_ID_TIPO_VIDEO tipoVideo,  ");
		query.append("               i_magazine.FC_ID_MAGAZINE idMagazine , ");
		query.append(" 		 		CONCAT(COALESCE(categoria.FC_FRIENDLY_URL,''),'/detalle/', COALESCE(nota.FC_FRIENDLY_URL,'')) friendlyUrl    ");
		query.append(" FROM yog_ba_n_nota nota   ");
		query.append(" LEFT JOIN 	  yog_ba_c_categoria categoria  ON nota.FC_ID_CATEGORIA=categoria.FC_ID_CATEGORIA            ");
		query.append(" LEFT JOIN     yog_ba_c_deporte deporte ON nota.FC_ID_DEPORTE= deporte.FC_ID_DEPORTE  ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_nota tipo_nota ON  nota.FC_ID_TIPO_NOTA= tipo_nota.FC_ID_TIPO_NOTA            ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_video tipo_video ON nota.FC_ID_TIPO_VIDEO= tipo_video.FC_ID_TIPO_VIDEO    ");
		query.append(" LEFT JOIN    yog_ba_i_nota_magazine i_magazine ON nota.FC_ID_CONTENIDO =  i_magazine.FC_ID_CONTENIDO ");
		query.append(" WHERE i_magazine.FC_ID_MAGAZINE is null  ");
		query.append(" AND nota.FC_ID_CATEGORIA = '"+idCategoria+"'  ");
		query.append(" AND nota.FC_ID_ESTATUS_NOTA = 'PUB' ");
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC   ");
		
		if(limit > 0)
			query.append(" LIMIT "+limit+"  ");
	

		try {

			logger.debug(""+query.toString());
			
			lista =   jdbcTemplate.query(query.toString(),  new BeanPropertyRowMapper<Nota>(Nota.class));
			
			

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesNotInMagazineByIdCategoria  [ NNotaDAO ] ! ", e);
			logger.error(" query : " + query);
			throw new DAOException(e.getMessage());
		}
		
		
		logger.debug("lista Size : "+lista.size());
		
		return lista ;
	}
	
	
	
	public List<Nota> getNotesByIdCategoria( String idCategoria ,int limit , String fechaIni  , String fechaFin  ) throws DAOException {
		logger.debug(" --- getNotesByIdCategoria  [ NNotaDAO ]  --- ");
		logger.debug(" ---  idCategoria : " + idCategoria + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");
		logger.debug(" ---  fechaIni : " + fechaIni + "  --- ");
		logger.debug(" ---  fechaFin : " + fechaFin + "  --- ");

		List<Nota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CATEGORIA idCategoria ,    ");
		query.append(" 		 		 nota.FC_ID_CONTENIDO idContenido ,   ");
		query.append(" 		 		 nota.FC_DESCRIPCION descripcion ,   ");
		query.append(" 		 		 deporte.FC_ID_DEPORTE idDeporte ,   ");
		query.append(" 		 		 deporte.FC_DESCRIPCION deporteDescripcion ,   ");
		query.append(" 		 	     categoria.FC_DESCRIPCION categoriaDescripcion,   ");
		query.append(" 		 		 nota.FC_FRIENDLY_URL nombre ,   ");
		query.append(" 		 		 nota.FC_ID_TIPO_NOTA tipoNota,    ");
		query.append(" 		 		 nota.FD_FECHA_PUBLICACION fechaPublicacion,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PRINCIPAL imagenPrincipal,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PIE imagenPie,    ");
		query.append(" 		 		 nota.FC_TITULO titulo,  ");
		query.append(" 		 		 nota.FC_ID_TIPO_VIDEO tipoVideo, ");
		query.append(" 		 		CONCAT(COALESCE(categoria.FC_FRIENDLY_URL,''),'/detalle/', COALESCE(nota.FC_FRIENDLY_URL,'')) friendlyUrl    ");
		query.append(" FROM yog_ba_n_nota nota   ");
		query.append(" LEFT JOIN 	  yog_ba_c_categoria categoria  ON nota.FC_ID_CATEGORIA=categoria.FC_ID_CATEGORIA            ");
		query.append(" LEFT JOIN     yog_ba_c_deporte deporte ON nota.FC_ID_DEPORTE= deporte.FC_ID_DEPORTE  ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_nota tipo_nota ON  nota.FC_ID_TIPO_NOTA= tipo_nota.FC_ID_TIPO_NOTA            ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_video tipo_video ON nota.FC_ID_TIPO_VIDEO= tipo_video.FC_ID_TIPO_VIDEO    ");
		query.append(" WHERE  nota.FC_ID_CATEGORIA = '"+idCategoria+"'  ");
		query.append(" AND nota.FC_ID_ESTATUS_NOTA = 'PUB' ");
		
		if(!fechaIni.equals("") && !fechaFin.equals(""))
		query.append(" AND nota.FD_FECHA_MODIFICACION BETWEEN '"+fechaIni+"' AND '"+fechaFin+"' ");
		
		
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC   ");
		
		if(limit > 0)
			query.append(" LIMIT "+limit+"  ");
	

		try {

			logger.debug(""+query.toString());
			
			lista =   jdbcTemplate.query(query.toString(),  new BeanPropertyRowMapper<Nota>(Nota.class));
			
			

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdCategoria  [ NNotaDAO ] ! ", e);
			logger.error(" query : " + query);
			throw new DAOException(e.getMessage());
		}
		
		
		logger.debug("lista Size : "+lista.size());
		
		return lista ;
	}
	
	
	public List<Nota> getNotesByIdDeporte( String idDeporte ,int limit , String fechaIni  , String fechaFin  ) throws DAOException {
		logger.debug(" --- getNotesByIdDeporte  [ NNotaDAO ]  --- ");
		logger.debug(" ---  idDeporte : " + idDeporte + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");
		logger.debug(" ---  fechaIni : " + fechaIni + "  --- ");
		logger.debug(" ---  fechaFin : " + fechaFin + "  --- ");

		List<Nota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CATEGORIA idCategoria ,    ");
		query.append(" 		 		 nota.FC_ID_CONTENIDO idContenido ,   ");
		query.append(" 		 		 nota.FC_DESCRIPCION descripcion ,   ");
		query.append(" 		 		 deporte.FC_ID_DEPORTE idDeporte ,   ");
		query.append(" 		 		 deporte.FC_DESCRIPCION deporteDescripcion ,   ");
		query.append(" 		 	     categoria.FC_DESCRIPCION categoriaDescripcion,   ");
		query.append(" 		 		 nota.FC_FRIENDLY_URL nombre ,   ");
		query.append(" 		 		 nota.FC_ID_TIPO_NOTA tipoNota,    ");
		query.append(" 		 		 nota.FD_FECHA_PUBLICACION fechaPublicacion,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PRINCIPAL imagenPrincipal,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PIE imagenPie,    ");
		query.append(" 		 		 nota.FC_TITULO titulo,  ");
		query.append(" 		 		 nota.FC_ID_TIPO_VIDEO tipoVideo, ");
		query.append(" 		 		CONCAT(COALESCE(categoria.FC_FRIENDLY_URL,''),'/detalle/', COALESCE(nota.FC_FRIENDLY_URL,'')) friendlyUrl    ");
		query.append(" FROM yog_ba_n_nota nota   ");
		query.append(" LEFT JOIN 	  yog_ba_c_categoria categoria  ON nota.FC_ID_CATEGORIA=categoria.FC_ID_CATEGORIA            ");
		query.append(" LEFT JOIN     yog_ba_c_deporte deporte ON nota.FC_ID_DEPORTE= deporte.FC_ID_DEPORTE  ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_nota tipo_nota ON  nota.FC_ID_TIPO_NOTA= tipo_nota.FC_ID_TIPO_NOTA            ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_video tipo_video ON nota.FC_ID_TIPO_VIDEO= tipo_video.FC_ID_TIPO_VIDEO    ");
		query.append(" WHERE deporte.FC_ID_DEPORTE = '"+idDeporte+"'  ");
		query.append(" AND nota.FC_ID_ESTATUS_NOTA = 'PUB' ");
		
		if(!fechaIni.equals("") && !fechaFin.equals(""))
		query.append(" AND nota.FD_FECHA_MODIFICACION BETWEEN '"+fechaIni+"' AND '"+fechaFin+"' ");
		
		
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC   ");
		
		if(limit > 0)
			query.append(" LIMIT "+limit+"  ");
	

		try {

			logger.debug(""+query.toString());
			
			lista =   jdbcTemplate.query(query.toString(),  new BeanPropertyRowMapper<Nota>(Nota.class));
			
			

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdDeporte  [ NNotaDAO ] ! ", e);
			logger.error(" query : " + query);
			throw new DAOException(e.getMessage());
		}
		
		
		logger.debug("lista Size : "+lista.size());
		
		return lista ;
	}
	
	
	
	
	public List<Nota> getNotesByIdCategoriaAndIdDeporte( String idCategoria ,String idDeporte ,int limit , String fechaIni  , String fechaFin  ) throws DAOException {
		logger.debug(" --- getNotesByIdCategoriaAndIdDeporte  [ NNotaDAO ]  --- ");
		logger.debug(" ---  idCategoria : " + idCategoria + "  --- ");
		logger.debug(" ---  idDeporte : " + idDeporte + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");
		logger.debug(" ---  fechaIni : " + fechaIni + "  --- ");
		logger.debug(" ---  fechaFin : " + fechaFin + "  --- ");

		List<Nota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CATEGORIA idCategoria ,    ");
		query.append(" 		 		 nota.FC_ID_CONTENIDO idContenido ,   ");
		query.append(" 		 		 nota.FC_DESCRIPCION descripcion ,   ");
		query.append(" 		 		 deporte.FC_ID_DEPORTE idDeporte ,   ");
		query.append(" 		 		 deporte.FC_DESCRIPCION deporteDescripcion ,   ");
		query.append(" 		 	     categoria.FC_DESCRIPCION categoriaDescripcion,   ");
		query.append(" 		 		 nota.FC_FRIENDLY_URL nombre ,   ");
		query.append(" 		 		 nota.FC_ID_TIPO_NOTA tipoNota,    ");
		query.append(" 		 		 nota.FD_FECHA_PUBLICACION fechaPublicacion,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PRINCIPAL imagenPrincipal,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PIE imagenPie,    ");
		query.append(" 		 		 nota.FC_TITULO titulo,  ");
		query.append(" 		 		 nota.FC_ID_TIPO_VIDEO tipoVideo, ");
		query.append(" 		 		CONCAT(COALESCE(categoria.FC_FRIENDLY_URL,''),'/detalle/', COALESCE(nota.FC_FRIENDLY_URL,'')) friendlyUrl    ");
		query.append(" FROM yog_ba_n_nota nota   ");
		query.append(" LEFT JOIN 	  yog_ba_c_categoria categoria  ON nota.FC_ID_CATEGORIA=categoria.FC_ID_CATEGORIA            ");
		query.append(" LEFT JOIN     yog_ba_c_deporte deporte ON nota.FC_ID_DEPORTE= deporte.FC_ID_DEPORTE  ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_nota tipo_nota ON  nota.FC_ID_TIPO_NOTA= tipo_nota.FC_ID_TIPO_NOTA            ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_video tipo_video ON nota.FC_ID_TIPO_VIDEO= tipo_video.FC_ID_TIPO_VIDEO    ");
		query.append(" WHERE  nota.FC_ID_CATEGORIA = '"+idCategoria+"'  ");
		query.append(" AND  deporte.FC_ID_DEPORTE = '"+idDeporte+"'  ");
		query.append(" AND nota.FC_ID_ESTATUS_NOTA = 'PUB' ");
		
		if(!fechaIni.equals("") && !fechaFin.equals(""))
		query.append(" AND nota.FD_FECHA_MODIFICACION BETWEEN '"+fechaIni+"' AND '"+fechaFin+"' ");
		
		
		
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC   ");
		
		if(limit > 0)
			query.append(" LIMIT "+limit+"  ");
	

		try {

			logger.debug(""+query.toString());
			
			lista =   jdbcTemplate.query(query.toString(),  new BeanPropertyRowMapper<Nota>(Nota.class));
			
			

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdCategoriaAndIdDeporte  [ NNotaDAO ] ! ", e);
			logger.error(" query : " + query);
			throw new DAOException(e.getMessage());
		}
		
		
		logger.debug("lista Size : "+lista.size());
		
		return lista ;
	}
	
	
	public List<Nota> getNotesByIdTipoVideo( String idTipoVideo , int limit , String fechaIni  , String fechaFin  ) throws DAOException {
		logger.debug(" --- getNotesByIdCategoriaAndIdDeporte  [ NNotaDAO ]  --- ");
		logger.debug(" ---  idTipoVideo : " + idTipoVideo + "  --- ");
		logger.debug(" ---  limit : " + limit + "  --- ");
		logger.debug(" ---  fechaIni : " + fechaIni + "  --- ");
		logger.debug(" ---  fechaFin : " + fechaFin + "  --- ");

		List<Nota> lista = null;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CATEGORIA idCategoria ,    ");
		query.append(" 		 		 nota.FC_ID_CONTENIDO idContenido ,   ");
		query.append(" 		 		 nota.FC_DESCRIPCION descripcion ,   ");
		query.append(" 		 		 deporte.FC_ID_DEPORTE idDeporte ,   ");
		query.append(" 		 		 deporte.FC_DESCRIPCION deporteDescripcion ,   ");
		query.append(" 		 	     categoria.FC_DESCRIPCION categoriaDescripcion,   ");
		query.append(" 		 		 nota.FC_FRIENDLY_URL nombre ,   ");
		query.append(" 		 		 nota.FC_ID_TIPO_NOTA tipoNota,    ");
		query.append(" 		 		 nota.FD_FECHA_PUBLICACION fechaPublicacion,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PRINCIPAL imagenPrincipal,    ");
		query.append(" 		 		 nota.FC_IMAGEN_PIE imagenPie,    ");
		query.append(" 		 		 nota.FC_TITULO titulo,  ");
		query.append(" 		 		 nota.FC_ID_TIPO_VIDEO tipoVideo, ");
		query.append(" 		 		CONCAT(COALESCE(categoria.FC_FRIENDLY_URL,''),'/detalle/', COALESCE(nota.FC_FRIENDLY_URL,'')) friendlyUrl    ");
		query.append(" FROM yog_ba_n_nota nota   ");
		query.append(" LEFT JOIN 	  yog_ba_c_categoria categoria  ON nota.FC_ID_CATEGORIA=categoria.FC_ID_CATEGORIA            ");
		query.append(" LEFT JOIN     yog_ba_c_deporte deporte ON nota.FC_ID_DEPORTE= deporte.FC_ID_DEPORTE  ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_nota tipo_nota ON  nota.FC_ID_TIPO_NOTA= tipo_nota.FC_ID_TIPO_NOTA            ");
		query.append(" LEFT JOIN     yog_ba_c_tipo_video tipo_video ON nota.FC_ID_TIPO_VIDEO= tipo_video.FC_ID_TIPO_VIDEO    ");
		query.append(" WHERE  nota.FC_ID_TIPO_VIDEO = '"+idTipoVideo+"'  ");
		query.append(" AND nota.FC_ID_ESTATUS_NOTA = 'PUB' ");
		
		
		if(!fechaIni.equals("") && !fechaFin.equals(""))
		query.append(" AND nota.FD_FECHA_MODIFICACION BETWEEN '"+fechaIni+"' AND '"+fechaFin+"' ");
		
		
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC   ");
		
		if(limit > 0)
			query.append(" LIMIT "+limit+"  ");
	

		try {

			logger.debug(""+query.toString());
			
			lista =   jdbcTemplate.query(query.toString(),  new BeanPropertyRowMapper<Nota>(Nota.class));
			
			

		} catch (Exception e) {
			logger.error(" ¡ Error getNotesByIdCategoriaAndIdDeporte  [ NNotaDAO ] ! ", e);
			logger.error(" query : " + query);
			throw new DAOException(e.getMessage());
		}
		
		
		logger.debug("lista Size : "+lista.size());
		
		return lista ;
	}
}
