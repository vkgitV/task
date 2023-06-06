package com.example.builderkt



fun main(args: Array<String>) {
    FoodOrder.Builder()
        .bread("bread")
        .condiments("condiments")
        .meat("meat")
        .fish("fish")
        .let{ println(it) }
}