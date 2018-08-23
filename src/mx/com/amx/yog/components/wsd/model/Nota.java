/**
 * 
 */
package mx.com.amx.yog.components.wsd.model;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class Nota {

	private String nombre;
	private String idCategoria;
	private String tipoNota;
	private String fechaPublicacion;
	private String imagenPrincipal;
	private String imagenPie;
	private String titulo;
	private String friendlyUrl;
	private String tags;
	private String categoriaDescripcion;

	private String idContenido;
	private String descripcion;
	private String idSeccion;
	private String seccionDescripcion;
	private String urlExterna;
	
	
	private String idDeporte;
	private String deporteDescripcion;
	private String tipoVideo;
	
	
	

	public String getUrlExterna() {
		return urlExterna;
	}

	public void setUrlExterna(String urlExterna) {
		this.urlExterna = urlExterna;
	}

	public String getIdContenido() {
		return idContenido;
	}

	public void setIdContenido(String idContenido) {
		this.idContenido = idContenido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(String idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getSeccionDescripcion() {
		return seccionDescripcion;
	}

	public void setSeccionDescripcion(String seccionDescripcion) {
		this.seccionDescripcion = seccionDescripcion;
	}

	public String getCategoriaDescripcion() {
		return categoriaDescripcion;
	}

	public void setCategoriaDescripcion(String categoriaDescripcion) {
		this.categoriaDescripcion = categoriaDescripcion;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getImagenPrincipal() {
		return imagenPrincipal;
	}

	public void setImagenPrincipal(String imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}

	public String getImagenPie() {
		return imagenPie;
	}

	public void setImagenPie(String imagenPie) {
		this.imagenPie = imagenPie;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFriendlyUrl() {
		return friendlyUrl;
	}

	public void setFriendlyUrl(String friendlyUrl) {
		this.friendlyUrl = friendlyUrl;
	}

	public String getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(String idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getDeporteDescripcion() {
		return deporteDescripcion;
	}

	public void setDeporteDescripcion(String deporteDescripcion) {
		this.deporteDescripcion = deporteDescripcion;
	}

	public String getTipoVideo() {
		return tipoVideo;
	}

	public void setTipoVideo(String tipoVideo) {
		this.tipoVideo = tipoVideo;
	}

	@Override
	public String toString() {
		return "Nota [nombre=" + nombre + ", idCategoria=" + idCategoria + ", tipoNota=" + tipoNota
				+ ", fechaPublicacion=" + fechaPublicacion + ", imagenPrincipal=" + imagenPrincipal + ", imagenPie="
				+ imagenPie + ", titulo=" + titulo + ", friendlyUrl=" + friendlyUrl + ", tags=" + tags
				+ ", categoriaDescripcion=" + categoriaDescripcion + ", idContenido=" + idContenido + ", descripcion="
				+ descripcion + ", idSeccion=" + idSeccion + ", seccionDescripcion=" + seccionDescripcion
				+ ", urlExterna=" + urlExterna + ", idDeporte=" + idDeporte + ", deporteDescripcion="
				+ deporteDescripcion + ", tipoVideo=" + tipoVideo + "]";
	}




	

}
