package com.example.productos.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="producto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private int codigo;
	
	@Column(name="descripcion")
    private String descripcion;
	
	@Column(name="cantidad")
    private int cantidad;
	
	@Column(name="precio_venta")
    private float precio_venta;
	
	@Column(name="categoria_id")
    private int categoria_id;
	
//	@ManyToOne(fetch = FetchType.LAZY,optional=false)
//	@JoinColumn(name="categoria_id")
//	@JsonProperty(access= Access.WRITE_ONLY)
//	private Categoria categoria;
//	
	
	
	
}
