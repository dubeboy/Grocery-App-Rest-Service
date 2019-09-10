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
    fun addGroceryItem(@RequestBody groceryItem: GroceryItem): ResponseEntity<StatusResponseEntity<GroceryItem>> {
        val savedItem = groceryRepository.save(groceryItem)
        return ResponseEntity(StatusResponseEntity(
                true,
                "Added new grocery item to your list",
                savedItem
        ), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteGroceryItem(@PathVariable("id") id: Long): ResponseEntity<StatusResponseEntity<Boolean>> {
        val item = groceryRepository.findById(id)
        return when {
            item.isPresent -> {
                ResponseEntity(StatusResponseEntity(true, "deleted item ${item.get().name} from list ", null), HttpStatus.OK)
            }
            else -> {
                ResponseEntity(StatusResponseEntity(false, "sorry could not find item to delete", null), HttpStatus.NOT_FOUND)
            }
        }
    }
    @PostMapping("/available}")
    fun toggleGroceryItemAvailability(@RequestBody availability: Boolean, @RequestParam("id") id: Long): ResponseEntity<StatusResponseEntity<Boolean>> {
        val item = groceryRepository.findById(id)
        return when {
            item.isPresent -> {
                item.get().isAvailable = availability
                groceryRepository.save(item.get())
                ResponseEntity(StatusResponseEntity(true, "item ${item.get().name} is now ${if (availability) "available" else "finished"} ", null), HttpStatus.OK)
            }
            else -> {
                ResponseEntity(StatusResponseEntity(false, "sorry could not find that item", null), HttpStatus.NOT_FOUND)
            }
        }
    }
}