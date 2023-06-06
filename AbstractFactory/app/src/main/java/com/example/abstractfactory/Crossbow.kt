package com.example.abstractfactory

class Crossbow:Weapon {
    companion object Factory:WeaponFactory(){
        override fun buildWeapon(): Crossbow {
            TODO("Not yet implemented")
        }
    }

    override fun use(): String {
        return "using crossbow weapon"
        TODO("Not yet implemented")
    }
}