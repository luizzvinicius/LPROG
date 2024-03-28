package java;
public class Empregado {
    private String nome;
    private long id;
    private String cargo;
    private double salario;
    private Departamento departamento;

    public Empregado(Departamento d, String nome, long id, String cargo, double salario) {
        this.nome = nome;
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = d;
    }

    public void transferir(Departamento dep) {
        this.setDepartamento(dep);
    }

    public long getDepartamento() {
        return this.departamento.getId();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}