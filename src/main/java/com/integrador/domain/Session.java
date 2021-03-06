package com.integrador.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Session.
 */
@Entity
@Table(name = "session")
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "semester", nullable = false)
    private Integer semester;

    @NotNull
    @Column(name = "jhi_date", nullable = false)
    private ZonedDateTime date;

    @ManyToOne
    private Course course;

    @ManyToMany
    @JoinTable(name = "session_material",
               joinColumns = @JoinColumn(name="sessions_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="materials_id", referencedColumnName="id"))
    private Set<Material> materials = new HashSet<>();

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Session name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Session description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSemester() {
        return semester;
    }

    public Session semester(Integer semester) {
        this.semester = semester;
        return this;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Session date(ZonedDateTime date) {
        this.date = date;
        return this;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public Session course(Course course) {
        this.course = course;
        return this;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public Session materials(Set<Material> materials) {
        this.materials = materials;
        return this;
    }

    public Session addMaterial(Material material) {
        this.materials.add(material);
        return this;
    }

    public Session removeMaterial(Material material) {
        this.materials.remove(material);
        return this;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Session session = (Session) o;
        if (session.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), session.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Session{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", semester='" + getSemester() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }
}
