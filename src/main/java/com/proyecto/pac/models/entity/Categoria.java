// Generated with g9.

package com.proyecto.pac.models.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="categoria")
public class Categoria implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idcategoria";

    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idcategoria;
    @Column(nullable=false, length=30)
    private String nombrec;
    @Column(nullable=false, length=255)
    private String descripcion;
    @OneToMany(mappedBy="categoria")
    private Set<Productos> productos;

    /** Default constructor. */
    public Categoria() {
        super();
    }

    /**
     * Access method for idcategoria.
     *
     * @return the current value of idcategoria
     */
    public int getIdcategoria() {
        return idcategoria;
    }

    /**
     * Setter method for idcategoria.
     *
     * @param aIdcategoria the new value for idcategoria
     */
    public void setIdcategoria(int aIdcategoria) {
        idcategoria = aIdcategoria;
    }

    /**
     * Access method for nombrec.
     *
     * @return the current value of nombrec
     */
    public String getNombrec() {
        return nombrec;
    }

    /**
     * Setter method for nombrec.
     *
     * @param aNombrec the new value for nombrec
     */
    public void setNombrec(String aNombrec) {
        nombrec = aNombrec;
    }

    /**
     * Access method for descripcion.
     *
     * @return the current value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter method for descripcion.
     *
     * @param aDescripcion the new value for descripcion
     */
    public void setDescripcion(String aDescripcion) {
        descripcion = aDescripcion;
    }

    /**
     * Access method for productos.
     *
     * @return the current value of productos
     */
    public Set<Productos> getProductos() {
        return productos;
    }

    /**
     * Setter method for productos.
     *
     * @param aProductos the new value for productos
     */
    public void setProductos(Set<Productos> aProductos) {
        productos = aProductos;
    }

    /**
     * Compares the key for this instance with another Categoria.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Categoria and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Categoria)) {
            return false;
        }
        Categoria that = (Categoria) other;
        if (this.getIdcategoria() != that.getIdcategoria()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Categoria.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Categoria)) return false;
        return this.equalKeys(other) && ((Categoria)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getIdcategoria();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Categoria |");
        sb.append(" idcategoria=").append(getIdcategoria());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idcategoria", Integer.valueOf(getIdcategoria()));
        return ret;
    }

}
