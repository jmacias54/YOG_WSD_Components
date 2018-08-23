/**
 * @author Jesus Armando Macias Benitez
 */
package mx.com.amx.yog.components.wsd.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.yog.components.wsd.dao.exception.DAOException;
import mx.com.amx.yog.components.wsd.model.Deporte;



/**
 * @author  Jesus Armando Macias Benitez
 *
 */
public class DeporteDAO {
private static Logger logger = Logger.getLogger(DeporteDAO.class);
	
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public Deporte findById(String idDeporte )throws DAOException {
		logger.debug(" --- findById [ DeporteDAO ] --- ");
		logger.debug(" --- idCategoria : "+idDeporte+" --- ");
		
		
		List<Deporte> lista = null;
		StringBuilder query = new StringBuilder();
		query.append("  SELECT FC_ID_DEPORTE , ");
		query.append("  FC_DESCRIPCION , ");
		query.append("  FI_ESTATUS ");
		query.append("  FROM yog_ba_c_deporte WHERE FC_ID_DEPORTE = '" + idDeporte + "' ;");

		try {
			
			logger.debug(" query : "+query.toString());
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Deporte>(Deporte.class));
			
			
		} catch (Exception e) {
			logger.error(" ¡ Error findById  [ DeporteDAO ] ! ", e);
			throw new DAOException(e.getMessage());
		}
		
		if (lista == null ) {
			return null;
		}
		
		logger.debug(" lista  size "+lista.size());
		return lista.get(0);

	}
	
	
	
	public List<Deporte> findAll() throws DAOException {
		logger.debug(" --- findAll [ DeporteDAO ] --- ");
		
		
		List<Deporte> lista = null;
		StringBuilder query = new StringBuilder();
		query.append("  SELECT FC_ID_DEPORTE , ");
		query.append("  FC_DESCRIPCION , ");
		query.append("  FI_ESTATUS ");
		query.append(" FROM yog_ba_c_deporte ;");
		

		try {
			
			
			logger.debug(" query : "+query.toString());
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Deporte>(Deporte.class));

		} catch (Exception e) {
			logger.error(" ¡ Error findAll  [ DeporteDAO ] ! ", e);
			throw new DAOException(e.getMessage());
		}

		return lista;
	}
}
