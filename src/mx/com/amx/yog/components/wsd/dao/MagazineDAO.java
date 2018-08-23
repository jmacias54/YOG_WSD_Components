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
import mx.com.amx.yog.components.wsd.model.Magazine;


/**
 * @author  Jesus Armando Macias Benitez
 *
 */
public class MagazineDAO {
	
	
private static Logger logger = Logger.getLogger(MagazineDAO.class);
	
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public Magazine findById(String idMagazine)throws DAOException {
		logger.debug(" --- findById [ MagazineDAO ] --- ");
		logger.debug(" --- idMagazine : "+idMagazine+" --- ");
		
		
		List<Magazine> lista = null;
		StringBuilder query = new StringBuilder();

			query.append(" SELECT FC_ID_MAGAZINE , ");
			query.append(" FC_TITULO , ");
			query.append(" FI_ESTATUS , ");
			query.append(" FI_REGISTROS  ");
			query.append(" FROM yog_ba_c_magazine WHERE FC_ID_MAGAZINE = '" + idMagazine + "' ");

		try {
			
			logger.debug(" query : "+query.toString());
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Magazine>(Magazine.class));
			
			
		} catch (NullPointerException npe) {
			logger.error(" ¡ Error findById  [ MagazineDAO ] ! ", npe);
			throw new DAOException(npe.getMessage());
		} catch (Exception e) {
			logger.error(" ¡ Error findById  [ MagazineDAO ] ! ", e);
			throw new DAOException(e.getMessage());
		}
		
		if (lista == null ) {
			return null;
		}
		
		logger.debug(" lista  size "+lista.size());
		return lista.get(0);

	}
	
	
	
	public List<Magazine> findAll() throws DAOException {
		logger.debug(" --- findAll [ MagazineDAO ] --- ");
		
		
		List<Magazine> lista = null;
		StringBuilder query = new StringBuilder();

		query.append(" SELECT FC_ID_MAGAZINE , ");
		query.append(" FC_TITULO , ");
		query.append(" FI_ESTATUS , ");
		query.append(" FI_REGISTROS  ");
		query.append(" FROM yog_ba_c_magazine ");
		

		try {
			
			
			logger.debug(" query : "+query.toString());
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Magazine>(Magazine.class));

		} catch (NullPointerException npe) {
			logger.error(" ¡ Error findAll  [ MagazineDAO ] ! ", npe);
			return Collections.emptyList();
		} catch (Exception e) {
			logger.error(" ¡ Error findAll  [ MagazineDAO ] ! ", e);
			throw new DAOException(e.getMessage());
		}

		logger.debug(" lista  size "+lista.size());
		return lista;
	}


}
