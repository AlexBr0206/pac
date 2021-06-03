// Generated with g9.

package com.proyecto.pac.models.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="productos")
public class Productos implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idproducto";

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idproducto;
    @Column(nullable=false, length=50)
    private String nombrep;
    @Column(nullable=false, precision=6, scale=2)
    private float precio;
    @Column(nullable=false, length=255)
    private String descripcion;
    @ManyToOne(optional=false)
    @JoinColumn(name="idcategoria", nullable=false)
    private Categoria categoria;

private String imagen;
    /** Default constructor. */
    public Productos() {
        super();
    }

    /**
     * Access method for idproducto.
     *
     * @return the current value of idproducto
     */
    public int getIdproducto() {
        return idproducto;
    }

    /**
     * Setter method for idproducto.
     *
     * @param aIdproducto the new value for idproducto
     */
    public void setIdproducto(int aIdproducto) {
        idproducto = aIdproducto;
    }

    /**
     * Access method for nombrep.
     *
     * @return the current value of nombrep
     */
    public String getNombrep() {
        return nombrep;
    }

    /**
     * Setter method for nombrep.
     *
     * @param aNombrep the new value for nombrep
     */
    public void setNombrep(String aNombrep) {
        nombrep = aNombrep;
    }

    /**
     * Access method for precio.
     *
     * @return the current value of precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Setter method for precio.
     *
     * @param aPrecio the new value for precio
     */
    public void setPrecio(float aPrecio) {
        precio = aPrecio;
    }

    /**
     * Access method for descripcion.
     *
     * @return the current value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    
    
    public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
     * Access method for categoria.
     *
     * @return the current value of categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Setter method for categoria.
     *
     * @param aCategoria the new value for categoria
     */
    public void setCategoria(Categoria aCategoria) {
        categoria = aCategoria;
    }

    /**
     * Compares the key for this instance with another Productos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Productos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Productos)) {
            return false;
        }
        Productos that = (Productos) other;
        if (this.getIdproducto() != that.getIdproducto()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Productos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Productos)) return false;
        return this.equalKeys(other) && ((Productos)other).equalKeys(this);
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
        i = getIdproducto();
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
        StringBuffer sb = new StringBuffer("[Productos |");
        sb.append(" idproducto=").append(getIdproducto());
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
        ret.put("idproducto", Integer.valueOf(getIdproducto()));
        return ret;
    }

}
