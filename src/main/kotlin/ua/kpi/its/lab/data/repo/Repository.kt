package ua.kpi.its.lab.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import ua.kpi.its.lab.data.entity.Car
import ua.kpi.its.lab.data.entity.Battery

interface CarRepository : JpaRepository<Car, Long> {
    // додаткові методи, якщо потрібно
}

interface BatteryRepository : JpaRepository<Battery, Long> {
    // додаткові методи, якщо потрібно
}
