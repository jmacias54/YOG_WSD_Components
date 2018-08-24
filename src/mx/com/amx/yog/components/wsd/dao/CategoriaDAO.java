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
import mx.com.amx.yog.components.wsd.model.Categoria;



/**
 * @author  Jesus Armando Macias Benitez
 *
 */
public class CategoriaDAO {

	private static Logger logger = Logger.getLogger(CategoriaDAO.class);
	
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public Categoria findById(String idCategoria)throws DAOException {
		logger.debug(" --- findById [ CategoriaDAO ] --- ");
		logger.debug(" --- idCategoria : "+idCategoria+" --- ");
		
		
		List<Categoria> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  FC_ID_CATEGORIA , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FC_FRIENDLY_URL , ");
		query.append("   FI_ESTATUS , ");
		query.append("   FC_DFP  ");
		query.append("  FROM yog_ba_c_categoria WHERE FC_ID_CATEGORIA = '" + idCategoria + "' ;");

		try {
			
			logger.debug(" query : "+query.toString());
			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<Categoria>(Categoria.class));
			
			
		} catch (Exception e) {
			logger.error(" ¡ Error findById  [ CategoriaDAO ] ! ", e);
			throw new DAOException(e.getMessage());
		}
		
		if (lista == null ) {
			return null;
		}
		logger.debug(" lista  size "+lista.size());
		return lista.get(0);

	}
	
	
	
	public List<Categoria> findAll() throws DAOException {
		logger.debug(" --- findAll [ CategoriaDAO ] --- ");
		
		
		List<Categoria> lista = null;
		StringBuilder query = new StringBuilder();
		query.append(" SELECT  FC_ID_CATEGORIA , ");
		query.append("   FC_DESCRIPCION , ");
		query.append("   FC_FRIENDLY_URL , ");
		query.append("   FI_ESTATUS , ");
		query.append("   FC_DFP  ");
		query.append(" FROM yog_ba_c_categoria ");
		

		try {
			
			
			logger.debug(" query : "+query.toString());
			lista = jdbcTemplate.query(query.toString(),
					new BeanPropertyRowMapper<Categoria>(Categoria.class));

		} catch (Exception e) {
			logger.error(" ¡ Error findAll  [ CategoriaDAO ] ! ", e);
			throw new DAOException(e.getMessage());
		}
		
		
		logger.debug(" lista  size "+lista.size());

		return lista;
	}

	
}
