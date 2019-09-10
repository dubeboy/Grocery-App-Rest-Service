package za.co.dubedivine.groceryapp.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import za.co.dubedivine.groceryapp.model.GroceryItem

@Repository
interface GroceryItemRepository: CrudRepository<GroceryItem, Long>