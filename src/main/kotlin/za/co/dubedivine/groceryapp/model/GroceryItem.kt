package za.co.dubedivine.groceryapp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class GroceryItem(var name: String, var isFinished: Boolean) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0L

    constructor(): this ("", false)
}