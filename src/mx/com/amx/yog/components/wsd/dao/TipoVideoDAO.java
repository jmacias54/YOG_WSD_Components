/**
 * @author Jesus Armando Macias Benitez
 */
package mx.com.amx.yog.components.wsd.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.yog.components.wsd.dao.exception.DAOException;
import mx.com.amx.yog.components.wsd.model.TipoVideo;

/**
 * @author  Jesus Armando Macias Benitez
 *
 */
public class TipoVideoDAO {
private static Logger logger = Logger.getLogger(TipoVideoDAO.class);
	
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public TipoVideo findById(String idTipoVideo)throws DAOException {
		logger.debug(" --- findById [ TipoVideoDAO ] --- ");
		logger.debug(" --- idTipoVideo : "+idTipoVideo+" --- ");
		
		
		List<TipoVideo> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT FC_ID_TIPO_VIDEO , ");
		query.append(" FC_DESCRIPCION , ");
		query.append(" FI_ESTATUS ");
		query.append(" FROM yog_ba_c_tipo_video WHERE FC_ID_TIPO_VIDEO = '" + idTipoVideo + "' ");

		try {
			
			logger.debug(" query : "+query.toString());
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<TipoVideo>(TipoVideo.class));
			
			
		} catch (NullPointerException npe) {
			logger.error(" ¡ Error findById  [ TipoVideoDAO ] ! ", npe);
			throw new DAOException(npe.getMessage());
		} catch (Exception e) {
			logger.error(" ¡ Error findById  [ TipoVideoDAO ] ! ", e);
			throw new DAOException(e.getMessage());
		}
		
		if (lista == null ) {
			return null;
		}
		logger.debug(" lista  size "+lista.size());
		return lista.get(0);

	}
	
	
	
	public List<TipoVideo> findAll() throws DAOException {
		logger.debug(" --- findAll [ TipoVideoDAO ] --- ");
		
		
		List<TipoVideo> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT FC_ID_TIPO_VIDEO , ");
		query.append(" FC_DESCRIPCION , ");
		query.append(" FI_ESTATUS ");
		query.append(" FROM yog_ba_c_tipo_video ");
		

		try {
			
			
			logger.debug(" query : "+query.toString());
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<TipoVideo>(TipoVideo.class));

		} catch (NullPointerException npe) {
			logger.error(" ¡ Error findAll  [ TipoVideoDAO ] ! ", npe);
			return Collections.emptyList();
		} catch (Exception e) {
			logger.error(" ¡ Error findAll  [ TipoVideoDAO ] ! ", e);
			throw new DAOException(e.getMessage());
		}
		logger.debug(" lista  size "+lista.size());
		return lista;
	}


}
