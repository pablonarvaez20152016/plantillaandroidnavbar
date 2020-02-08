package co.edu.udenar.treeapis.models.Escenarios_depor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cancha {

    @SerializedName("comuna")
    @Expose
    private String comuna;
    @SerializedName("localizacion")
    @Expose
    private String localizacion;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("matricula_inmobiliaria")
    @Expose
    private String matriculaInmobiliaria;
    @SerializedName("adminstracion")
    @Expose
    private String adminstracion;

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatriculaInmobiliaria() {
        return matriculaInmobiliaria;
    }

    public void setMatriculaInmobiliaria(String matriculaInmobiliaria) {
        this.matriculaInmobiliaria = matriculaInmobiliaria;
    }

    public String getAdminstracion() {
        return adminstracion;
    }

    public void setAdminstracion(String adminstracion) {
        this.adminstracion = adminstracion;
    }

}
