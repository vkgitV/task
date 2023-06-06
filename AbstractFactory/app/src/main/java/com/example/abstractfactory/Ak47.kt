package com.example.abstractfactory

 class Ak47:Weapon {
    companion object Factory:WeaponFactory(){
        override fun buildWeapon(): Ak47 {
            TODO("Not yet implemented")

        }
    }

     override fun use(): String {
         return "using Ak47 Weapon"
         TODO("Not yet implemented")
     }
 }
