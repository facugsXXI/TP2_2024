package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(718971,53219d), SALTA(1333000,155488d), TUCUMAN(1593000 , 22525d), CATAMARCA(0,0d), LA_RIOJA(0,0d), SANTIAGO_DEL_ESTERO(0,0d);
	
	private int cantidadPoblacion;
	private double superficie;
	
	private Provincia(int cantidadPoblacion, double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensidadPoblacional() {
        if (superficie != 0) {
            return cantidadPoblacion / superficie;
        } else {
            return 0;
        }
    }
	
	
}
