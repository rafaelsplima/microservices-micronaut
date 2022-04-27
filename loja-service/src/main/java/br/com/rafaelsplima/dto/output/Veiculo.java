package br.com.rafaelsplima.dto.output;

public class Veiculo {
    private Long id;
    private String modelo;
    private String marca;
    private String placa;

    public Veiculo(){}

    public Veiculo(Long id, String modelo, String marca, String placa) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
