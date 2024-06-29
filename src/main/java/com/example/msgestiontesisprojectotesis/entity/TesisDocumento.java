package com.example.msgestiontesisprojectotesis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class TesisDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProyecto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProyectoTesis proyectoTesis;

    private String nombreDocumento;
    private String tipoArchivo;
    private String rutaArchivo;

    @Column(name = "fecha_subida")
    private LocalDateTime fechaSubida;

    @PrePersist
    protected void onCreate() {
        fechaSubida = LocalDateTime.now();
    }
}
