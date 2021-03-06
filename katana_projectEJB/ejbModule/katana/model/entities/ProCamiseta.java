package katana.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the pro_camiseta database table.
 * 
 */
@Entity
@Table(name="pro_camiseta")
@NamedQuery(name="ProCamiseta.findAll", query="SELECT p FROM ProCamiseta p")
public class ProCamiseta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_camiseta", unique=true, nullable=false)
	private Integer idCamiseta;

	@Column(nullable=false, length=500)
	private String imagen;

	@Column(length=500)
	private String imagen2;

	@Column(length=500)
	private String imagen3;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal precio;

	//bi-directional many-to-one association to ProPersonalizado
	@OneToMany(mappedBy="proCamiseta")
	private List<ProPersonalizado> proPersonalizados;

	public ProCamiseta() {
	}

	public Integer getIdCamiseta() {
		return this.idCamiseta;
	}

	public void setIdCamiseta(Integer idCamiseta) {
		this.idCamiseta = idCamiseta;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getImagen2() {
		return this.imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public String getImagen3() {
		return this.imagen3;
	}

	public void setImagen3(String imagen3) {
		this.imagen3 = imagen3;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<ProPersonalizado> getProPersonalizados() {
		return this.proPersonalizados;
	}

	public void setProPersonalizados(List<ProPersonalizado> proPersonalizados) {
		this.proPersonalizados = proPersonalizados;
	}

	public ProPersonalizado addProPersonalizado(ProPersonalizado proPersonalizado) {
		getProPersonalizados().add(proPersonalizado);
		proPersonalizado.setProCamiseta(this);

		return proPersonalizado;
	}

	public ProPersonalizado removeProPersonalizado(ProPersonalizado proPersonalizado) {
		getProPersonalizados().remove(proPersonalizado);
		proPersonalizado.setProCamiseta(null);

		return proPersonalizado;
	}

}