package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.Car
import ua.kpi.its.lab.data.entity.Battery

interface CarService {
    fun create(car: Car): Car
    fun retrieve(id: Long): Car?
    fun update(car: Car): Car
    fun delete(id: Long)

}

interface BatteryService {
    fun create(battery: Battery): Battery
    fun retrieve(id: Long): Battery?
    fun update(battery: Battery): Battery
    fun delete(id: Long)
}
