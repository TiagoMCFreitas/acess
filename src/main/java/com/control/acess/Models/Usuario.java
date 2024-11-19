package com.control.acess.Models;

import com.control.acess.Enums.RoleName;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.List;
import java.util.Objects;

@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean ativo;
    @Column(nullable = false)
    private String cargo;


    public Usuario() {}

    public Usuario(Long id, String nome, String email, String password, Boolean ativo, String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.ativo = ativo;
        this.cargo = cargo;

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ativo=" + ativo +
                ", cargo='" + cargo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(password, usuario.password) && Objects.equals(ativo, usuario.ativo) && Objects.equals(cargo, usuario.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, password, ativo, cargo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
