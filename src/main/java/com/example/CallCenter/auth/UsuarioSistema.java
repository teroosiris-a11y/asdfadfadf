package com.example.CallCenter.auth;

public class UsuarioSistema {

    private int id;
    private String usuario;
    private String contrasenia;
    private String rol;
    private Integer idEmpresa;
    private Integer idAgente;
    private String estado;

    public UsuarioSistema() {
    }

    public UsuarioSistema(int id, String usuario, String contrasenia, String rol, Integer idEmpresa, Integer idAgente, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.idEmpresa = idEmpresa;
        this.idAgente = idAgente;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Integer getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(Integer idEmpresa) { this.idEmpresa = idEmpresa; }

    public Integer getIdAgente() { return idAgente; }
    public void setIdAgente(Integer idAgente) { this.idAgente = idAgente; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
