package za.co.dubedivine.groceryapp.model.responseModel

data class StatusResponseEntity<T>(val status: Boolean, val message: String, val entity: T?)