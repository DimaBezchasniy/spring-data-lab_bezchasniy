package ua.kpi.its.lab.data.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.Car
import ua.kpi.its.lab.data.entity.Battery
import ua.kpi.its.lab.data.repo.CarRepository
import ua.kpi.its.lab.data.repo.BatteryRepository
import ua.kpi.its.lab.data.svc.CarService
import ua.kpi.its.lab.data.svc.BatteryService

@Service
class CarServiceImpl(private val repo: CarRepository) : CarService {
    override fun create(car: Car) = repo.save(car)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(car: Car) = repo.save(car)
    override fun delete(id: Long) = repo.deleteById(id)
}

@Service
class BatteryServiceImpl(private val repo: BatteryRepository) : BatteryService {
    override fun create(battery: Battery) = repo.save(battery)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(battery: Battery) = repo.save(battery)
    override fun delete(id: Long) = repo.deleteById(id)
}
