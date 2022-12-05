package Fabrica.entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the PRODUCTOS database table.
 * 
 */
@Entity
@Table(name="PRODUCTOS")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO")
	private int idProducto;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ALTA")
	private Date fechaAlta;

	@Column(name="PRECIO_UNITARIO")
	private BigDecimal precioUnitario;

	//uni-directional many-to-one association to Familia
	@ManyToOne
	@JoinColumn(name="ID_FAMILIA")
	private Familia familia;

	public Producto() {
	}

	public Producto(int idProducto, String descripcion, Date fechaAlta, BigDecimal precioUnitario, Familia familia) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.fechaAlta = fechaAlta;
		this.precioUnitario = precioUnitario;
		this.familia = familia;
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Familia getFamilia() {
		return this.familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", fechaAlta=" + fechaAlta
				+ ", precioUnitario=" + precioUnitario + ", familia=" + familia + "]";
	}

}