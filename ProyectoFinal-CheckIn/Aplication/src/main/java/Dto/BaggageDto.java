package Dto;

public class BaggageDto {

    public Double PesoEquipaje;
    public String NumeroEtiqueta;
    public String Descripcion;

    public BaggageDto() {
    }

    public Double getPesoEquipaje() {
        return PesoEquipaje;
    }

    public void setPesoEquipaje(Double pesoEquipaje) {
        PesoEquipaje = pesoEquipaje;
    }

    public String getNumeroEtiqueta() {
        return NumeroEtiqueta;
    }

    public void setNumeroEtiqueta(String numeroEtiquta) {
        NumeroEtiqueta = numeroEtiquta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
