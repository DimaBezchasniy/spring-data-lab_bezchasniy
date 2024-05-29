package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.util.*

@Entity
data class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val brand: String,
    val model: String,
    val manufacturer: String,
    val releaseDate: Date,
    val maxSpeed: Int,
    val price: Double,
    val hasABS: Boolean,

    @OneToMany(mappedBy = "car", cascade = [CascadeType.ALL], orphanRemoval = true)
    val batteries: MutableList<Battery> = mutableListOf()
) : Comparable<Car> {
    override fun compareTo(other: Car): Int {
        val brandComparison = brand.compareTo(other.brand)
        return if (brandComparison != 0) brandComparison else id.compareTo(other.id)
    }
}

@Entity
data class Battery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val model: String,
    val manufacturer: String,
    val type: String,
    val capacity: Int,
    val releaseDate: Date,
    val chargeTime: Int,
    val fastCharge: Boolean,

    @ManyToOne
    @JoinColumn(name = "car_id")
    val car: Car
) : Comparable<Battery> {
    override fun compareTo(other: Battery): Int {
        val modelComparison = model.compareTo(other.model)
        return if (modelComparison != 0) modelComparison else id.compareTo(other.id)
    }
}
