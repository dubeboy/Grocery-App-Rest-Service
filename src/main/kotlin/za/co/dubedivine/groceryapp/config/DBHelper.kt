package za.co.dubedivine.groceryapp.config

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import za.co.dubedivine.groceryapp.model.GroceryItem
import za.co.dubedivine.groceryapp.repository.GroceryItemRepository
import javax.persistence.PrePersist

@Component
class DBHelper(private val groceryRepository: GroceryItemRepository) : CommandLineRunner {

//    @PrePersist
//    fun deleteAllBeforeSaving() {
//        groceryRepository.deleteAll()
//    }

    @Throws(Exception::class)
    override fun run(vararg args: String?) {
        groceryRepository.deleteAll()
        val items = listOf(
                GroceryItem("beans", true),
                GroceryItem("eggs", false),
                GroceryItem("milk", true),
                GroceryItem("cheese", true)
        )
        groceryRepository.saveAll(items)
    }
}