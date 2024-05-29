package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.entity.Car
import ua.kpi.its.lab.data.entity.Battery
import ua.kpi.its.lab.data.svc.impl.CarServiceImpl
import ua.kpi.its.lab.data.svc.impl.BatteryServiceImpl
import java.util.*

fun main() {
    val context = AnnotationConfigApplicationContext("ua.kpi.its.lab.data")
    val carService = context.getBean(CarServiceImpl::class.java)
    val batteryService = context.getBean(BatteryServiceImpl::class.java)

    // Створюємо 5 автомобілів та додаткові акумулятори
    val car1 = Car(
        brand = "Tesla",
        model = "Model S",
        manufacturer = "Tesla, Inc.",
        releaseDate = Date(2012, 6, 22),
        maxSpeed = 250,
        price = 79990.0,
        hasABS = true
    )
    val car2 = Car(
        brand = "BMW",
        model = "3 Series",
        manufacturer = "Bayerische Motoren Werke AG",
        releaseDate = Date(2019, 3, 15),
        maxSpeed = 155,
        price = 40000.0,
        hasABS = true
    )

    val car3 = Car(
        brand = "Toyota",
        model = "Camry",
        manufacturer = "Toyota Motor Corporation",
        releaseDate = Date(1982, 11, 1),
        maxSpeed = 125,
        price = 24900.0,
        hasABS = true
    )

    val car4 = Car(
        brand = "Ford",
        model = "Mustang",
        manufacturer = "Ford Motor Company",
        releaseDate = Date(1964, 4, 17),
        maxSpeed = 180,
        price = 27895.0,
        hasABS = true
    )

    val car5 = Car(
        brand = "Mercedes-Benz",
        model = "C-Class",
        manufacturer = "Daimler AG",
        releaseDate = Date(1993, 5, 1),
        maxSpeed = 155,
        price = 41550.0,
        hasABS = true
    )
    val battery1 = Battery(
        model = "Model S Long Range",
        manufacturer = "Tesla, Inc.",
        type = "Lithium-ion",
        capacity = 100,
        releaseDate = Date(2020, 1, 1),
        chargeTime = 12,
        fastCharge = true,
        car = car1
    )

    // Додаємо створені автомобілі та акумулятори в БД
    carService.create(car1)
    carService.create(car2)
    carService.create(car3)
    carService.create(car4)
    carService.create(car5)

    batteryService.create(battery1)

    println("Retrieved car: $car3")

    // Видаляємо автомобіль з індексом 4
    carService.delete(id = 4)
}
