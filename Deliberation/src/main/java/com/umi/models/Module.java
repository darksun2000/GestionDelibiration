package com.umi.models;

import com.umi.models.Element;
import com.umi.models.Semestre;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Module")
public class Module {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_module")
    private int id_module;
    @Column(name="libelle_module")
    private String libelle_module;
    @Column(name="coeficient")
    private Double coeficient = 1d;
    @Column(name="validation")
    private Double validation = 10d;
    @Column(name="eliminatoire")
    private Double eliminatoire = 4d;
    @OneToMany(cascade=CascadeType.REMOVE, mappedBy="module")
    private List<Element> elements = new ArrayList<Element>();
    @ManyToOne
    @JoinColumn(name="semestre", foreignKey=@ForeignKey(name="fk_semestre"))
    @NotFound(action = NotFoundAction.IGNORE)
    private Semestre semestre;
    
    @ManyToOne
    @JoinColumn(name="professeur", foreignKey=@ForeignKey(name="fk_professeur"))
    private Professeur professeur;

    public Module() {
    }

    

    public Module(int id_module, String libelle_module, Double coeficient, Double validation, Double eliminatoire,
			List<Element> elements, Semestre semestre) {
		super();
		this.id_module = id_module;
		this.libelle_module = libelle_module;
		this.coeficient = coeficient;
		this.validation = validation;
		this.eliminatoire = eliminatoire;
		this.elements = elements;
		this.semestre = semestre;
	}

    public Module(String libelle_module, Semestre semestre) {
    	this.libelle_module = libelle_module;
    	this.semestre = semestre;
    	this.coeficient = 1d;
    	this.validation = 10d;
    	this.eliminatoire = 4d;
    }

	public Double getEliminatoire() {
		return eliminatoire;
	}



	public void setEliminatoire(Double eliminatoire) {
		this.eliminatoire = eliminatoire;
	}



	public Double getCoeficient() {
        return this.coeficient;
    }

    public void setCoeficient(Double coeficient) {
        this.coeficient = coeficient;
    }

    public int getId_module() {
        return this.id_module;
    }

    public void setId_module(int id_module) {
        this.id_module = id_module;
    }

    public String getLibelle_module() {
        return this.libelle_module;
    }

    public void setLibelle_module(String libelle_module) {
        this.libelle_module = libelle_module;
    }

    public Semestre getSemestre() {
        return this.semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Double getValidation() {
        return this.validation;
    }

    public void setValidation(Double validation) {
        this.validation = validation;
    }

    public List<Element> getElements() {
        return this.elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
}