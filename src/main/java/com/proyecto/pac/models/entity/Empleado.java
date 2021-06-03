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


@Entity(name="empleado")
public class Empleado implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "idempleado";

    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int idempleado;
    @Column(nullable=false, length=15)
    private String alias;
    @Column(nullable=false, length=100)
    private String correoe;
    @Column(nullable=false, length=50)
    private String nombre;
    @Column(nullable=false, length=20)
    private byte[] claveacceso;
    
    /** Default constructor. */
    public Empleado() {
        super();
    }

    /**
     * Access method for idempleado.
     *
     * @return the current value of idempleado
     */
    public int getIdempleado() {
        return idempleado;
    }

    /**
     * Setter method for idempleado.
     *
     * @param aIdempleado the new value for idempleado
     */
    public void setIdempleado(int aIdempleado) {
        idempleado = aIdempleado;
    }

    /**
     * Access method for alias.
     *
     * @return the current value of alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Setter method for alias.
     *
     * @param aAlias the new value for alias
     */
    public void setAlias(String aAlias) {
        alias = aAlias;
    }

    /**
     * Access method for correoe.
     *
     * @return the current value of correoe
     */
    public String getCorreoe() {
        return correoe;
    }

    /**
     * Setter method for correoe.
     *
     * @param aCorreoe the new value for correoe
     */
    public void setCorreoe(String aCorreoe) {
        correoe = aCorreoe;
    }

    /**
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for claveacceso.
     *
     * @return the current value of claveacceso
     */
    public byte[] getClaveacceso() {
        return claveacceso;
    }

    /**
     * Setter method for claveacceso.
     *
     * @param aClaveacceso the new value for claveacceso
     */
    public void setClaveacceso(byte[] aClaveacceso) {
        claveacceso = aClaveacceso;
    }

    

	/**
     * Compares the key for this instance with another Empleado.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Empleado and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Empleado)) {
            return false;
        }
        Empleado that = (Empleado) other;
        if (this.getIdempleado() != that.getIdempleado()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Empleado.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Empleado)) return false;
        return this.equalKeys(other) && ((Empleado)other).equalKeys(this);
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
        i = getIdempleado();
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
        StringBuffer sb = new StringBuffer("[Empleado |");
        sb.append(" idempleado=").append(getIdempleado());
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
        ret.put("idempleado", Integer.valueOf(getIdempleado()));
        return ret;
    }

}
