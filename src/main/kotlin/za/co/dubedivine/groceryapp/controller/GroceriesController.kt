package za.co.dubedivine.groceryapp.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import za.co.dubedivine.groceryapp.model.GroceryItem
import za.co.dubedivine.groceryapp.model.responseModel.StatusResponseEntity
import za.co.dubedivine.groceryapp.repository.GroceryItemRepository

@RestController
@RequestMapping("groceries")
class GroceriesController(private val groceryRepository: GroceryItemRepository) {

    @GetMapping
    fun getGroceriesList(): MutableIterable<GroceryItem> {
        return groceryRepository.findAll()
    }

    @PutMapping
    fun addGroceryItem(@RequestBody groceryItem: GroceryItem): ResponseEntity<StatusResponseEntity<Long>> {
        val savedItem = groceryRepository.save(groceryItem)
        return ResponseEntity(StatusResponseEntity(
                true,
                "Added new grocery item to your list",
                savedItem.id
        ), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteGroceryItem(@PathVariable("id") id: Long): ResponseEntity<StatusResponseEntity<Boolean>> {
        val item = groceryRepository.findById(id)
        groceryRepository.deleteById(id)
        re
    }

    @PostMapping("/available")
    fun toggleGroceryItemAvailability(@RequestBody available: Boolean) {

    }
}