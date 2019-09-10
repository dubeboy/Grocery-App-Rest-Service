package za.co.dubedivine.groceryapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GroceryAppApplication

fun main(args: Array<String>) {
	runApplication<GroceryAppApplication>(*args)
}
