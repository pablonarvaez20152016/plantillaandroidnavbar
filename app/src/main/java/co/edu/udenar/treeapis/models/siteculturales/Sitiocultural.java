package co.edu.udenar.treeapis.models.siteculturales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sitiocultural {
    @SerializedName("entidad_cargo")
    @Expose
    private String entidadCargo;
    @SerializedName("representante")
    @Expose
    private String representante;
    @SerializedName("direccion")
    @Expose
    private String direccionsite;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("telefono")
    @Expose
    private String telefono;
    @SerializedName("latitud")
    @Expose
    private String latitudsite;
    @SerializedName("longitud")
    @Expose
    private String longitudsite;
    @SerializedName("geocoded_column")
    @Expose
    private GeocodedColumn geocodedColumn;

    public String getEntidadCargo() {
        return entidadCargo;
    }

    public void setEntidadCargo(String entidadCargo) {
        this.entidadCargo = entidadCargo;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getDireccionsite() {
        return direccionsite;
    }

    public void setDireccionsite(String direccion) {
        this.direccionsite = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLatitud() {
        return latitudsite;
    }

    public void setLatitud(String latitud) {
        this.latitudsite = latitud;
    }

    public String getLongitud() {
        return longitudsite;
    }

    public void setLongitud(String longitud) {
        this.longitudsite = longitud;
    }

    public GeocodedColumn getGeocodedColumn() {
        return geocodedColumn;
    }

    public void setGeocodedColumn(GeocodedColumn geocodedColumn) {
        this.geocodedColumn = geocodedColumn;
    }
}
