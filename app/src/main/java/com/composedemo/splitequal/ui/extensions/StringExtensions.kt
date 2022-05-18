package com.composedemo.splitequal.ui.extensions

fun String.toSafeInt() : Int{
    return try{
        toInt()
    }catch (e : Exception){
        0
    }
}

fun String.addNumber(bound : IntRange = 1..100) : String{
    return try{
      val num = toInt() + 1
      return if(num in bound){
          num.toString()
      }else{
          this
      }
    }catch (e : Exception){
        this
    }
}

fun String.subtractNumber(bound : IntRange = 1..100) : String {
    return try{
        val num = toInt() - 1
        return if(num in bound){
            num.toString()
        }else{
            this
        }
    }catch (e : Exception){
        this
    }
}

fun String.perPersonAmount(numberOfPerson: String): Int {
    return try {
        val bill = this.toInt()
        val perPerson = numberOfPerson.toInt()
        (bill / perPerson).toInt()
    } catch (e: Exception) {
        0
    }
}